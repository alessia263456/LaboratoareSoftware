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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(cuantumBursa, that.cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString() + ", cuantum bursa = " + cuantumBursa;
    }


}
