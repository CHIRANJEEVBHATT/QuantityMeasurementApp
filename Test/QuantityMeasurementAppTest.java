import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testFeetToInches() {
        assertEquals(12.0, QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH), EPS);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0, QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET), EPS);
    }

    @Test
    void testYardToInch() {
        assertEquals(36.0, QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.INCH), EPS);
    }

    @Test
    void testCmToInch() {
        assertEquals(1.0, QuantityLength.convert(2.54, LengthUnit.CM, LengthUnit.INCH), 1e-3);
    }

    @Test
    void testRoundTrip() {
        double val = 5.0;
        double converted = QuantityLength.convert(val, LengthUnit.FEET, LengthUnit.INCH);
        double back = QuantityLength.convert(converted, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(val, back, EPS);
    }

    @Test
    void testZero() {
        assertEquals(0.0, QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH), EPS);
    }

    @Test
    void testNegative() {
        assertEquals(-12.0, QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH), EPS);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityLength.convert(1.0, null, LengthUnit.FEET));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH));
    }
}