package Students.decorator;

import Students.Student;
import Students.strategy.IStudentiExport;

import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private List<Student> studenti;

    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }

    public long executionTime()
    {
        long execTime=super.executionTime(studenti);
        return execTime;
    }
}
