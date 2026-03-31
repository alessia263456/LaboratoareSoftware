package lab5;

public class IntCalculator
{
    protected int state;

    public IntCalculator(int state) {
        this.state = state;
    }

    public IntCalculator add(int x)
    {
        state=state + x;
        return this;
    }
    public IntCalculator substract(int x)
    {
        state=state - x;
        return this;
    }
    public IntCalculator multiply(int x)
    {
        state=state * x;
        return this;
    }
    public int result()
    {
        return state;
    }
    public void clear()
    {
        state=0;
    }
}
