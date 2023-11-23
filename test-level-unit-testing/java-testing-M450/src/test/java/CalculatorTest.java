import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(8, calculator.add(5, 3), "5 + 3 should equal 8");
    }

    @Test
    public void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5), "10 - 5 should equal 5");
    }

    @Test
    public void testMultiply() {
        assertEquals(30, calculator.multiply(5, 6), "5 * 6 should equal 30");
    }

    @Test
    public void testDivide() {
        assertEquals(5, calculator.divide(10, 2), "10 / 2 should equal 5");
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0), "Division by zero should throw IllegalArgumentException");
    }
}