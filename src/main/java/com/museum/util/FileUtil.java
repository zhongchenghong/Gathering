package com.museum.util;

import com.museum.domain.Resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class FileUtil {

    /***
     * 文件下载
     * @param filename 需要下载文件的绝对路径
     * @param res
     * @throws IOException
     */
    public static void download(String filename, HttpServletResponse res, Resources resour, HttpServletRequest req) throws IOException {
        res.reset();
        res.setContentType("application/octet-stream; charset=utf-8");
        res.addHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        res.addHeader("Access-Control-Expose-Headers","token,uid,Content-Disposition");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        res.addHeader("Access-Control-Allow-Credentials","true");
        InputStream inputStream = null;
        OutputStream os = null;
        try{

            File file = new File(filename);
            File newFile = new File(resour.getPathaddress()+"/"+resour.getFilename());
            if (file.exists() && file.isFile()) {
                file.renameTo(newFile);
            }
            String name = newFile.getName();
            inputStream = new FileInputStream(newFile);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len =0;
            while((len=inputStream.read(buffer))!=-1){
                outStream.write(buffer,0,len);
            }
            inputStream.close();
            byte[] data = outStream.toByteArray();
            res.reset();
            res.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(name,"UTF-8"));
            res.setContentType("application/octet-stream");
            os = res.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
            if(os!=null){
                os.close();
            }
        }
    }

    /***
     * 文件下载
     * @param filename 需要下载文件的绝对路径
     * @param res
     * @throws IOException
     */
    public static void downloadpath(String filename, HttpServletResponse res, Resources resour) throws IOException {
        InputStream inputStream = null;
        OutputStream os = null;
        try{

            File file = new File(filename);
            File newFile = new File(resour.getReaddress());
            if (file.exists() && file.isFile()) {
                file.renameTo(newFile);
            }
            String name = newFile.getName();
            inputStream = new FileInputStream(newFile);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len =0;
            while((len=inputStream.read(buffer))!=-1){
                outStream.write(buffer,0,len);
            }
            inputStream.close();
            byte[] data = outStream.toByteArray();
            res.reset();
            res.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(name,"UTF-8"));
            res.setContentType("application/octet-stream");
            os = res.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
            if(os!=null){
                os.close();
            }
        }
    }
}
