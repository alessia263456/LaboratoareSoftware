package Students.decorator;

import Students.Student;
import Students.strategy.IStudentiExport;

import java.util.List;

public class TimeExecutionDecorator implements IStudentiExport {

    private final IStudentiExport exporter;

    public TimeExecutionDecorator(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public void doExport(List<Student> studenti) {
        long start = System.currentTimeMillis();

        exporter.doExport(studenti);

        long end = System.currentTimeMillis();

        System.out.println(
                "Execution time: " + (end - start) + " ms");
    }
}