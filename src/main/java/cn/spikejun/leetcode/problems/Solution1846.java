package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1846 {

    @Test
    public void test()
    {
        int[]arr=new int[]{100,1,1000};
        int i = maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println(i);
    }


    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0]=1;
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - arr[i - 1]);
            if (abs!=0)
            {
                arr[i]=arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }
}
