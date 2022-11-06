package com.hongfu.spring.controller;

import org.apache.poi.util.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
public class DownloadController {

    @PostMapping(path = "/downloadfiel")
    public void downloadfile(HttpServletResponse response){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("id","1");
        MultiValueMap<String, String> requestbody = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap> entity = new HttpEntity<>(requestbody, httpHeaders);
        String url = "http://127.0.0.1:8080/map/download";
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String body = responseEntity.getBody();
        try {
            // FileInputStream inputStream = new FileInputStream(body);
            byte[] bytes = body.getBytes();
            // ServletOutputStream outputStream = response.getOutputStream();

            BufferedOutputStream outputStream1 = new BufferedOutputStream(response.getOutputStream());
            response.reset();
            response.setContentType("application/x-www-form-urlencoded");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("测试模板导出.xls".getBytes("utf-8"),"ISO8859-1"));
            outputStream1.write(bytes);
            outputStream1.flush();
            outputStream1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/down")
    public void downFile(HttpServletResponse response) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("id","1");
        MultiValueMap<String, String> requestbody = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap> entity = new HttpEntity<>(requestbody, httpHeaders);
        String url = "http://127.0.0.1:8080/map/download";
        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
        byte[] body = responseEntity.getBody();
        try {
            response.reset();
            response.setContentType("application/x-www-form-urlencoded");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("测试模板导出.xls".getBytes("utf-8"),"ISO8859-1"));

            response.getOutputStream().write(body);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

