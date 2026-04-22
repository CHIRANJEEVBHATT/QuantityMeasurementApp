import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityLengthTest {

    @Test
    void testEquality() {
        assertEquals(
            new QuantityLength(1.0, LengthUnit.FEET),
            new QuantityLength(12.0, LengthUnit.INCHES)
        );
    }

    @Test
    void testConvert() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.convertTo(LengthUnit.INCHES).toBase() / (1.0/12.0), 1e-6);
    }

    @Test
    void testAddSameUnit() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(2.0, LengthUnit.FEET);

        QuantityLength result = a.add(b, LengthUnit.FEET);

        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddCrossUnit() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b, LengthUnit.FEET);

        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddWithTargetUnit() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b, LengthUnit.YARDS);

        assertEquals(0.666666, result.convertTo(LengthUnit.YARDS).toBase() / 3.0, 1e-3);
    }

    @Test
    void testConvertToBaseUnit() {
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0), 1e-6);
    }

    @Test
    void testConvertFromBaseUnit() {
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0), 1e-6);
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class,
            () -> new QuantityLength(1.0, null));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class,
            () -> new QuantityLength(Double.NaN, LengthUnit.FEET));
    }
}