package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution239 {


    @Test
    public void test()
    {
//        System.out.println(Integer.MAX_VALUE);
//        Queue<Integer>priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        priorityQueue.add(3);
//        priorityQueue.add(1);
//        priorityQueue.add(2);
//        System.out.println(priorityQueue.poll());

//        int[]nums=new int[]{1,3,-1,-3,5,3,6,7};
//        int[] ints = maxSlidingWindow(nums, 3);
//        System.out.println(Arrays.toString(ints));
        Double aDouble=Math.pow(26.0,6.0)*6+Math.pow(26.0,5.0)*24+Math.pow(26.0,4.0)*('s'-'a'+1)+Math.pow(26.0,3.0)*('h'-'a'+1)+Math.pow(26.0,2.0)*('r'-'a'+1)+Math.pow(26.0,1.0)*('x'-'a'+1)+('w'-'a'+1);
        System.out.println(aDouble-Math.pow(2.0,31)+1);
        System.out.println(3/26);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //java中PriorityQueue默认是小根堆，要将其转化为大根堆
        Queue<Integer>priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i <k-1; i++) {
            priorityQueue.add(nums[i]);
        }
        int[]ar=new int[nums.length+1-k];
        int j=0;
        for (int i = k-1; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
            Integer peek = priorityQueue.peek();
            ar[j]=peek;
            priorityQueue.remove(nums[i-k+1]);
            j++;
        }
        return ar;
    }

}
