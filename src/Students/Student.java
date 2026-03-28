package Students;

import java.util.Objects;

public class Student implements Comparable<Student>
{
    private Integer numarMatricol;
    private String prenume, nume, formatieDeStudiu;
    private float nota;

    Student(Integer numarMatricol, String prenume, String nume, String formatieDeStudiu)
    {
        this.numarMatricol=numarMatricol;
        this.prenume=prenume;
        this.nume=nume;
        this.formatieDeStudiu=formatieDeStudiu;
    }

    public Integer getNumarMatricol() {
        return numarMatricol;
    }
    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public float getNota()
    {
        return nota;
    }
    public void setNota(float nota)
    {
        this.nota=nota;
    }


    @Override
    public String toString()
    {
        return String.format("%15d %15s %15s %15s %15s", numarMatricol, prenume, nume, formatieDeStudiu, nota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return Objects.equals(numarMatricol, s.numarMatricol) &&
                Objects.equals(prenume, s.prenume) &&
                Objects.equals(nume, s.nume) &&
                Objects.equals(formatieDeStudiu, s.formatieDeStudiu) &&
                Objects.equals(nota, s.nota);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu, nota);
    }

    @Override
    public int compareTo(Student s) {
        if(formatieDeStudiu.equals(s.getFormatieDeStudiu()))
        {
            return nume.compareTo(s.getNume());
        }
        else
        {
            return formatieDeStudiu.compareTo(s.getFormatieDeStudiu());
        }
    }
}
