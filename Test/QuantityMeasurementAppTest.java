import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testFeetTarget() {
        QuantityLength res = QuantityLength.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCH),
                LengthUnit.FEET
        );
        assertEquals(2.0, QuantityLength.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCH),
                LengthUnit.FEET
        ).equals(res) ? 2.0 : 0.0);
    }

    @Test
    void testInchTarget() {
        QuantityLength res = QuantityLength.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCH),
                LengthUnit.INCH
        );
        assertEquals(24.0, res.toString().contains("24.0") ? 24.0 : 0.0);
    }

    @Test
    void testYardTarget() {
        QuantityLength res = QuantityLength.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCH),
                LengthUnit.YARD
        );
        assertTrue(res.toString().contains("0.66"));
    }

    @Test
    void testCommutative() {
        QuantityLength a = QuantityLength.add(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCH),
                LengthUnit.YARD
        );

        QuantityLength b = QuantityLength.add(
                new QuantityLength(12, LengthUnit.INCH),
                new QuantityLength(1, LengthUnit.FEET),
                LengthUnit.YARD
        );

        assertTrue(a.equals(b));
    }

    @Test
    void testZero() {
        QuantityLength res = QuantityLength.add(
                new QuantityLength(5, LengthUnit.FEET),
                new QuantityLength(0, LengthUnit.INCH),
                LengthUnit.YARD
        );
        assertTrue(res.toString().contains("1.66"));
    }

    @Test
    void testNegative() {
        QuantityLength res = QuantityLength.add(
                new QuantityLength(5, LengthUnit.FEET),
                new QuantityLength(-2, LengthUnit.FEET),
                LengthUnit.INCH
        );
        assertTrue(res.toString().contains("36.0"));
    }

    @Test
    void testNullTarget() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(
                    new QuantityLength(1, LengthUnit.FEET),
                    new QuantityLength(12, LengthUnit.INCH),
                    null
            );
        });
    }
}