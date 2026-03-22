package lab2;
import java.util.*;

public class Application
{
    public static void main()
    {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        for(int i=0; i<5; i++)
            x.add((int) (Math.random()*11));
        for(int i=0; i<7; i++)
            y.add((int) (Math.random()*11));

        Collections.sort(x);
        System.out.println("x: " + x);
        Collections.sort(y);
        System.out.println("y: " + y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("xPlusY: "+xPlusY);

        for(int i=0; i<5; i++)
        {
            if(y.contains(x.get(i)))
            {
                zSet.add(x.get(i));
            }
        }
        System.out.println("zSet: "+zSet);

        for(int i=0; i<5; i++)
        {
            if(!y.contains(x.get(i)))
            {
                xMinusY.add(x.get(i));
            }
        }
        System.out.println("xMinusY: "+xMinusY);

        for (Integer integer : xPlusY) {
            if (integer <= p) {
                xPlusYLimitedByP.add(integer);
            }
        }
        System.out.println("xPlusYLimitedByP: "+xPlusYLimitedByP);
    }
}
