package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args)
    {
        NewIntCalculator intCalculator = new NewIntCalculator();
        DoubleCalculator doubleCalculator = new DoubleCalculator();
        intCalculator.init(10);
        doubleCalculator.init(10.0);

        System.out.println(intCalculator.add(5).substract(3).multiply(2).result());
        System.out.println(doubleCalculator.add(5.0).substract(3.3).multiply(2.2).result());

    }


}
