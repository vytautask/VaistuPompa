package vaistupompa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vytautas
 */
public class GeneratorTest {

    private IGenerator createGenerator()
    {
        return new Generator(10, 15);
    }

    public GeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of generate method, of class Generator.
     */
    @Test
    public void testGenerate_double() {
        double x1 = 14.13;
        IGenerator instance = this.createGenerator();
        double result = instance.generate(x1);

        IGeneratorValue val = instance.getGeneratedValues().get(0);

        assertEquals(val.getX1(), x1, 0.0);
        assertEquals(val.getTime(), result, 0.0);
    }

    /**
     * Test of generate method, of class Generator.
     */
    @Test
    public void testGenerate_double_double() {
        double x1 = 15.2;
        double x2 = 36.45;
        IGenerator instance = this.createGenerator();
        
        double result = instance.generate(x1, x2);

        IGeneratorValue val = instance.getGeneratedValues().get(0);

        assertEquals(val.getX1(), x1, 0.0);
        assertEquals(val.getTime(), result, 0.0);
        assertEquals(val.getX2(), x2, 0.0);
    }

    /**
     * Test of generate method, of class Generator.
     */
    @Test
    public void testGenerate_3args() {
        double x1 = 14.23;
        double x2 = 19.123;
        double x3 = 64.234;
        IGenerator instance = this.createGenerator();
        
        double result = instance.generate(x1, x2, x3);

        IGeneratorValue val = instance.getGeneratedValues().get(0);

        assertEquals(val.getX1(), x1, 0.0);
        assertEquals(val.getTime(), result, 0.0);
        assertEquals(val.getX2(), x2, 0.0);
        assertEquals(val.getX3(), x3, 0.0);
    }
}