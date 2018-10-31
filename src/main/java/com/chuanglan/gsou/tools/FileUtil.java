package com.chuanglan.gsou.tools;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 文件读取工具类
 */
public class FileUtil {


    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }
        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        }
        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流  
        FileInputStream fis = new FileInputStream(filePath);  
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];  
        // 用于保存实际读取的字节数  
        int hasRead = 0;  
        while ( (hasRead = fis.read(bbuf)) > 0 ) {  
            sb.append(new String(bbuf, 0, hasRead));  
        }  
        fis.close();  
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }

    /**
     * 获取图片转并转换成base64字符串
     */
    public static String getBase64Image(String imgPath) {
        ByteArrayOutputStream data = null;
        String image = "";
        BASE64Encoder encoder = new BASE64Encoder();
        if (imgPath.contains("http") || imgPath.contains("https")) {
            data = new ByteArrayOutputStream();
            InputStream is = null;
            try {
                // 创建URL
                URL url = new URL(imgPath);
                byte[] by = new byte[1024];
                // 创建链接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(2000);
                conn.setReadTimeout(5000);
                conn.setRequestProperty("connection", "Keep-Alive");
                is = conn.getInputStream();
                // 将内容读取内存中
                int len = -1;
                while ((len = is.read(by)) != -1) {
                    data.write(by, 0, len);
                }
            } catch (IOException e) {
                System.out.println("getBase64Image error," + e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        System.out.println("InputStream close error," + e);
                    }
                }
            }
            image = encoder.encode(data.toByteArray());
        } else {
            try {
                image = encoder.encode(readFileByBytes(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 对字节数组Base64编码
        return image;
    }


    /**
     * 获取图片转并转换成base64字符串跟上面的编码不一样
     * 仅用于公安人脸对比接口
     */
    public static String getImage(String imgPath) {
        ByteArrayOutputStream data = null;
        String image = "";
        if (imgPath.contains("http") || imgPath.contains("https")) {
            data = new ByteArrayOutputStream();
            InputStream is = null;
            try {
                // 创建URL
                URL url = new URL(imgPath);
                byte[] by = new byte[1024];
                // 创建链接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(2000);
                conn.setReadTimeout(5000);
                conn.setRequestProperty("connection", "Keep-Alive");
                is = conn.getInputStream();
                // 将内容读取内存中
                int len = -1;
                while ((len = is.read(by)) != -1) {
                    data.write(by, 0, len);
                }
            } catch (IOException e) {
                System.out.println("getBase64Image error," + e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        System.out.println("InputStream close error," + e);
                    }
                }
            }
            image = Base64.encode(data.toByteArray());
        } else {
            try {
                image = Base64.encode(readFileByBytes(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 对字节数组Base64编码
        return image;
    }

}
