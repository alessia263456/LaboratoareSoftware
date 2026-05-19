package Students.strategy;

import Students.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1", 10),
                new Student(1029,"Maria","Pana","TI131/2", 4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2", 7.33),
                new Student(1029,"Marius","Nasta","TI131/2", 3.20),
                new Student(1029,"Marius","Nasta","TI131/1", 5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2", 2.22)
        );
        System.out.println("a) Afisare in consola");
        IStudentiExport strategyConsole=new StudentiInConsola();
        Exporter exporter=new Exporter();
        exporter.setStrategy(strategyConsole);
        exporter.startExport(studenti);

        System.out.println("b) Afisare in fisier txt");
        String fileName= "studentiStrategyText.txt";

        IStudentiExport strategyFisierText = new StudentiInFisierText(fileName);
        exporter.setStrategy(strategyFisierText);
        exporter.startExport( studenti);

        System.out.println("c) Afisare in fisier xls");
        fileName = "studentiStrategyExcel.xls";
        IStudentiExport strategyFisierExcel = new StudentiInFisierXlsx(fileName);
        exporter.setStrategy(strategyFisierExcel);
        exporter.startExport(studenti);

        System.out.println("d) Citire din fisier txt");
        fileName = "studentiCuNote_in.txt";
        Reader reader=new Reader();
        StudentiDinFisierText strategyReadTxtFile=new StudentiDinFisierText(fileName);
        List<Student> studentiCititiDinTxt=new ArrayList<>();
        reader.startCitire(strategyReadTxtFile, studentiCititiDinTxt);
        studentiCititiDinTxt.forEach(System.out::println);

        System.out.println("e) Citire din fisier xls");
        fileName="studentiStrategyExcel.xls";
        StudentiDinFisierXls strategyReadXlsFile=new StudentiDinFisierXls(fileName);
        List<Student> studentiCititiDinXls=new ArrayList<>();
        reader.startCitire(strategyReadXlsFile, studentiCititiDinXls);
        studentiCititiDinXls.forEach(System.out::println);

    }
}
