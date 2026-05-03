package Students;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class Application {

    public static Student split_student(String text) {
        String[] split = text.split(",");
        int nr_matricol;
        String nume, prenume, formatie;
        nr_matricol = Integer.parseInt(split[0]);
        prenume = split[1];
        nume = split[2];
        formatie = split[3];
        return new Student(nr_matricol, prenume, nume, formatie, 0);
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
    public static void scriereFisierBursieri(Collection<StudentBursier> colectie, String FileName) throws IOException {
        Path path = Paths.get(FileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (StudentBursier s : colectie) {
                writer.write(s.toString());
                writer.newLine();

            }
        }

    }

    public static void afisareMap(Map<Integer, Student> map) {
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

    public static void mutaStudent(Map<Integer, Student> map, int nrMatricol, String formatieNoua) {
        if (map.containsKey(nrMatricol)) {
            Student s = map.get(nrMatricol);
            Student studentNou = new Student(
                    s.getNumarMatricol(),
                    s.getPrenume(),
                    s.getNume(),
                    formatieNoua,
                    s.getNota()
            );
            map.put(nrMatricol, studentNou);
        } else {
            System.out.println("Studentul cu numarul matricol " + nrMatricol + " nu a fost gasit.");
        }
    }

    public static void writeToXls(List<Student> studenti, String filename) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Studenti");
        int rowIndex = 0;
        Row header = sheet.createRow(rowIndex++);
        header.createCell(0).setCellValue("Nr Matricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("Formatie");
        header.createCell(4).setCellValue("Nota");

        for(Student s : studenti) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(s.getNumarMatricol());
            row.createCell(1).setCellValue(s.getPrenume());
            row.createCell(2).setCellValue(s.getNume());
            row.createCell(3).setCellValue(s.getFormatieDeStudiu());
            row.createCell(4).setCellValue(s.getNota());
        }
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    public static void main() throws IOException {
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

                    Student old = map_studenti.get(nr_matricol);
                    if (old != null) {
                        Student updated = new Student(
                                old.getNumarMatricol(),
                                old.getPrenume(),
                                old.getNume(),
                                old.getFormatieDeStudiu(),
                                nota
                        );
                        map_studenti.put(nr_matricol, updated);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nStudentii cu note:");
        afisareMap(map_studenti);

        double notaM = gasesteNota("Bianca", "Popescu", map_studenti);
        double notaN = gasesteNota("Ioan", "Popa", map_studenti);
        System.out.println("Bianca Popescu: " + notaM);
        System.out.println("Ioan Popa: " + notaN);

        //Lab 5

        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));
        try {
            scriereFisierBursieri(bursieri, "bursieri_out.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(StudentBursier s : bursieri) {
            System.out.println(s);
        }
        for(int i=0; i< bursieri.size(); i++)
        {
            System.out.println(bursieri.get(i));
        }

        bursieri.forEach(System.out::println);

        bursieri.forEach((Object o)->System.out.println(o));

        //lab 7
        List<Student> lista = new ArrayList<>(map_studenti.values());

        for (int i = 0; i < lista.size()/2; i++) {
            Student s = lista.get(i);
            mutaStudent(map_studenti, s.getNumarMatricol(), "Grupa 1");
        }
        for (int i = lista.size()/2; i < lista.size(); i++) {
            Student s = lista.get(i);
            mutaStudent(map_studenti, s.getNumarMatricol(), "Grupa 2");
        }

        System.out.println("\nNoua lista:");
        afisareMap(map_studenti);

        //Lab 8
        String xlsFileName="laborator8_students.xls";
        writeToXls(lista,xlsFileName);


    }

}

