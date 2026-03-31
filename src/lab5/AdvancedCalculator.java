package lab5;

public class AdvancedCalculator extends IntCalculator{

    public AdvancedCalculator(int state)
    {
        super(state);
    }

    public AdvancedCalculator divide(int x)
    {
        if (x == 0)
        {
            throw new ArithmeticException("Division by zero");
        }
        state=state / x;
        return this;
    }

    public AdvancedCalculator power(int x)
    {
        state= (int) Math.pow(state,x);
        return this;
    }

    public AdvancedCalculator sqrt_n(int x)
    {
        state= (int) Math.pow(state,1/x);
        return this;
    }
}
