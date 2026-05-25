package Students.decorator;

import Students.Student;
import Students.strategy.IStudentiExport;

import java.util.List;

public class TimeExecution implements ITimeExecution {
    IStudentiExport exporter;

    @Override
    public long executionTime(List<Student> studenti) {
        long time=System.currentTimeMillis();
        exporter.doExport(studenti);
        return System.currentTimeMillis()-time;
    }

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }
}
