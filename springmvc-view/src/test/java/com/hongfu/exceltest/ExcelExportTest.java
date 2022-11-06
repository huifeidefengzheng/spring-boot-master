package com.hongfu.exceltest;

import com.hongfu.entity.Department;
import com.hongfu.entity.Employee;
import com.hongfu.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcelExportTest {

    private Employee employee;

    @Test
    public void test01(){
        Department department = new Department();
        Field[] declaredFields = department.getClass().getDeclaredFields();
        String[] str = new String[declaredFields.length];

        for (int i = 0; i < declaredFields.length; i++) {
            str[i]=declaredFields[i].getName();
        }
        List<Department> deps = new ArrayList<Department>();
        Department department1 = new Department(1, "教育");
        Department department2 = new Department(2, "体育");
        deps.add(department1);
        deps.add(department2);
        byte[] sheet0s = ExcelUtils.export("sheet0", str, Collections.singletonList(deps));

    }
    @Test
    public void test03() throws Exception {
        Department department = new Department();
        Field[] declaredFields = department.getClass().getDeclaredFields();
        String[] str = new String[declaredFields.length];

        for (int i = 0; i < declaredFields.length; i++) {
            str[i]=declaredFields[i].getName();
        }
        List<Department> deps = new ArrayList<Department>();
        Department department1 = new Department(1, "教育");
        Department department2 = new Department(2, "体育");
        deps.add(department1);
        deps.add(department2);
//创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
//创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");
        // 创建表头
        //创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < str.length; i++) {
            //创建HSSFCell对象
            HSSFCell cell=row.createCell(i);
            cell.setCellValue(str[i]);
        }
        // 将内容写
        for (int i = 1; i < deps.size()+1; i++) {
            //创建HSSFRow对象
            HSSFRow rowi = sheet.createRow(i);
            // 获取类的字段名称
            Field[] declaredFields1 = deps.get(i-1).getClass().getDeclaredFields();
            for (int j = 0; j < declaredFields1.length; j++) {
                HSSFCell cell = rowi.createCell(j);
                // 获取private修饰字段的权限
                declaredFields1[j].setAccessible(true);
                // 获取该字段的值
                Object o = declaredFields1[j].get(deps.get(i - 1));
                cell.setCellValue(String.valueOf(o) );
            }
        }
        //输出Excel文件
        FileOutputStream output= null;
        try {
            output = new FileOutputStream("e:\\ook.xls");
            wb.write(output);
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test02(){
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
//创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");
//创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);
//创建HSSFCell对象
        HSSFCell cell=row.createCell(0);
//设置单元格的值
        cell.setCellValue("单元格中的中文");
//输出Excel文件
        FileOutputStream output= null;
        try {
            output = new FileOutputStream("e:\\workbook.xls");
            wb.write(output);
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
