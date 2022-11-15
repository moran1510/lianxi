package com.demo;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Paixu {
    private int[] nums;

    public Paixu() {
    }

    public Paixu(int[] nums) {
        this.nums = nums;
    }


    //冒泡排序，时间复杂度：最好n，最坏n平方，平均n平方，稳定
    public int[] maopao(int[] nums){
        if (nums.length<1){
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-i; j++) {
                if (nums[j-1]>nums[j]){
                    int a = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = a;
                }
            }
        }
        return nums;
    }


    //选择排序，时间复杂度：最好n平方，最坏n平方，平均n平方，不稳定
    public int[] xuanze(int[] nums){
        if (nums.length<=1){
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[index]>nums[j]){
                    index = j;
                }
            }
            int n = nums[index];
            nums[index] = nums[i];
            nums[i] = n;
        }
        return nums;
    }


    //插入排序，时间复杂度：最好n，最坏n平方，平均n平方
    public int[] charu(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (nums[j-1]<nums[j]){
                    int n = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = n;
                }else {
                    break;
                }
            }
        }
        return nums;
    }


    //希尔排序,时间复杂度：最好nlog2n,最坏nlog2n,平均nlog2n
    public int[] xier(int[] nums){
        if(nums.length<=1){
            return nums;
        }
        int n = nums.length;
        int gap = n/2;
        while (gap>0){
            for (int i = gap; i < n; i++) {
                for (int j = i; j >= gap; j=j-gap) {
                    if (nums[j]<nums[j-gap]){
                        int k = nums[j];
                        nums[j] = nums[j-gap];
                        nums[j-gap] = k;
                    }
                }
            }
            gap /= 2;
        }
        return nums;
    }


    //归并排序，时间复杂度：最好nlogn，最坏nlogn，平均nlogn
    public int[] guibin(int[] nums){
        if (nums.length<=1){
            return nums;
        }
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid,nums.length);
        return nums;
    }
    private int[] hebin(int[] left, int[] right) {
        int[] nums = new int[left.length + right.length];
        for (int i = 0,j=0,k=0;k < nums.length ;k++ ) {
            if (i >= left.length){
                nums[k] = right[j++];
            }else if (j >= right.length){
                nums[k] = left[i++];
            }else if (left[i] < right[j]){
                nums[k] = left[i++];
            }else {
                nums[k] = right[j++];
            }
        }
        return nums;
    }


    //快速排序，时间复杂度：最好nlogn，最坏n平方，平均nlogn
    public int[] kuaipai(int[] nums,int start,int end){
        if (start>end){
            return null;
        }
        int n = nums[start];
        int i = start;
        int j = end;
        while (i!=j){
            while (nums[j]>=n&&j!=i){
                j--;
            }
            while (nums[i]<=n&&j!=i){
                i++;
            }
            int k = nums[i];
            nums[i] = nums[j];
            nums[j] = k;
        }
        nums[start] = nums[i];
        nums[i] = n;
        kuaipai(nums,start,i-1);
        kuaipai(nums,i+1,end);
        return nums;
    }


    public void swap(int[] array,int i, int j){
        int n = array[i];
        array[i] = array[j];
        array[j] = n;
    }

    //堆排序
    public  int[] dui(int[] array) {
        int len = array.length-1;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len );
            len--;
            adjustHeap1(array, 0,len);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public  void buildMaxHeap(int[] array) {
        for (int i = 0; i <array.length; i++) {
            adjustHeap(array, i);
        }
    }
     //向上调整使之成为最大堆
    public  void adjustHeap(int[] array, int i) {
        if (i<1){
            return;
        }
        if(array[i]>array[(i-1)/2]){
            swap(array,i,(i-1)/2);
            adjustHeap(array,(i-1)/2);
        }
    }
    //向下调整使之成为最大堆
    private void adjustHeap1(int[] array, int i ,int len) {
        if (array.length<2||i>len){
            return;
        }
        if (i*2+2<=len){
            if (array[i*2+2]>array[i*2+1]){
                if (array[i]<array[i*2+2]){
                    swap(array,i,i*2+2);
                    adjustHeap1(array, i*2+2,len);
                }
            }else {
                if (array[i]<array[i*2+1]){
                    swap(array,i,i*2+1);
                    adjustHeap1(array, i*2+1,len);
                }
            }
        }else if (i*2+1<=len){
            if (array[i]<array[i*2+1]){
                swap(array,i,i*2+1);
                adjustHeap1(array, i*2+1,len);
            }
        }else {
            return;
        }
    }
}
