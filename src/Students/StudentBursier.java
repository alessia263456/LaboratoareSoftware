package Students;

import java.util.Objects;

public class StudentBursier{
    private final Student student;
    private final double cuantumBursa;

    public StudentBursier(Integer numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double cuantumBursa)
    {
        student=new Student(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumBursa = cuantumBursa;
    }
    public Integer getNumarMatricol() {
        return student.getNumarMatricol();
    }
    public String getPrenume() {
        return student.getPrenume();
    }

    public String getNume() {
        return student.getNume();
    }

    public String getFormatieDeStudiu() {
        return student.getFormatieDeStudiu();
    }

    public double getNota()
    {
        return student.getNota();
    }

    public double getCuantumBursa()
    {
        return cuantumBursa;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StudentBursier that)) return false;
        return Double.compare(getCuantumBursa(), that.getCuantumBursa()) == 0 && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {
        return student.toString() + ", cuantum bursa = " + cuantumBursa;
    }


}
