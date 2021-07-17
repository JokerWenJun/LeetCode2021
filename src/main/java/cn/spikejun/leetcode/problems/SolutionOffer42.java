package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class SolutionOffer42 {

    @Test
    public void test()
    {
        int[]nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }


    public int maxSubArray(int[] nums) {

        int[]dp=new int[nums.length+1];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i+1]=Math.max(nums[i],nums[i]+dp[i]);
            max=Math.max(dp[i+1],max);
        }
        return max;
    }
}
