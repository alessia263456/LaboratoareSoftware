package lab5;

public class AppLab5 {

    public static void main(String[] args)
    {
        IntCalculator calculator=new IntCalculator(10);
        int result=calculator.add(5).substract(3).multiply(2).result();
        System.out.println("a) "+result);

        AdvancedCalculator calculator2=new AdvancedCalculator(10);
        int result2=calculator2.divide(2).power(2).result();
        System.out.println("b) "+result2);
    }
}
