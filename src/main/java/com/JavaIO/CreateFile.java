package com.JavaIO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    @Test
    public void create1(){
        String path = "D:\\work\\JavaIO\\Data\\test.txt";
        File file = new File(path);
        try {
            //执行该方法后才会真正创建文件
            file.createNewFile();
            System.out.println("创建文件成功!");
        } catch (IOException e) {
            System.out.println("创建文件失败!");
        }
    }

    @Test
    public void create2(){
        String path = "test2.txt";

        File parentFile = new File("D:\\work\\JavaIO\\Data");
        File file = new File(parentFile,path);
        try {
            file.createNewFile();
            System.out.println("创建文件成功!");
        } catch (IOException e) {
            System.out.println("创建文件失败!");
        }
    }

    @Test
    public void create3(){
        String path = "test3.txt";
        File file = new File("D:\\work\\JavaIO\\Data",path);
        try {
            file.createNewFile();
            System.out.println("创建文件成功!");
        } catch (IOException e) {
            System.out.println("创建文件失败!");
        }
    }

    @Test
    public void info(){
        String path = "D:\\work\\JavaIO\\Data\\test.txt";
        File file = new File(path);
        //获取文件名
        System.out.println("文件名："+file.getName());
        //获取文件绝对路径
        System.out.println("文件绝对路径："+file.getAbsolutePath());
        //获取文件父级目录
        System.out.println("文件父级目录："+file.getParent());
        //获取文件大小
        System.out.println("文件大小(字节)："+file.length());
        //文件是否存在
        System.out.println("文件是否存在："+file.exists());
        System.out.println("是不是一个文件："+file.isFile());
        System.out.println("是不是一个目录："+file.isDirectory());

        //file.delete删除文件，如果存在就删除，如果删除的是文件夹需要先删除文件夹中的文化
        //file.mkdir用于创建一级目录，file.mkdirs用于创建多级目录
        //file.mkdir用于创建目录，file.createNewFile用于创建文件


    }

    public static void main(String[] args) {

    }

}
