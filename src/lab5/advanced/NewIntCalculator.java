package lab5.advanced;

public class NewIntCalculator extends ACalculator
{
    @Override
    public void init(Object state)
    {
        this.state=state;
    }

    public NewIntCalculator add(int x)
    {
        state=(Integer)state+x;
        return this;
    }
    public NewIntCalculator substract(int x)
    {
        state=(Integer)state-x;
        return this;
    }
    public NewIntCalculator multiply(int x)
    {
        state=(Integer)state*x;
        return this;
    }
}
