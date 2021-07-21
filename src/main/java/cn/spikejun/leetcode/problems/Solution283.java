package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution283 {


    @Test
    public void test()
    {
        int[]nums=new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0)
            {
                nums[j]=nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
