package lab6.advanced;

public class NewIntCalculator extends ACalculator<Integer> {

    @Override
    public NewIntCalculator init() {
        state = 0;
        return this;
    }

    public  NewIntCalculator add(Integer a) {
        state = (Integer)state + a;
        return this;
    }

    public  NewIntCalculator subtract(Integer a) {
        state = (Integer)state - a;
        return this;
    }
    public  NewIntCalculator multiply(Integer a) {
        state = (Integer)state * a;
        return this;
    }
    public  NewIntCalculator divide(Integer a) {
        state = (Integer)state / a;
        return this;
    }
}
