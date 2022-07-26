package cn.zswltech.preserver.core.datasource.utils;

import cn.zswltech.preserver.core.datasource.exception.DataSourceRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/17 5:59 下午
 * @description:
 **/
public class ExcelUtils {

    public static List<String> getTitle(Workbook workbook, int sheetId) {
        List res = Lists.newArrayList();
        Sheet sheet = workbook.getSheetAt(sheetId);
        Row row = sheet.getRow(0);
        for (Cell cell : row) {
            res.add(getCellStringVal(cell));
        }
        return res;
    }

    public static String getCellStringVal(Cell cell) {
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return StringUtils.EMPTY;
        }
    }

    public static Workbook getWorkBook(final InputStream is, final String fileName) {
        //xls-2003, xlsx-2007
        try {
            if (fileName.toLowerCase().endsWith("xlsx")) {
                return new XSSFWorkbook(is);
            } else if (fileName.toLowerCase().endsWith("xls")) {
                return new HSSFWorkbook(is);
            } else {
                //  抛出自定义的业务异常
                throw new DataSourceRuntimeException("excel格式文件错误");
            }
        } catch (IOException e) {
            //  抛出自定义的业务异常
            throw new DataSourceRuntimeException(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    public static int getRowCount(int sheetId, Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(sheetId);
        if (sheet.getPhysicalNumberOfRows() == 0) {
            return 0;
        }
        return sheet.getLastRowNum();
    }

    // [map<title,data>]
    public static List<Map<String, Object>> getDataWithTitle(int sheetId, Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(sheetId);
        List<Map<String, Object>> res = Lists.newArrayList();
        List<String> keys = getTitle(workbook, sheetId);
        int n = getRowCount(sheetId, workbook);
        for (int i = 1; i <= n; i++) {
            Map<String, Object> map = new HashMap<>();
            Row row = sheet.getRow(i);
            for (int j = 0; j < keys.size(); j++) {
                Cell cell = row.getCell(j);
                map.put(keys.get(j), cell == null ? "" : getCellStringVal(cell));
            }
            res.add(map);
        }
        return res;
    }

}
