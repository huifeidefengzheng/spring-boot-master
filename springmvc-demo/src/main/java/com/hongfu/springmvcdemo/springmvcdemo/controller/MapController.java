package com.hongfu.springmvcdemo.springmvcdemo.controller;


import org.apache.http.HttpResponse;
import org.apache.poi.util.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(path = "/map")
public class MapController {

    /*@Resource
    private RestTemplate restTemplate;*/

    private String url = "";

    @PostMapping(path = "/v1")
    public Object getAll (@RequestBody Map<String,Object> map) {

        System.out.println(map);
        return map.toString();
    }

    /**
     * 强转为HttpServletResponse
     */
    @GetMapping(path = "/download")
    public void downLoadFile(HttpServletResponse response){

        String localPath = System.getProperty("user.dri");
        String filePath = "E:\\iworkspace\\test\\springboot-demo\\springmvc-demo\\测试模板导出.xls";
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ServletOutputStream outputStream = response.getOutputStream();

            response.reset();
            response.setContentType("application/x-www-form-urlencoded");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("测试模板导出.xls".getBytes("utf-8"),"ISO8859-1"));

            IOUtils.copy(fileInputStream,outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), byte[].class);
        byte[] body = response.getBody();
        try {
            ServletOutputStream outputStream = response1.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }
}
