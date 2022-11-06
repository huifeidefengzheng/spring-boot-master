package com.hongfu.springmvcdemo.springmvcdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hongfu.springmvcdemo.springmvcdemo.vo.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class JSONUtils {

    public static void main(String[] args) {
        getUserName();
    }

    public static void getUserName(){
        File file = new File("E:\\iworkspace\\test\\springboot-demo\\springmvc-demo\\src\\main\\resources\\users.json");
        FileInputStream fileInputStream = null;
        try {
            StringBuffer sb = new StringBuffer();
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024 * 1024];
            int data ;
            while ((data = fileInputStream.read(bytes)) != -1) {
                sb.append(new String(bytes,0,data));
            }
            sb.toString();
            List<User> users = JSON.parseArray(sb.toString(), User.class);
            /*objects.forEach(vo -> {
                User parse = JSON.parseObject(vo.toString(),User.class);
                System.out.println(parse.getName());
            });*/
            ExcelUtils.export2Excel(users);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
