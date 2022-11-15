package com.JavaIO;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Liu {
    //inputStream,outputStream,Reader,writer都是抽象类，不能创建实例

    //字节流
    @Test
    public void readFile1(){
        int index = 0;
        String path = "D:\\work\\JavaIO\\Data\\test5.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            //如果index==-1表示读取完成,index是ASCII码
            while ((index=fileInputStream.read())!=-1){
                System.out.println((char) index);
            }
        }catch (IOException e){

        }finally {
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //字节流，使用数组读出
    @Test
    public void readFile2(){
        int index = 0;
        byte[] bytes = new byte[8];
        String path = "D:\\work\\JavaIO\\Data\\test2.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            //如果index==-1表示读取完成
            //读取正常则返回读取的字节数
            while ((index = fileInputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,index));
            }
        }catch (IOException e){

        }finally {
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //字符流
    @Test
    public void readFile3(){
        int index = 0;
        String path = "D:\\work\\JavaIO\\Data\\test.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            //如果index==-1表示读取完成,index是ASCII码
            while ((index=fileReader.read())!=-1){
                System.out.print((char) index);
            }
        }catch (IOException e){

        }finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //字符流，使用数组读出
    @Test
    public void readFile4(){
        int index = 0;
        char[] bytes = new char[8];
        String path = "D:\\work\\JavaIO\\Data\\test.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            //如果index==-1表示读取完成
            //读取正常则返回读取的字节数
            while ((index = fileReader.read(bytes))!=-1){
                System.out.print(new String(bytes,0,index));
            }
        }catch (IOException e){

        }finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void writeFile1(){
        int index = 0;
        byte[] bytes = new byte[8];
        String path = "D:\\work\\JavaIO\\Data\\test2.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //该方式写入会覆盖原来的内容
            // new FileOutputStream(path,ture); 该方式可在原来内容里追加新内容
            fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(path.getBytes());
        }catch (IOException e){
        }finally {
            try {
                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void writeFile2(){
        int index = 0;
        byte[] bytes = new byte[8];
        String path = "D:\\work\\JavaIO\\Data\\test2.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path,true);
            fileWriter.write("昨夜雨疏风骤".toCharArray());
        }catch (IOException e){
        }finally {
            try {
                if (fileWriter!=null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fileCopy(){
        int index = 0;
        String inputPath = "D:\\javaXiangmu\\data\\2.png";
        File file = new File(inputPath);
        System.out.println(file.getName());
        String outputPath = "D:\\work\\JavaIO\\Data\\"+file.getName();
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        byte[] bytes = new byte[8];

        try {
            fileInputStream = new FileInputStream(inputPath);
            fileOutputStream = new FileOutputStream(outputPath);
            while ((index = fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,index);
            }
        }catch (IOException e){

        }finally {
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
