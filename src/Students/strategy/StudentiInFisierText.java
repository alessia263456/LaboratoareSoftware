package Students.strategy;

import Students.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {

    String filename;
    public StudentiInFisierText(String filename) {
        this.filename = filename;
    }
    @Override
    public void doExport(List<Student> students) {
        Path path= Paths.get(filename);
        try(BufferedWriter writer= Files.newBufferedWriter(path)){
            for(Student student:students){
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
