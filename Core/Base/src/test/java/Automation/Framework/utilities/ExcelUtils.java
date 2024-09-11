package Automation.Framework.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang3.BooleanUtils.and;

public class ExcelUtils {
    public static List<Object[]> getTestData(String filePath, String sheetName) throws IOException {
        List<Object[]> testData = new ArrayList<>();
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rows = sheet.iterator();

        // Skip the header row
        rows.next();

        while (rows.hasNext()) {
            Row row = rows.next();
            System.out.println(row);
            if (row.getCell(0).getCellType() == CellType.NUMERIC) {
                if (row.getCell(1).getCellType() == CellType.NUMERIC) {
                    double username = row.getCell(0).getNumericCellValue();
                    double password = row.getCell(1).getNumericCellValue();
                    testData.add(new Object[]{username, password});
                }
            } else if (row.getCell(0).getCellType() == CellType.STRING) {
                if (row.getCell(1).getCellType() == CellType.STRING) {
                    String username = row.getCell(0).getStringCellValue();
                    String password = row.getCell(1).getStringCellValue();
                    testData.add(new Object[]{username, password});
                }
                //String username = row.getCell(0).getStringCellValue();
                //String password = row.getCell(1).getStringCellValue();
                //testData.add(new Object[]{username, password});

            }

            workbook.close();
            file.close();
            return testData;
        }
        return testData;
    }
}
