import org.junit.Test;

import static org.example.CalculatorApp.add;
import static org.example.CalculatorApp.subtract;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(36, add(23, 13));
    }

    @Test
    public void testSubtract() {
        assertEquals(36, subtract(23, 13));
    }
}
