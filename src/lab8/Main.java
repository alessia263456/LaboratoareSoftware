package lab8;

import java.io.*;

import java.util.Iterator;

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
            System.out.println();
        }
        System.out.println();
    }

    public static void medieNote1(XSSFSheet sourceSheet, XSSFWorkbook destinationWorkbook) throws IOException {
        XSSFSheet destSheet=destinationWorkbook.createSheet();
        Iterator<Row> rowIterator = sourceSheet.iterator();
        int rowIndex = 0;
        while (rowIterator.hasNext()) {
            Row sourceRow = rowIterator.next();
            Row destRow = destSheet.createRow(rowIndex);

            int lastCell = sourceRow.getLastCellNum();
            for (int i = 0; i < lastCell; i++) {
                Cell sourceCell = sourceRow.getCell(i);
                Cell destCell = destRow.createCell(i);

                if (sourceCell != null) {
                    switch (sourceCell.getCellType()) {
                        case STRING:
                            destCell.setCellValue(sourceCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            destCell.setCellValue(sourceCell.getNumericCellValue());
                            break;
                    }
                }
            }
            if (rowIndex == 0) {
                destRow.createCell(lastCell).setCellValue("Medie");
            }
            else {
                double suma = 0;
                for (int i = lastCell - 3; i < lastCell; i++) {
                    Cell c = sourceRow.getCell(i);
                    suma += c.getNumericCellValue();
                }
                double media = suma / 3;
                destRow.createCell(lastCell).setCellValue(media);
            }
            rowIndex++;
        }
        FileOutputStream fos = new FileOutputStream("src/lab8/laborator8_output2.xlsx");
        destinationWorkbook.write(fos);
        fos.close();
        destinationWorkbook.close();
    }

    public static void medieNote2(XSSFSheet sourceSheet, XSSFWorkbook destinationWorkbook) throws IOException {
        XSSFSheet destSheet=destinationWorkbook.createSheet();
        Iterator<Row> rowIterator = sourceSheet.iterator();
        int rowIndex = 0;
        while (rowIterator.hasNext()) {
            Row sourceRow = rowIterator.next();
            Row destRow = destSheet.createRow(rowIndex);

            int lastCell = sourceRow.getLastCellNum();
            for (int i = 0; i < lastCell; i++) {
                Cell sourceCell = sourceRow.getCell(i);
                Cell destCell = destRow.createCell(i);

                if (sourceCell != null) {
                    switch (sourceCell.getCellType()) {
                        case STRING:
                            destCell.setCellValue(sourceCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            destCell.setCellValue(sourceCell.getNumericCellValue());
                            break;
                    }
                }
            }
            if (rowIndex == 0) {
                destRow.createCell(lastCell).setCellValue("Medie");
            }
            else {
                Cell cell = destRow.createCell(lastCell);
                String formula = "AVERAGE(D" + (rowIndex + 1) + ":F" + (rowIndex + 1) + ")";
                cell.setCellFormula(formula);
            }
            rowIndex++;
        }
        FileOutputStream fos = new FileOutputStream("src/lab8/laborator8_output3.xlsx");
        destinationWorkbook.write(fos);
        fos.close();
        destinationWorkbook.close();
    }

    public static void main(String[] args) throws IOException {
        FileInputStream file1=new FileInputStream(new File("src/lab8/laborator8_input.xlsx"));
        XSSFWorkbook workbook1=new XSSFWorkbook(file1);
        XSSFSheet sheet1=workbook1.getSheetAt(0);
        afisareSheet(sheet1);

        XSSFWorkbook workbook2=new XSSFWorkbook();
        medieNote1(sheet1,workbook2);
        XSSFSheet sheet2=workbook2.getSheetAt(0);
        afisareSheet(sheet2);

        XSSFWorkbook workbook3=new XSSFWorkbook();
        medieNote2(sheet1,workbook3);
        XSSFSheet sheet3=workbook3.getSheetAt(0);
        afisareSheet(sheet3);

        file1.close();
        workbook1.close();
    }
}
