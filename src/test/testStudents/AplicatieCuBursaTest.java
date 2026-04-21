package test.testStudents;
import Students.AplicatieCuBursa;
import Students.StudentBursier;
import org.junit.jupiter.api.*;

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
        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursier s1 = sortata.get(i);
            StudentBursier s2 = sortata.get(i + 1);
            int cmpFormatie = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
            if (cmpFormatie == 0)
            {
                int cmpNume = s1.getNume().compareTo(s2.getNume());
                if (cmpNume == 0)
                {
                    int cmpPrenume = s1.getPrenume().compareTo(s2.getPrenume());
                    if (cmpPrenume == 0)
                    {
                        int cmpNota = Double.compare(s1.getNota(), s2.getNota());
                        if (cmpNota == 0)
                        {
                            Assertions.assertTrue(s1.getCuantumBursa() <= s2.getCuantumBursa());
                        }
                        else
                        {
                            Assertions.assertTrue(cmpNota <= 0);
                        }
                    }
                    else
                    {
                        Assertions.assertTrue(cmpPrenume <= 0);
                    }
                }
                else
                {
                    Assertions.assertTrue(cmpNume <= 0);
                }
            }
            else
            {
                Assertions.assertTrue(cmpFormatie <= 0);
            }
        }
    }
}
