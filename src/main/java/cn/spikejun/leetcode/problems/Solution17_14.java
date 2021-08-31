package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution17_14 {

    @Test
    public void test()
    {
        int[]arr=new int[]{1,3,5,7,2,4,6,8};
        int[] ints = smallestK(arr, 4);
        System.out.println(Arrays.toString(ints));
    }


    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int []answ=new int[k];
        for (int i = 0; i < k; i++) {
            answ[i]=queue.poll();
        }
        return answ;
    }

}
