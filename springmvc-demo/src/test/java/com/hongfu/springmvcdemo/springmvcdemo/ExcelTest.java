package com.hongfu.springmvcdemo.springmvcdemo;

import com.hongfu.springmvcdemo.springmvcdemo.utils.ExcelUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelTest {
    @Test
    public void test() {
        //构建数据源
        List<Map<String, String>> dataSourceList = new ArrayList<Map<String, String>>() {
            {
                add(new HashMap<String, String>() {{
                    put("字段编号", "1");
                    put("字段代码", "BUSINESS_ID");
                    put("字段含义", "业务id");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", "是");
                    put("主码", "");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "2");
                    put("字段代码", "PROC_INST_ID");
                    put("字段含义", "流程实例编号");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", "");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "3");
                    put("字段代码", "PROC_STATE");
                    put("字段含义", "流程状态");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", " ");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "4");
                    put("字段代码", "APPLICANT");
                    put("字段含义", "申请人");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", " ");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "5");
                    put("字段代码", "LEAVE_TYPE");
                    put("字段含义", "请假类型");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", " ");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "6");
                    put("字段代码", "REASON");
                    put("字段含义", "请假事因");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", " ");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "7");
                    put("字段代码", "BEGIN_TIME");
                    put("字段含义", "起始时间");
                    put("数据类型", "TIMESTAMP");
                    put("长度", "");
                    put("主键", " ");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "8");
                    put("字段代码", "END_TIME");
                    put("字段含义", "结束时间");
                    put("数据类型", "TIMESTAMP");
                    put("长度", "");
                    put("主键", " ");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "9");
                    put("字段代码", "INSERT_PERSON");
                    put("字段含义", "登记人");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", " ");
                    put("主码", " ");
                }});
                add(new HashMap<String, String>() {{
                    put("字段编号", "10");
                    put("字段代码", "APPROVEDBY");
                    put("字段含义", "批准人");
                    put("数据类型", "VARCHAR");
                    put("长度", "64");
                    put("主键", " ");
                    put("主码", " ");
                }});
            }
        };
//构建数据源中的key值
        String[] keysStrings = {"字段编号", "字段代码", "字段含义", "数据类型", "长度", "主键", "主码"};
//每页的名称
        String[] sheetNameStrings = {"Sheet1", "Sheet2", "Sheet3", "Sheet4", "Sheet5", "Sheet6"};
        String modelURLString = "E:\\testdata\\model.xls";
        try {
            ExcelUtils.ExcelByModel("测试模板导出.xls", modelURLString, dataSourceList, sheetNameStrings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
