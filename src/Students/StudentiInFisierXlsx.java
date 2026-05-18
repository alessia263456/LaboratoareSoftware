package Students;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport{
    String filename;
    public StudentiInFisierXlsx(String filename) {
        this.filename = filename;
    }

    @Override
    public void doExport(List<Student> students){
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Studenti");
            int rowIndex = 0;
            Row header = sheet.createRow(rowIndex++);
            header.createCell(0).setCellValue("Nr Matricol");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Nume");
            header.createCell(3).setCellValue("Formatie");
            header.createCell(4).setCellValue("Nota");

            for(Student s : students) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }
            try{
            FileOutputStream fos = new FileOutputStream(filename);
            workbook.write(fos);
            fos.close();
            workbook.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}
