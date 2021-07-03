package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution462 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,3};
        int i = minMoves2(nums);
        System.out.println(i);
    }


    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int changeNumber=0;
        //先判断长度是odd或者even
        if (length%2==0)
        {
            changeNumber=(nums[(length/2)]+nums[(length/2)-1])/2;
        }
        else
        {
            changeNumber=nums[(length-1)/2];
        }
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            count=count+Math.abs(nums[i]-changeNumber);
        }
        return count;
    }
}
