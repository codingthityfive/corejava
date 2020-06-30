package com.study.corejava.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.jni.Thread;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PoiUtile {
    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            strings.add("test" + i);
        }
        long start=System.currentTimeMillis();
        Workbook wb = getWorkbook(strings);
        FileOutputStream fileOutputStream = new FileOutputStream("D:/1/test111"+start+".xlsx");
        wb.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        wb.close();
        System.out.println("生成100万条excel用时："+(System.currentTimeMillis()-start)+"ms");
        while (true) {

        }
    }

    public static Workbook getWorkbook(List<String> list) {
        SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Workbook workbook = new SXSSFWorkbook(1000);
//        Workbook workbook = new HSSFWorkbook();
//        Workbook workbook = new XSSFWorkbook();
        String title = "mySheet";

        int rowNum = 2;
        int num = 1;// 数据序号
        Row row;
        int sheetNum = 1;
        Sheet sheet = createSheet(workbook, title + sheetNum);
        sheetNum++;

        for (String domain : list) {
            if (domain == null) {
                continue;
            }
//            if (rowNum % 30002 == 0) {
//                sheet = createSheet(workbook, title + sheetNum);
//                rowNum = 2;
//                sheetNum++;
//            }
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(num);
            row.createCell(1).setCellValue(domain);
            row.createCell(2).setCellValue(domain);
            row.createCell(3).setCellValue(domain);
            row.createCell(4).setCellValue(domain);
            row.createCell(5).setCellValue(domain);
            row.createCell(6).setCellValue(domain);
            row.createCell(7).setCellValue(domain);
            row.createCell(8).setCellValue(domain);
            row.createCell(9).setCellValue(domain);
            row.createCell(10).setCellValue(domain);
            row.createCell(11).setCellValue(domain);
            row.createCell(12).setCellValue(domain);
            row.createCell(13).setCellValue(domain);
            row.createCell(14).setCellValue(domain);
            rowNum++;
            num++;
        }

        return workbook;
    }

    private static Sheet createSheet(Workbook workbook, String title) {
        Sheet sheet = workbook.createSheet(title);
        // 设置表头
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("序号");
        headerRow.createCell(1).setCellValue("个人物品税号");
        headerRow.createCell(2).setCellValue("商品名称");
        headerRow.createCell(3).setCellValue("商品名称");
        headerRow.createCell(4).setCellValue("商品名称");
        headerRow.createCell(5).setCellValue("商品名称");
        headerRow.createCell(6).setCellValue("商品名称");
        headerRow.createCell(7).setCellValue("商品名称");
        headerRow.createCell(8).setCellValue("商品名称");
        headerRow.createCell(9).setCellValue("商品名称");
        headerRow.createCell(10).setCellValue("商品名称");
        headerRow.createCell(11).setCellValue("商品名称");
        headerRow.createCell(12).setCellValue("商品名称");
        headerRow.createCell(13).setCellValue("商品名称");
        headerRow.createCell(14).setCellValue("商品名称");


        Row headerRowKey = sheet.createRow(1);
        headerRowKey.createCell(0).setCellValue("NO.");
        headerRowKey.createCell(1).setCellValue("productcode");
        headerRowKey.createCell(2).setCellValue("goodsname");
        headerRowKey.createCell(3).setCellValue("goodsname");
        headerRowKey.createCell(4).setCellValue("goodsname");
        headerRowKey.createCell(5).setCellValue("goodsname");
        headerRowKey.createCell(6).setCellValue("goodsname");
        headerRowKey.createCell(7).setCellValue("goodsname");
        headerRowKey.createCell(8).setCellValue("goodsname");
        headerRowKey.createCell(9).setCellValue("goodsname");
        headerRowKey.createCell(10).setCellValue("goodsname");
        headerRowKey.createCell(11).setCellValue("goodsname");
        headerRowKey.createCell(12).setCellValue("goodsname");
        headerRowKey.createCell(13).setCellValue("goodsname");
        headerRowKey.createCell(14).setCellValue("goodsname");
        return sheet;
    }

    private static String dealNullString(String str) {

        if (StringUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
