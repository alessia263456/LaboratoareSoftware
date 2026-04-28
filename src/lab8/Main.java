package lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class Main {

    public static void afisareSheet(XSSFSheet sheet) {
        Iterator<Row> rowIterator=sheet.iterator();

        while(rowIterator.hasNext())
        {
            Row row=rowIterator.next();

            Iterator<Cell> cellIterator=row.cellIterator();

            while(cellIterator.hasNext())
            {
                Cell cell=cellIterator.next();

                switch(cell.getCellType())
                {
                    case CellType.NUMERIC:
                        System.out.print(cell.getNumericCellValue()+" | ");
                        break;
                    case CellType.STRING:
                        System.out.print(cell.getStringCellValue()+" | ");
                        break;

                }
            }
            System.out.println("");
        }
    }

    public static void medieNote(String filename)
    {

    }

    public static void main(String[] args) throws IOException {
        FileInputStream file=new FileInputStream(new File("src/lab8/laborator8_input.xlsx"));
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheetAt(0);
        afisareSheet(sheet);
        file.close();
    }
}
