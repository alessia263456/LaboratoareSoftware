package Students;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentiDinFisierXls implements IStudentiCitire{
    String filename;
    public StudentiDinFisierXls(String filename){
        this.filename = filename;
    }
    @Override
    public void citesteDinFisier(List<Student> students) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            Workbook workbook = new HSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                int nrMatricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();

                students.add(new Student(nrMatricol, prenume, nume, formatie, nota));
            }

            fis.close();
            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
