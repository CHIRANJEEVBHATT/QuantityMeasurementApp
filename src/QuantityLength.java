// QuantityLength.java

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double toBase() {
        return unit.convertToBaseUnit(value);
    }

    public QuantityLength convertTo(LengthUnit target) {
        if (target == null) {
            throw new IllegalArgumentException("Target unit null");
        }
        double base = toBase();
        double converted = target.convertFromBaseUnit(base);
        return new QuantityLength(converted, target);
    }

    public QuantityLength add(QuantityLength other, LengthUnit target) {
        if (other == null || target == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase = this.toBase() + other.toBase();
        double result = target.convertFromBaseUnit(sumBase);

        return new QuantityLength(result, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;
        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}