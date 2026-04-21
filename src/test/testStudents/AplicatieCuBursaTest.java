package test.testStudents;
import Students.AplicatieCuBursa;
import Students.StudentBursier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AplicatieCuBursaTest {
    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest() {
        //arrange
        List<StudentBursier> lista = new ArrayList<>();
        lista.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        lista.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10, 780.80));
        lista.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10, 100.00));

        //act
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        //assert
        Assertions.assertEquals(sortata.get(0).getPrenume(), "Ioan");
        Assertions.assertEquals(sortata.get(1).getPrenume(), "Andrei");
        Assertions.assertEquals(sortata.get(2).getPrenume(), "Anamaria");
        Assertions.assertEquals(sortata.get(3).getCuantumBursa(), 100.0);
        Assertions.assertEquals(sortata.get(4).getCuantumBursa(), 780.8);

    }
}
