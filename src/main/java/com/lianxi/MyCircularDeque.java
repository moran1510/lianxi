package com.lianxi;

class MyCircularDeque {
    private int[] a;
    private int begin,end;
    private int b;
    public MyCircularDeque(int k) {
        a = new int[k+1];
        b = k+1;
        begin = 0;
        end = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        begin = (begin-1+b)%b;
        a[begin] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        a[end] = value;
        end = (end+1)%b;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        begin = (begin+1)%b;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        end = (end-1+b)%b;
        return true;
    }

    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return a[begin];
    }

    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return a[(end-1+b)%b];
    }

    public boolean isEmpty() {
       if (end==begin){
           return true;
       }else return false;
    }

    public boolean isFull() {
        if ((end+1)%b==begin){
            return true;
        }
        else return false;
    }
}
