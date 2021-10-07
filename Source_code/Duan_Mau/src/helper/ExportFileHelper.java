/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tran Van Thanh
 */
public class ExportFileHelper {

    public static void writeToExcell(JTable table, Path path) throws FileNotFoundException, IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(2);
        TableModel model = table.getModel();

        Row headerRow = sheet.createRow(0);
        for (int headings = 0; headings < model.getColumnCount(); headings++) {
            headerRow.createCell(headings).setCellValue(model.getColumnName(headings));
        }

        for (int rows = 0; rows < model.getRowCount(); rows++) {
            for (int cols = 0; cols < table.getColumnCount(); cols++) {
                row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString());
            }
            row = sheet.createRow((rows + 3));
        }
        wb.write(new FileOutputStream(path.toString()));
    }
}
