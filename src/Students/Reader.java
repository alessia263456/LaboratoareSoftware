package Students;

import java.util.List;

public class Reader {
    void startCitire(IStudentiCitire strategyInstance, List<Student> students){
        strategyInstance.citesteDinFisier(students);
    }

}
