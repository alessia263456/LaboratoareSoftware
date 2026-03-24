package Students;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {

    public static Student split_student(String text)
    {
        String[] split = text.split(",");
        int nr_matricol;
        String nume, prenume, formatie;
        nr_matricol = Integer.parseInt(split[0]);
        prenume = split[1];
        nume = split[2];
        formatie = split[3];
        return new Student(nr_matricol, prenume, nume, formatie);
    }

    public static void Citire_Fisier(List<Student> lista, String FileName)
    {
        String text_citit = "";
        try
        {
            Path path= Paths.get(FileName);
            try(Scanner sc=new Scanner(path))
            {
                while (sc.hasNextLine())
                {
                    text_citit=sc.nextLine();
                    lista.add(split_student(text_citit));
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void Afisare_lista(List<Student> lista)
    {
        for(Student s: lista)
        {
            System.out.println(s);
        }
    }

    public static void Scriere_fisier(List<Student> lista, String FileName) throws IOException
    {
        Path path= Paths.get(FileName);
        try(BufferedWriter writer=Files.newBufferedWriter(path))
        {
            for(Student s: lista)
            {
                writer.write(s.toString());
                writer.newLine();
            }
        }

    }

    public static void Afisare_Map(Map<Integer, Student> map)
    {
        Iterator iterator=map.keySet().iterator();
        while(iterator.hasNext())
        {
            System.out.println(map.get(iterator.next()).toString());
        }
    }
    public static void main() {
        List<Student> lista_studenti = new ArrayList<>();
        Citire_Fisier(lista_studenti,"studenti_in.txt");
        Afisare_lista(lista_studenti);
        Collections.sort(lista_studenti,
                new Comparator<Student>()
                {
                    public int compare(Student s1, Student s2)
                    {
                        return s1.getNume().compareTo((s2.getNume()));
                    }
                });


        try
        {
            Scriere_fisier(lista_studenti, "studenti_out.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(lista_studenti);
        lista_studenti.sort(
                Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume)
        );

        try
        {
            Scriere_fisier(lista_studenti, "studenti_out_sorted.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //lab 4

        HashMap<Integer,Student> map_studenti=new HashMap<Integer, Student>();
        for(Student s: lista_studenti)
        {
            map_studenti.put(s.getNumarMatricol(),s);
        }
        System.out.println(map_studenti);

        String text_citit = "";
        try
        {
            Path path= Paths.get("src/Students/note_anon.txt");
            try(Scanner sc=new Scanner(path))
            {
                while (sc.hasNextLine())
                {
                    text_citit=sc.nextLine();
                    String[] split=text_citit.split(",");
                    Integer nr_matricol=Integer.parseInt(split[0]);
                    float nota=Float.parseFloat(split[1]);
                    map_studenti.get(nr_matricol).setNota(nota);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("\nStudentii cu note:");
        Afisare_Map(map_studenti);

    }
}
