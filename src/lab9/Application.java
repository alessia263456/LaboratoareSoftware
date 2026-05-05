package lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args)
    {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(21) + 5);
        }
        System.out.println(lista);

        Integer suma=lista.stream().reduce(0, (a,b)->a+b);
        System.out.println("suma="+suma);

        Integer maxim=lista.stream().max(Integer::compareTo).get();
        System.out.println("maxim="+maxim);

        Integer minim=lista.stream().min(Integer::compareTo).get();
        System.out.println("minim="+minim);

        List<Integer> lista2 = lista.stream()
                .filter(x->x>=10&&x<=20)
                .toList();
        System.out.println("lista2="+lista2);

        List<Double> listaDouble=lista.stream()
                .map(x->Double.valueOf(x))
                .toList();
        System.out.println("listaDouble="+listaDouble);

        Optional<Integer> item=lista.stream()
                .filter(x->x.equals(12))
                .findAny();
        if(item.isPresent())
            System.out.println("Exista 12 in lista");
        else
            System.out.println("Nu exista 12 in lista");
    }
}
