package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution5800 {

    @Test
    public void test()
    {
        int[]nums=new int[]{0,2,1,5,3,4};
        int[] ints = buildArray(nums);
        System.out.println(Arrays.toString(ints));
    }


    public int[] buildArray(int[] nums) {
        int[]answ=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answ[i]=nums[nums[i]];
        }
        return answ;
    }
}
