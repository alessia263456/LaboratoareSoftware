package Students.strategy;

import Students.Student;

import java.util.List;

public class Reader {
    public void startCitire(IStudentiCitire strategyInstance, List<Student> students){
        strategyInstance.citesteDinFisier(students);
    }

}
