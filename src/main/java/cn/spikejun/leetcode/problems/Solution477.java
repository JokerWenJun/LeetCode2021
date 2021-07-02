package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution477 {

    @Test
    public void test()
    {
//        String s="111011100110101100101000000000";
//        System.out.println(s.length());
        int[]nums=new int[]{4,14,2};
        int i = totalHammingDistance(nums);
        System.out.println(i);
    }
    public int maxInt=29;
    public int totalHammingDistance(int[] nums) {
        int answ=0;
        for (int i = 0; i <=maxInt; i++) {
            int zeroCount=0;
            int number1Count=0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j]>>i&1)==1)
                {
                    number1Count++;
                }
                else
                {
                    zeroCount++;
                }
            }
            answ=answ+zeroCount*number1Count;
//            System.out.println(answ);
        }
        return answ;
    }

}
