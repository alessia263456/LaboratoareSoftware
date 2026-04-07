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

        //act

        //assert
    }

    @Test
    public void testAddNegatives(){}

    @Test
    public void testSubstractPositives(){}

    @Test
    public void testSubstractNegatives(){}

    @Test
    public void testMultiplyPositives(){}

    @Test
    public void testMultiplyNegatives(){}

    @Test
    public void testMultiplyBy0()
    {
        //arrange

        //act

        //assert
    }

    @Test
    public void testDividePositives(){}

    @Test
    public void testDivideNegatives(){}

    @Test
    public void testDivideBy0(){}

    @AfterEach
    public void teardown()
    {
        calculator = null;
    }
}
