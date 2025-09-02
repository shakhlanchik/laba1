package demo.parallel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    void testConstructor() {
        Complex c = new Complex(3.0, 4.0);
        assertEquals(3.0, c.getReal(), 1e-10);
        assertEquals(4.0, c.getImaginary(), 1e-10);
    }

    @Test
    void testPlus() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);

        a.plus(b);

        assertEquals(3.0, a.getReal(), 1e-10);
        assertEquals(5.0, a.getImaginary(), 1e-10);
    }

    @Test
    void testTimes() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);

        a.times(b);

        assertEquals(-4.0, a.getReal(), 1e-10);  // (2*1 - 3*2) = 2-6 = -4
        assertEquals(7.0, a.getImaginary(), 1e-10);  // (2*2 + 3*1) = 4+3 = 7
    }

    @Test
    void testPower4() {
        Complex a = new Complex(2.0, 3.0);

        a.power4();

        // (2+3i)^2 = -5+12i
        // (-5+12i)^2 = -119-120i
        assertEquals(-119.0, a.getReal(), 1e-10);
        assertEquals(-120.0, a.getImaginary(), 1e-10);

        // Test with zero
        Complex zero = new Complex(0, 0);
        zero.power4();
        assertEquals(0, zero.getReal(), 1e-10);
        assertEquals(0, zero.getImaginary(), 1e-10);

        // Test with real number
        Complex real = new Complex(2, 0);
        real.power4();
        assertEquals(16.0, real.getReal(), 1e-10);
        assertEquals(0, real.getImaginary(), 1e-10);
    }

    @Test
    void testLengthSQ() {
        Complex a = new Complex(3.0, 4.0);
        assertEquals(25.0, a.lengthSQ(), 1e-10);  // 3^2 + 4^2 = 9+16=25

        Complex b = new Complex(0.0, 0.0);
        assertEquals(0.0, b.lengthSQ(), 1e-10);

        Complex c = new Complex(-3.0, -4.0);
        assertEquals(25.0, c.lengthSQ(), 1e-10);
    }

    @Test
    void testChainingOperations() {
        Complex result = new Complex(1, 2)
                .plus(new Complex(3, 4))
                .times(new Complex(2, 1))
                .power4();

        // Verify the operations were chained correctly
        // This is more of an integration test but useful to verify method chaining works
        assertNotNull(result);
    }
}