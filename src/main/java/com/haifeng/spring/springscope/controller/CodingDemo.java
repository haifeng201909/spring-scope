package com.haifeng.spring.springscope.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CodingDemo {

    public static void main(String[] args) throws IOException {

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
        System.out.println(new String(byteBuffer,"GBK"));

        /*将读入的数组decode 以GB2312字符集*/
        System.out.println(new String(byteBuffer, "GB2312"));
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

}
