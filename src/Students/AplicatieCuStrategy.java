package Students;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1,", 10),
                new Student(1029,"Maria","Pana","TI131/2", 4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2,", 7.33),
                new Student(1029,"Marius","Nasta","TI131/2", 3.20),
                new Student(1029,"Marius","Nasta","TI131/1", 5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2", 2.22)
        );
        System.out.println("a) Afisare in consola");
        IStudentiExport strategyConsole=new StudentiInConsola();
        Exporter exporter=new Exporter();
        exporter.startExport(strategyConsole, studenti);

        System.out.println("b) Afisare in fisier txt");
        String fileName = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(fileName);
        exporter.startExport(strategyFisierText, studenti);
    }
}
