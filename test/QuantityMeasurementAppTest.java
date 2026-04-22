import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testYardToYard_Same() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(1.0, LengthUnit.YARD)));
    }

    @Test
    void testYardToFeet() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(3.0, LengthUnit.FEET)));
    }

    @Test
    void testYardToInch() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(36.0, LengthUnit.INCH)));
    }

    @Test
    void testCmToInch() {
        assertTrue(new QuantityLength(1.0, LengthUnit.CM)
                .equals(new QuantityLength(0.393701, LengthUnit.INCH)));
    }

    @Test
    void testDifferentValues() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(2.0, LengthUnit.FEET)));
    }

    @Test
    void testNullComparison() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.YARD);
        assertFalse(q.equals(null));
    }
}