package com.hongfu.springmvcdemo.springmvcdemo.utils;

import com.hongfu.springmvcdemo.springmvcdemo.vo.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExcelUtils {



    /**
     * 根据模板导出报表，可导出多个Sheet页
     *
     * @param ExcelName 导出的Excel文件名
     * @param ModelURl 模板路径           (全路径)
     * @param dataSource 数据源
     * @param
     * @param sheetNames 生成的Sheet页的名称集合
     */
    public static void ExcelByModel(String ExcelName, String ModelURl, List<Map<String, String>> dataSource, String[] sheetNames) throws Exception {
// 设置导出Excel报表的导出形式
        /*response.setContentType("application/vnd.ms-excel");*/
        // 设置导出Excel报表的响应文件名
        String fileName = new String(ExcelName.getBytes("utf-8"));
        FileOutputStream fileOut = new FileOutputStream(fileName);
        /*response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");*/
        // 创建一个输出流
        //OutputStream fileOut = response.getOutputStream();
        // 读取模板文件路径
        File file = new File(ModelURl);
        FileInputStream fins = new FileInputStream(file);
        POIFSFileSystem fs = new POIFSFileSystem(fins);
        // 读取Excel模板
        HSSFWorkbook wb = new HSSFWorkbook(fs);
// 设置边框样式
// 模板页
        HSSFSheet sheetModel = null;
// 新建的Sheet页
        HSSFSheet newSheet = null;
// 创建行
        HSSFRow row = null;
// 创建列
        HSSFCell cell = null;
// 循环建立Sheet页
        for (int i = 0; i < sheetNames.length; i++) {
// 读取模板中模板Sheet页中的内容
            sheetModel = wb.getSheetAt(0);
// 设置新建Sheet的页名
            newSheet = wb.createSheet(sheetNames[i]);
            for (int j = 0; j < dataSource.size();j++) {
                row = newSheet.createRow(j);
                HSSFCell cell1 = row.createCell(j);
                cell1.setCellValue(dataSource.get(j).toString());
            }
// break 加break可以测试只添加一个Sheet页的情况
        }
// 写入流
        wb.write(fileOut);
// 关闭流
        fileOut.close();
    }

    /**
     * 根据模板导出报表，可导出多个Sheet页
     *
     * @param ExcelName 导出的Excel文件名
     * @param ModelURl 模板路径           (全路径)
     * @param dataSource 数据源
     * @param
     * @param sheetNames 生成的Sheet页的名称集合
     * @param keyNames 数据源中Map集合的key值 (key值对应的value值顺序要列名顺序一致)
     * @param rowNum 开始             循环写入数据 的行数(从第几行开始写入数据)
     */
    public static void ExcelByModel(String ExcelName, String ModelURl, List<Map<String, String>> dataSource, String[] sheetNames, String[] keyNames, int rowNum) throws Exception {
// 设置导出Excel报表的导出形式
        /*response.setContentType("application/vnd.ms-excel");*/
        // 设置导出Excel报表的响应文件名
        String fileName = new String(ExcelName.getBytes("utf-8"), "ISO-8859-1");
        FileOutputStream fileOut = new FileOutputStream(fileName);
        /*response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");*/
        // 创建一个输出流
        //OutputStream fileOut = response.getOutputStream();
        // 读取模板文件路径
        File file = new File(ModelURl);
        FileInputStream fins = new FileInputStream(file);
        POIFSFileSystem fs = new POIFSFileSystem(fins);
        // 读取Excel模板
        HSSFWorkbook wb = new HSSFWorkbook(fs);
// 设置边框样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setBorderBottom(style.getBorderBottom());
        style.setBorderLeft(style.getBorderLeft());
        style.setBorderRight(style.getBorderRight());
        style.setBorderTop(style.getBorderTop());
// 设置边框样式的颜色
        style.setBottomBorderColor(style.getBottomBorderColor());
        style.setLeftBorderColor(style.getLeftBorderColor());
        style.setRightBorderColor(style.getRightBorderColor());
        style.setTopBorderColor(style.getTopBorderColor());
// 模板页
        HSSFSheet sheetModel = null;
// 新建的Sheet页
        HSSFSheet newSheet = null;
// 创建行
        HSSFRow row = null;
// 创建列
        HSSFCell cell = null;
// 循环建立Sheet页
        for (int i = 0; i < sheetNames.length; i++) {
// 读取模板中模板Sheet页中的内容
            sheetModel = wb.getSheetAt(0);
// 设置新建Sheet的页名
            newSheet = wb.createSheet(sheetNames[i]);
// 将模板中的内容复制到新建的Sheet页中
            copySheet(wb, sheetModel, newSheet, sheetModel.getFirstRowNum(), sheetModel.getLastRowNum());
//获取到新建Sheet页中的第一行为其中的列赋值
            row = newSheet.getRow(0);
            row.getCell(1).setCellValue("这是为表代码赋的值");
//注意 合并的单元格也要按照合并前的格数来算
            row.getCell(6).setCellValue("这是为外部代码赋的值");
//获取模板中的第二列，并赋值
            row = newSheet.getRow(1);
            row.getCell(1).setCellValue("表名称赋值");
//注意 合并的单元格也要按照合并前的格数来算
            row.getCell(6).setCellValue("这是为是否系统表赋的值");
// 遍历数据源 开始写入数据(因为Excel中是从0开始,所以减一)
            int num = rowNum - 1;
            for (Map<String, String> item : dataSource) {
// 循环遍历,新建行
                row = newSheet.createRow((short) num);
//判断有多少列数据
                for (int j = 0; j < keyNames.length; j++) {
// 设置每列的数据 设置每列的样式 设置每列的值
                    cell = row.createCell(j);
                    cell.setCellStyle(style);
                    cell.setCellValue(item.get(keyNames[j]));
                }
                num++;
            }
// break 加break可以测试只添加一个Sheet页的情况
        }
// 写入流
        wb.write(fileOut);
// 关闭流
        fileOut.close();
    }

    /**
     *
     * @param wb Excel工作簿对象
     * @param  fromsheet 模板Sheet页
     * @param newSheet 新建Sheet页
     * @param firstrow 模板页的第一行
     * @param lasttrow 模板页的最后一行
     */
    private static void copySheet(HSSFWorkbook wb, HSSFSheet fromsheet, HSSFSheet newSheet, int firstrow, int lasttrow) {
        // 复制一个单元格样式到新建单元格
        if ((firstrow == -1) || (lasttrow == -1) || lasttrow < firstrow) {
            return;
        }
        // 复制合并的单元格
        CellRangeAddress region = null;
        for (int i = 0; i < fromsheet.getNumMergedRegions(); i++) {
            region = fromsheet.getMergedRegion(i);
            if ((region.getFirstRow() >= firstrow) && (region.getLastRow() <= lasttrow)) {
                newSheet.addMergedRegion(region);
            }
        }
        HSSFRow fromRow = null;
        HSSFRow newRow = null;
        HSSFCell newCell = null;
        HSSFCell fromCell = null;
        // 设置列宽
        for (int i = firstrow; i < lasttrow; i++) {
            fromRow = fromsheet.getRow(i);
            if (fromRow != null) {
                for (int j = fromRow.getLastCellNum(); j >= fromRow.getFirstCellNum(); j--) {
                    int colnum = fromsheet.getColumnWidth((short) j);
                    if (colnum > 100) {
                        newSheet.setColumnWidth((short) j, (short) colnum);
                    }
                    if (colnum == 0) {
                        newSheet.setColumnHidden((short) j, true);
                    } else {
                        newSheet.setColumnHidden((short) j, false);
                    }
                }
                break;
            }
        }
        // 复制行并填充数据
        for (int i = 0; i < lasttrow; i++) {
            fromRow = fromsheet.getRow(i);
            if (fromRow == null) {
                continue;
            }
            newRow = newSheet.createRow(i - firstrow);
            newRow.setHeight(fromRow.getHeight());
            for (int j = fromRow.getFirstCellNum(); j < fromRow.getPhysicalNumberOfCells(); j++) {
                fromCell = fromRow.getCell((short) j);
                if (fromCell == null) {
                    continue;
                }
                newCell = newRow.createCell((short) j);
                newCell.setCellStyle(fromCell.getCellStyle());
                CellType cellType1 = fromCell.getCellType();
                newCell.setCellType(cellType1);
                int cellType = fromCell.getCellType().getCode();
                switch (cellType) {
                    case 1:
                        newCell.setCellValue(fromCell.getRichStringCellValue());
                        break;
                    case 0:
                        newCell.setCellValue(fromCell.getNumericCellValue());
                        break;
                    case 2:
                        newCell.setCellValue(fromCell.getCellFormula());
                        break;
                    case 4:
                        newCell.setCellValue(fromCell.getBooleanCellValue());
                        break;
                    case 5:
                        newCell.setCellValue(fromCell.getErrorCellValue());
                        break;
                    default:
                        newCell.setCellValue(fromCell.getRichStringCellValue());
                        break;
                }
            }
        }
    }

    public static void export2Excel(List<User> users) {
        try {
            // 第一行标题
            String[] head = new String[]{"险种编码", "险种名称"};

            HSSFWorkbook wb = new HSSFWorkbook();
            //写入的路径到具体xls
            File savedFile = new File("E:\\user.xls");
            OutputStream output = new FileOutputStream(savedFile);

            //查询数据LpfMLmRiskAppBPojo表示实体类，lpfMLmRiskAppBDao表示与数据库查询的dao层
            //List<LpfMLmRiskAppBPojo> list = lpfMLmRiskAppBDao.queryAll();

            int totle = users.size();// 获取List集合的size
            //sheet页的名称
            HSSFSheet sheet = wb.createSheet("信息");
            HSSFRow row = sheet.createRow(0);
            int headInt = 0;
            for (String title : head) {
                row.createCell(headInt++).setCellValue(title);
            }
            int line = 1;
            for (int m = 0; m < totle; m++) {
                User user = users.get(m);
                // 每列对应的字段
                row = sheet.createRow(line + m); // 创建行
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
            }
            wb.write(output);
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void export2ExcelSheet(List<User> users) {
        /*try {
            // 第一行标题
            String[] head = new String[]{"险种编码", "险种名称"};

            HSSFWorkbook wb = new HSSFWorkbook();
            //写入的路径到具体xls
            File savedFile = new File("E:\\user.xls");
            OutputStream output = new FileOutputStream(savedFile);

            //查询数据LpfMLmRiskAppBPojo表示实体类，lpfMLmRiskAppBDao表示与数据库查询的dao层
            //List<LpfMLmRiskAppBPojo> list = lpfMLmRiskAppBDao.queryAll();

            int totle = users.size();// 获取List集合的size
            int mus = 5;// ：excel表格一个工作表可以存储5条）
            int avg = totle / mus;
            for (int i = 0; i < avg + 1; i++) {
                //sheet页的名称
                HSSFSheet sheet = wb.createSheet("信息" + (i + 1));
                HSSFRow row = sheet.createRow(0);
                int headInt = 0;
                for (String title : head) {
                    row.createCell(headInt++).setCellValue(title);
                }
                int num = i * mus;
                int index = 0;
                int rowInt = 1;
                for (int m = num; m < list.size(); m++) {
                    if (index == mus) {// 判断index == mus的时候跳出当前for循环
                        break;
                    }
                    LpfMLmRiskAppBPojo actualReturnDetial = list.get(m);
                    // 每列对应的字段
                    row = sheet.createRow(rowInt++); // 创建行
                    row.createCell(0).setCellValue(actualReturnDetial.getRiskCode());
                    row.createCell(1).setCellValue(actualReturnDetial.getRiskName());

                    index++;
                }
            }
            wb.write(output);
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
