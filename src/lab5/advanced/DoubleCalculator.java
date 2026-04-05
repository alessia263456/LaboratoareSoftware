package lab5.advanced;

public class DoubleCalculator extends ACalculator
{
    @Override
    public void init(Object state)
    {
        this.state=state;
    }
    public DoubleCalculator add(Double x)
    {
        state=(Double)state+x;
        return this;
    }
    public DoubleCalculator substract(Double x)
    {
        state=(Double)state-x;
        return this;
    }
    public DoubleCalculator multiply(Double x)
    {
        state=(double)state*x;
        return this;
    }
}
