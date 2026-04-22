import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    private static final double EPS = 1e-6;

    // ✅ Equality Tests

    @Test
    void testKgToGramEquality() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight gram = new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void testKgToPoundEquality() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight pound = new QuantityWeight(2.20462, WeightUnit.POUND);

        assertTrue(kg.equals(pound));
    }

    @Test
    void testNotEqual() {
        QuantityWeight a = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        assertNotEquals(a, b);
    }

    // ✅ Conversion Tests

    @Test
    void testKgToGramConversion() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight result = kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), EPS);
    }

    @Test
    void testPoundToKgConversion() {
        QuantityWeight pound = new QuantityWeight(2.0, WeightUnit.POUND);

        QuantityWeight result = pound.convertTo(WeightUnit.KILOGRAM);

        assertEquals(0.907184, result.getValue(), 1e-3);
    }

    // ✅ Addition Tests

    @Test
    void testAddSameUnit() {
        QuantityWeight a = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        QuantityWeight result = a.add(b);

        assertEquals(3.0, result.getValue(), EPS);
    }

    @Test
    void testAddDifferentUnits() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight gram = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = kg.add(gram);

        assertEquals(2.0, result.getValue(), EPS);
    }

    @Test
    void testAddWithTargetUnit() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight gram = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = kg.add(gram, WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), EPS);
    }

    // ✅ Edge Cases

    @Test
    void testZero() {
        QuantityWeight zero = new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        QuantityWeight result = zero.convertTo(WeightUnit.GRAM);

        assertEquals(0.0, result.getValue(), EPS);
    }

    @Test
    void testNegative() {
        QuantityWeight a = new QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = a.add(b);

        assertEquals(0.0, result.getValue(), EPS);
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityWeight(1.0, null)
        );
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM)
        );
    }
}