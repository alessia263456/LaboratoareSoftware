package Students;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {

    public static Student split_student(String text) {
        String[] split = text.split(",");
        int nr_matricol;
        String nume, prenume, formatie;
        nr_matricol = Integer.parseInt(split[0]);
        prenume = split[1];
        nume = split[2];
        formatie = split[3];
        return new Student(nr_matricol, prenume, nume, formatie);
    }

    public static void citireFisier(List<Student> lista, String FileName) {
        String text_citit = "";
        try {
            Path path = Paths.get(FileName);
            try (Scanner sc = new Scanner(path)) {
                while (sc.hasNextLine()) {
                    text_citit = sc.nextLine();
                    lista.add(split_student(text_citit));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void afisareLista(List<Student> lista) {
        for (Student s : lista) {
            System.out.println(s);
        }
    }

    public static void scriereFisier(Collection<Student> colectie, String FileName) throws IOException {
        Path path = Paths.get(FileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Student s : colectie) {
                writer.write(s.toString());
                writer.newLine();

            }
        }

    }

    public static void Afisare_Map(Map<Integer, Student> map) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()).toString());
        }
    }

    public static double gasesteNota(String prenume, String nume, Map<Integer, Student> studenti) {
        Map<String, Student> aux_studenti = new HashMap<>();
        String key;
        for (Student s : studenti.values()) {
            key = s.getPrenume() + " " + s.getNume();
            aux_studenti.put(key, s);
        }

        key = prenume + " " + nume;
        if (aux_studenti.containsKey(key)) {
            return aux_studenti.get(key).getNota();
        } else
            return 0;
    }

    public static void main() {
        List<Student> lista_studenti = new ArrayList<>();
        citireFisier(lista_studenti, "studenti_in.txt");
        afisareLista(lista_studenti);
        Collections.sort(lista_studenti,
                new Comparator<Student>() {
                    public int compare(Student s1, Student s2) {
                        return s1.getNume().compareTo((s2.getNume()));
                    }
                });


        try {
            scriereFisier(lista_studenti, "studenti_out.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(lista_studenti);
        lista_studenti.sort(
                Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume)
        );

        try {
            scriereFisier(lista_studenti, "studenti_out_sorted.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //lab 4

        Map<Integer, Student> map_studenti = new HashMap<Integer, Student>();
        for (Student s : lista_studenti) {
            map_studenti.put(s.getNumarMatricol(), s);
        }
        System.out.println(map_studenti);

        String text_citit = "";
        try {
            Path path = Paths.get("src/Students/note_anon.txt");
            try (Scanner sc = new Scanner(path)) {
                while (sc.hasNextLine()) {
                    text_citit = sc.nextLine();
                    String[] split = text_citit.split(",");
                    Integer nr_matricol = Integer.parseInt(split[0]);
                    float nota = Float.parseFloat(split[1]);
                    map_studenti.get(nr_matricol).setNota(nota);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nStudentii cu note:");
        Afisare_Map(map_studenti);

        double notaM = gasesteNota("Bianca", "Popescu", map_studenti);
        double notaN = gasesteNota("Ioan", "Popa", map_studenti);
        System.out.println("Bianca Popescu: " + notaM);
        System.out.println("Ioan Popa: " + notaN);

        //Lab 5

        List<Student> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10, 780.80));
        try {
            scriereFisier(bursieri, "bursieri_out.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Student s : bursieri) {
            System.out.println(s);
        }
        for(int i=0; i< bursieri.size(); i++)
        {
            System.out.println(bursieri.get(i));
        }

        bursieri.forEach(System.out::println);

        bursieri.forEach((Object o)->System.out.println(o));
    }

}

