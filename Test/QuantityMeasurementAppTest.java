import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testFeetPlusFeet() {
        QuantityLength res = new QuantityLength(1, LengthUnit.FEET)
                .add(new QuantityLength(2, LengthUnit.FEET));
        assertEquals(3.0, res.add(new QuantityLength(0, LengthUnit.FEET)).add(new QuantityLength(0, LengthUnit.FEET)).toString().contains("3.0") ? 3.0 : 0.0);
    }

    @Test
    void testFeetPlusInch() {
        QuantityLength res = new QuantityLength(1, LengthUnit.FEET)
                .add(new QuantityLength(12, LengthUnit.INCH));
        assertEquals(2.0, res.toString().contains("2.0") ? 2.0 : 0.0);
    }

    @Test
    void testInchPlusFeet() {
        QuantityLength res = QuantityLength.add(
                new QuantityLength(12, LengthUnit.INCH),
                new QuantityLength(1, LengthUnit.FEET),
                LengthUnit.INCH
        );
        assertEquals(24.0, res.toString().contains("24.0") ? 24.0 : 0.0);
    }

    @Test
    void testYardPlusFeet() {
        QuantityLength res = QuantityLength.add(
                new QuantityLength(1, LengthUnit.YARD),
                new QuantityLength(3, LengthUnit.FEET),
                LengthUnit.YARD
        );
        assertEquals(2.0, res.toString().contains("2.0") ? 2.0 : 0.0);
    }

    @Test
    void testZero() {
        QuantityLength res = new QuantityLength(5, LengthUnit.FEET)
                .add(new QuantityLength(0, LengthUnit.INCH));
        assertEquals(5.0, res.toString().contains("5.0") ? 5.0 : 0.0);
    }

    @Test
    void testNegative() {
        QuantityLength res = new QuantityLength(5, LengthUnit.FEET)
                .add(new QuantityLength(-2, LengthUnit.FEET));
        assertEquals(3.0, res.toString().contains("3.0") ? 3.0 : 0.0);
    }

    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1, LengthUnit.FEET).add(null);
        });
    }
}