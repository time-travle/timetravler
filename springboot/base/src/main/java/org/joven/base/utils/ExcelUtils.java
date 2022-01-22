/**
 * Project Name: time-travle.github.io
 * File Name: XlsxFileUtils
 * Package Name: org.joven.base.utils
 * Date: 2020/5/3 10:05
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.base.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * CreateBy Administrator
 * Date: 2020/5/3 10:05
 * Version:1.0
 * Remark:
 */
public final class ExcelUtils {
    private ExcelUtils() {
    }

    /**
     * 一层为sheet表 二层为行 三层为列
     *
     * @param wb
     * @return
     */
    public static List<List<List<String>>> readAllSheet(Workbook wb) {
        List<List<List<String>>> allSheetInfo = new ArrayList<>();
        int sheets = wb.getNumberOfSheets();
        for (int i = 0; i > sheets; i++) {
            List<List<String>> oneSheet = read(wb, i);
            allSheetInfo.add(oneSheet);
        }
        return allSheetInfo;
    }

    public static List<List<String>> read(String filePath) {
        if (!checkExcelType(filePath)) {
            return null;
        }
        boolean isExcel03 = true;
        if (!isExcel2003(filePath)) {
            isExcel03 = false;
        }
        File file = new File(filePath);

        List<List<String>> dataLst = new ArrayList<List<String>>();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            dataLst = read(inputStream, isExcel03);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataLst;
    }

    public static List<List<String>> read(InputStream inputStream, boolean isExcel03) {
        List<List<String>> dataLst = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            if (isExcel03) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            dataLst = readFirstSheet(wb);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return dataLst;
    }


    public static List<List<String>> read(Workbook wb, int sheetIndex) {
        List<List<String>> dataLst = new ArrayList<List<String>>();
        /** 得到一个shell  0 为第一个*/
        Sheet sheet = wb.getSheetAt(sheetIndex);
        /** 得到Excel的行数 */
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCells = 0;
        /** 得到Excel的首行列数 */
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        /** 循环Excel的行 */
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            List<String> rowLst = new ArrayList<String>();
            /** 循环Excel的列 */
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                            cellValue = cell.getNumericCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_STRING: // 字符串
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA: // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;
                        case HSSFCell.CELL_TYPE_BLANK: // 空值
                            cellValue = "\t";
                            break;
                        case HSSFCell.CELL_TYPE_ERROR: // 故障
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                /** 保存当前行的全部列 */
                rowLst.add(cellValue);
            }
            /** 保存第r行的 */
            dataLst.add(rowLst);
        }
        return dataLst;
    }

    public static List<List<String>> readFirstSheet(Workbook wb) {
        return read(wb, 0);
    }

    public static void writeExcelAppent(List<List<String>> result, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            writeExcelOneSheet(result, filePath);
            return;
        }
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(filePath);
            //使用POI提供的方法得到excel的信息
            POIFSFileSystem ps = new POIFSFileSystem(fs);
            ;
            HSSFWorkbook wb = new HSSFWorkbook(ps);
            //获取到工作表，因为一个excel可能有多个工作表
            HSSFSheet sheet = wb.getSheetAt(0);
            //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
            HSSFRow row = sheet.getRow(0);
            //分别得到最后一行的行号，和一条记录的最后一个单元格
            System.out.println(sheet.getLastRowNum() + " " + row.getLastCellNum());
            //向d://test.xls中写数据
            FileOutputStream out = null;
            int rows = result.size();
            int oldLastRowNum = sheet.getLastRowNum();
            for (int i = 1; i < rows; i++) {
                out = new FileOutputStream(filePath);
                row = sheet.createRow((short) (oldLastRowNum + i)); //在现有行号后追加数据
                List<String> cells = result.get(i);
                for (int j = 0; j < cells.size(); j++) {
                    row.createCell(j).setCellValue(cells.get(j)); //设置第一个（从0开始）单元格的数据
                }
            }
            out.flush();
            wb.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeExcelOneSheet(List<List<String>> result, String path) {
        if (result == null) {
            return;
        }
        isExcelExist(path);
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
        for (int i = 0; i < result.size(); i++) {
            HSSFRow row = sheet.createRow(i);
            if (result.get(i) == null) {
                continue;
            }
            for (int j = 0; j < result.get(i).size(); j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(result.get(i).get(j));
            }
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        //Excel文件生成后存储的位置。
        File file = new File(path);
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(content);
            os.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkExcelType(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return false;
        } else if (isExcel2003(filePath) || isExcel2007(filePath)) {
            return true;
        }
        return false;
    }

    public static boolean isExcelExist(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
