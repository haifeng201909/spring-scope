package com.haifeng.spring.springscope.controller;

import java.io.*;
import java.util.Arrays;

public class CodingDemo {

    public static void main(String[] args) throws IOException {

        /*demo.txt编码格式为GBK*/
        FileInputStream inputStream = new FileInputStream("d:\\demo.txt");

        int buf;
        int[] intBuffer = new int[10];
        int intBufferCount = 0;
        byte[] byteBuffer = new byte[10];
        int byteBufferCount = 0;
        /*循环读取文件 直到文件结尾*/
        while ((buf = inputStream.read()) != -1) {

            /*将读入的int存放数组*/
            intBuffer[intBufferCount++] = buf;
            byte[] bytes = intToBytes(buf);

            /*将byte数组有效位依次存放 仅最低位有效 因为read函数每次只读入一个字节*/
            byteBuffer[byteBufferCount++] = bytes[3];
        }

        /*将int数组内容以字符串形式打印*/
        System.out.println(Arrays.toString(intBuffer));

        /*将byte数组内容以字符串形式打印*/
        System.out.println(Arrays.toString(byteBuffer));

        /*将读入的数组decode 以默认字符集*/
        System.out.println(new String(byteBuffer));

        /*将读入的数组decode 以GBK字符集*/
        System.out.println(new String(byteBuffer, "GBK"));

        /*将读入的数组decode 以GB2312字符集*/
        System.out.println(new String(byteBuffer, "GB2312"));

        /*以字符流从文件读入数据*/
        readByCharStream();

        /*以字符流将数据写入文件*/
        writeByCharStream();
    }

    /**
     * 将int类型转换为byte数组
     * 高字节在前
     *
     * @param value
     * @return byte[]
     */
    public static byte[] intToBytes(int value) {
        byte[] b = new byte[4];
        b[0] = (byte) (value >> 24 & 0xff);
        b[1] = (byte) (value >> 16 & 0xff);
        b[2] = (byte) (value >> 8 & 0xff);
        b[3] = (byte) (value & 0xff);
        return b;
    }

    public static void readByCharStream() throws IOException {
        /*以系统默认的字符集读入 在IDEA中即为项目编码*/
        /*InputStreamReader reader = new InputStreamReader(
                new FileInputStream("d:\\demo.txt"));*/
        /*以GBK字符集读入*/
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream("d:\\demo.txt"),"GBK");
        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.println(ch);
            System.out.println((char) ch);
        }
        reader.close();
    }

    public static void writeByCharStream() throws IOException {
        /*以GBK编码字符*/
        OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("d:\\demo2.txt"), "GBK");
        writer.write("我们");
        writer.flush();
        writer.close();
    }

}
