package Students.strategy;

import Students.Student;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    public void doExport(List<Student> students)
    {
        students.forEach(System.out::println);
    }
}
