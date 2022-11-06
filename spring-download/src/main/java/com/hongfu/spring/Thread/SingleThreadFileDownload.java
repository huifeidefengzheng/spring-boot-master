package com.hongfu.spring.Thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SingleThreadFileDownload implements Runnable{
    // 下载路径
    private String urlDown;

    // 本地存放路径
    private String filePath;
    //文件开始地址
    private long start;
    //文件结束地址
    private long end;

    public SingleThreadFileDownload(String urlDown, String filePath, long start, long end) {
        this.urlDown = urlDown;
        this.filePath = filePath;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        InputStream is = null;
        RandomAccessFile out = null;
        try {
            //获取下载的部分
            URL url = new URL(urlDown);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Range", "bytes=" + start + "-" + end);

            File file = new File(filePath);
            out = null;
            if (file != null) {
                out = new RandomAccessFile(file, "rw");
            }
            out.seek(start);

            is = conn.getInputStream();
            byte[] bytes = new byte[1024];
            int l = 0;
            while ((l = is.read(bytes))!=-1){
                out.write(bytes,0,l);
            }
            System.out.println(Thread.currentThread().getName()+"完成下载！");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
