package lab4;
import java.util.*;

public class Application   {
    public static void main(String[] args)
    {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of(
                "Ioan", "Sibiu",
                "Maria", "Bucuresti",
                "Victor", "Cluj",
                "Simina", "Alba-Iulia",
                "Marius", "Medias",
                "Mihai", "Cisnadie",
                "Daniela", "Sibiu");

        System.out.println(varste);
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        System.out.println(varste);

        HashMap<String,Tanar> tineri = new HashMap<>();
        Iterator iterator=varste.keySet().iterator();
        while(iterator.hasNext())
        {
            String nume= iterator.next().toString();
            int varsta=varste.get(nume);
            String adresa=adrese.get(nume);
            tineri.put(nume,new Tanar(nume, varsta, adresa));
        }

        System.out.println(tineri);
    }
}
