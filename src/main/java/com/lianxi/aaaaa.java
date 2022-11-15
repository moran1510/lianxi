package com.lianxi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class aaaaa {
    int a[];
    aaaaa(int n){
        a = new int[n];
    }
    public void testa(int i,int j){
        if (i<=j){
            for(int h = i-1;h<j-1;h++){
                a[h]++;
            }
        }

    }
    public  int  testb(){
        int count = 0;
        int i = 0;
        for (;i<a.length;){
            if (a[i] == 0){
                count++;
                while (a[i]!=0&&i<a.length) {
                    i++;
                }
            }else {
                while (a[i]==0&&i<a.length) {
                    i++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int[] arr = new int[b];
        for (int i = 0;i<b;i++){
            arr[i] = scanner.nextInt();
        }
        for (int k:arr) {
            System.out.println(k+" ");
        }


    }

}

class A{
    public int  maxa(int[] arr,int count,int j){
        if (j>=arr.length){
            return count;
        }else if (j==arr.length-1){
            return count+arr[arr.length-1];
        }else {
            return Math.max(count+arr[j]+maxa(arr,count+arr[j],j+2),count+maxa(arr,count+arr[j],j+1));
        }
    }

}

class B{
    private final String aaa;

    public B(String aaa) {
        this.aaa = aaa;
    }

    public void b1() {
        System.out.println("b1");
    }
}
class C extends B{
    private static final String aaa = "";

    C() {
        super(aaa);
    }

    public void b1(){
        System.out.println("c1");
    }
    public void b1(String a){
        System.out.println("c1");
    }

    public void b2(){
        System.out.println("c2");
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i]<count){
               count--;
           }else {
               if (nums.length-i==count){
                   return count;
               }
           }
        }
        return -1;
    }

}

 class Main {
    int nums[];
    Main(int[] nums){
        this.nums = nums;
        Arrays.sort(nums);
    }
    public void testa(int i){
        for (int j = nums.length/2; i>=0; i--,j++) {
            j=j%(nums.length/2)+ nums.length/2;
            nums[j]++;
        }

    }

}
