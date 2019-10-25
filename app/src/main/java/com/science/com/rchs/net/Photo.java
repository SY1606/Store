package com.science.com.rchs.net;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Photo {

      public static boolean generateImage(String imgStr, String filename) {

                 if (imgStr == null) {
                         return false;
                     }
                 BASE64Decoder decoder = new BASE64Decoder();
                 try {
                         // 解密
                         byte[] b = decoder.decodeBuffer(imgStr);
                         // 处理数据
                         for(int i = 0; i < b.length; ++i) {
                                 if (b[i] < 0) {
                                         b[i] += 256;
                                     }
                             }
                        OutputStream out = new FileOutputStream("D:/Systems/"+filename);
                         out.write(b);
                         out.flush();
                         out.close();
                         return true;
                    } catch (IOException e) {
                         // TODO Auto-generated catch block
                         e.printStackTrace();
                     }
                 return false;

            }


             public static String getImageStr(String filePath) {
                InputStream inputStream = null;
                 byte[] data = null;
                 try {
                         inputStream = new FileInputStream(filePath);
                         data = new byte[inputStream.available()];
                         inputStream.read(data);
                         inputStream.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 // 加密
                 BASE64Encoder encoder = new BASE64Encoder();
                 return encoder.encode(data);
             }


             public static void main(String[] args) {
                 String imageStr = getImageStr("D:\\001.jpg");
                 System.out.println(imageStr);
                 boolean generateImage = generateImage(imageStr, "001.jpg");
                 System.out.println(generateImage);
             }
}
