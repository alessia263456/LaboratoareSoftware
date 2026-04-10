package lab6.advanced;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;
    @BeforeEach
    public void setup() {
        calculator = new DoubleCalculator();
    }
    @Test
    public void testAddPositives()
    {
        //arrange
        calculator.init();
        //act
        calculator.add(5.3);
        //assert
        Assertions.assertEquals(5.3, calculator.result());
    }

    @Test
    public void testAddNegatives()
    {
        //arrange
        calculator.init();
        //act
        calculator.add(-5.3);
        //assert
        Assertions.assertEquals(-5.3, calculator.result());

    }

    @Test
    public void testSubstractPositives()
    {
        //arrange
        calculator.init();
        //act
        calculator.subtract(5.3);
        //assert
        Assertions.assertEquals(-5.3, calculator.result());
    }

    @Test
    public void testSubstractNegatives()
    {
        //arrange
        calculator.init();
        //act
        calculator.subtract(-5.3);
        //assert
        Assertions.assertEquals(5.3, calculator.result());
    }

    @Test
    public void testMultiplyPositives()
    {
        //arrange
        calculator.init();
        calculator.add(1.0);
        //act
        calculator.multiply(5.0);
        calculator.multiply(3.0);
        //assert
        Assertions.assertEquals(15, calculator.result());
    }

    @Test
    public void testMultiplyNegatives()
    {
        //arrange
        calculator.init();
        calculator.add(1.0);
        //act
        calculator.multiply(-5.0);
        calculator.multiply(-3.0);
        //assert
        Assertions.assertEquals(15, calculator.result());
    }

    @Test
    public void testMultiplyBy0()
    {
        //arrange
        calculator.init();
        calculator.add(1.0);
        //act
        calculator.multiply(5.0);
        calculator.multiply(0.0);
        //assert
        Assertions.assertEquals(0, calculator.result());

    }

    @Test
    public void testDividePositives()
    {
        //arrange
        calculator.init();
        calculator.add(10.0);
        //act
        calculator.divide(2.0);
        //assert
        Assertions.assertEquals(5, calculator.result());

    }

    @Test
    public void testDivideNegatives()
    {
        //arrange
        calculator.init();
        calculator.add(-10.0);
        //act
        calculator.divide(-2.0);
        //assert
        Assertions.assertEquals(5, calculator.result());

    }

    @Test
    public void testDivideBy0()
    {
        calculator.init();
        calculator.add(1.0);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(0.0));
    }

    @AfterEach
    public void teardown()
    {
        calculator = null;
    }

}
