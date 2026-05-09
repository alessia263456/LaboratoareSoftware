package lab9;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        System.out.println("9.3.1");
        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(21) + 5);
        }
        System.out.println(lista);

        Integer suma = lista.stream().reduce(0, (a, b) -> a + b);
        System.out.println("a) suma=" + suma);

        Integer maxim = lista.stream().max(Integer::compareTo).get();
        System.out.println("b) maxim=" + maxim);

        Integer minim = lista.stream().min(Integer::compareTo).get();
        System.out.println("minim=" + minim);

        List<Integer> lista2 = lista.stream()
                .filter(x -> x >= 10 && x <= 20)
                .toList();
        System.out.println("c) lista2=" + lista2);

        List<Double> listaDouble = lista.stream()
                .map(x -> Double.valueOf(x))
                .toList();
        System.out.println("d) listaDouble=" + listaDouble);

        Optional<Integer> item = lista.stream()
                .filter(x -> x.equals(12))
                .findAny();
        if (item.isPresent())
            System.out.println("e) Exista 12 in lista");
        else
            System.out.println("e) Nu exista 12 in lista");

        System.out.println("\n9.3.2");

        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.stream(text.split(" ")).toList();
        System.out.println(cuvinte);

        List<String> cuvinteFitrate =cuvinte.stream()
                .filter(s->s.length()>=5)
                .toList();
        long ctCuvinteFiltrate=cuvinte.stream()
                .filter(s->s.length()>=5)
                .count();
        System.out.println("a)");
        System.out.println("Lista cuvinte cu lungime >=5 : "+ cuvinteFitrate);
        System.out.println("Numar cuvinte: "+ctCuvinteFiltrate);

        List<String> listaSortata= cuvinteFitrate.stream()
                .sorted()
                .toList();
        System.out.println("b) Lista sortata: "+listaSortata);
    }
}
