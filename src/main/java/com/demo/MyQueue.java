package com.demo;

import java.util.*;

//单调队列
public class MyQueue {
    Deque<Integer> queue = new LinkedList<>();
    public void poll(int n){
        if (!queue.isEmpty()&&queue.peek()==n){
            queue.poll();
        }
    }
    public void add(int n){
        while (!queue.isEmpty()&&n>queue.getLast()){
            queue.removeLast();
        }
        queue.add(n);
    }
    int peek(){
        return queue.peek();
    }
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->pair2[1]-pair1[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
