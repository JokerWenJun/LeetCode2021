package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution5808 {


    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,1};
        int[] concatenation = getConcatenation(nums);
        System.out.println(Arrays.toString(concatenation));
    }

    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int []answ=new int[length*2];
        for (int i = 0; i < answ.length; i++) {
            answ[i]=nums[i%length];
        }
        return answ;
    }

}
