package Students.strategy;

import Students.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class StudentiDinFisierText implements  IStudentiCitire {
    String filename;

    public StudentiDinFisierText(String filename){
        this.filename = filename;
    }


    @Override
    public void citesteDinFisier(List<Student> students) {
        String text_citit = "";
        try {
            Path path = Paths.get(filename);
            try (Scanner sc = new Scanner(path)) {
                while (sc.hasNextLine()) {
                    text_citit = sc.nextLine();
                    String[] split = text_citit.split(",");
                    int nr_matricol;
                    double nota;
                    String nume, prenume, formatie;
                    nr_matricol = Integer.parseInt(split[0]);
                    prenume = split[1];
                    nume = split[2];
                    formatie = split[3];
                    nota=Double.parseDouble(split[4]);
                    students.add( new Student(nr_matricol, prenume, nume, formatie, nota));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
