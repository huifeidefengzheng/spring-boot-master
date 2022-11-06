package com.hongfu.spring.Thread;

import java.net.URL;
import java.net.URLConnection;

public class moreThreadDownFile {

    public static void main(String[] args) {
        try {
            getFileWithThreadPool("https://issuecdn.baidupcs.com/issue/netdisk/yunguanjia/BaiduNetdisk_7.8.5.1.exe","D:\\百度.exe",5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getFileWithThreadPool(String urlLocation, String filePath, int poolLength) throws Exception{
        long start = 0;
        int length = 0;
        URL url = null;
        url = new URL(urlLocation);
        URLConnection urlConnection = url.openConnection();
        //文件长度
        length = urlConnection.getContentLength();
        System.out.println(length);
        for (int i = 0; i < poolLength; i++) {
            start = i * length / poolLength;
            long end = (i + 1) * length / poolLength - 1;
            System.out.println(start+"---------------"+end);

            Thread thread = new Thread(new SingleThreadFileDownload(urlLocation, filePath, start, end));
            thread.setName("线程"+(i+1));
            thread.start();
        }

    }
}
