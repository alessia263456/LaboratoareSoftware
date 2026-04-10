package lab6.advanced;
import org.junit.jupiter.api.*;

public class NewIntCalculatorTest {
    private NewIntCalculator calculator;
    @BeforeEach
    public void setup() {
        calculator = new NewIntCalculator();
    }
    @Test
    public void testAddPositives()
    {
        //arrange
        calculator.init();
        //act
        calculator.add(5);
        //assert
        Assertions.assertEquals(5, calculator.result());
    }

    @Test
    public void testAddNegatives()
    {
        //arrange
        calculator.init();
        //act
        calculator.add(-5);
        //assert
        Assertions.assertEquals(-5, calculator.result());

    }

    @Test
    public void testSubstractPositives()
    {
        //arrange
        calculator.init();
        //act
        calculator.subtract(5);
        //assert
        Assertions.assertEquals(-5, calculator.result());
    }

    @Test
    public void testSubstractNegatives()
    {
        //arrange
        calculator.init();
        //act
        calculator.subtract(-5);
        //assert
        Assertions.assertEquals(5, calculator.result());
    }

    @Test
    public void testMultiplyPositives()
    {
        //arrange
        calculator.init();
        calculator.add(1);
        //act
        calculator.multiply(5);
        calculator.multiply(3);
        //assert
        Assertions.assertEquals(15, calculator.result());
    }

    @Test
    public void testMultiplyNegatives()
    {
        //arrange
        calculator.init();
        calculator.add(1);
        //act
        calculator.multiply(-5);
        calculator.multiply(-3);
        //assert
        Assertions.assertEquals(15, calculator.result());
    }

    @Test
    public void testMultiplyBy0()
    {
        //arrange
        calculator.init();
        calculator.add(1);
        //act
        calculator.multiply(5);
        calculator.multiply(0);
        //assert
        Assertions.assertEquals(0, calculator.result());

    }

    @Test
    public void testDividePositives()
    {
        //arrange
        calculator.init();
        calculator.add(10);
        //act
        calculator.divide(2);
        //assert
        Assertions.assertEquals(5, calculator.result());

    }

    @Test
    public void testDivideNegatives()
    {
        //arrange
        calculator.init();
        calculator.add(-10);
        //act
        calculator.divide(-2);
        //assert
        Assertions.assertEquals(5, calculator.result());

    }

    @Test
    public void testDivideBy0()
    {
        calculator.init();
        calculator.add(1);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(0));
    }

    @AfterEach
    public void teardown()
    {
        calculator = null;
    }
}
