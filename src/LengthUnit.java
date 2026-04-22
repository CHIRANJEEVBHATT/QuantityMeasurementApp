// LengthUnit.java (Standalone Enum)

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double factor; // relative to feet

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double convertToBaseUnit(double value) {
        return value * factor; // convert to feet
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor; // convert from feet
    }

    public double getFactor() {
        return factor;
    }
}