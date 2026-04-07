package Students;

import java.util.Objects;

public class StudentBursier extends Student {
    double cuantumBursa;

    public StudentBursier(Integer numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double cuantumBursa)
    {
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumBursa = cuantumBursa;
        setNota(13);
    }

    public void setNota(double nota)
    {
        super.setNota(nota);
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
