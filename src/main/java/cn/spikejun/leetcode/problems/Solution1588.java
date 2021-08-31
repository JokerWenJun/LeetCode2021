package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1588 {



    @Test
    public  void test()
    {
        int[]arr=new int[]{1,4,2,5,3};
        int i = sumOddLengthSubarrays(arr);
        System.out.println(i);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int[]sums=new int[arr.length+1];
        int answ=0;
        for (int i = 0; i < arr.length; i++) {
            sums[i+1]=sums[i]+arr[i];
            int j=i;
            while (j>=0)
            {
                int count = sums[i + 1] - sums[j];
                answ+=count;
                j-=2;
            }
        }
        return answ;
    }

}
