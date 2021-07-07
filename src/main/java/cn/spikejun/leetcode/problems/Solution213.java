package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution213 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }


    public int rob(int[] nums) {
        if (nums.length==1)
        {
            return nums[0];
        }
        int includeFistPosition=robAtCertainPosition(nums,0,nums.length-2);
        int notIncludeFistPosition=robAtCertainPosition(nums,1,nums.length-1);
        return Math.max(includeFistPosition,notIncludeFistPosition);
    }

    private int robAtCertainPosition(int[] nums, int begin, int end) {
        //创建动态数组
        int[]dp=new int[nums.length];
        dp[0]=0;
        //包括第一家
        if (begin==0)
        {
            dp[1]=nums[0];
            for (int i = 2; i < dp.length; i++) {
                dp[i]=Math.max(dp[i-1],nums[i-1]+dp[i-2]);
            }

        }
        else
        {
            dp[1]=nums[1];
            for (int i = 2; i < dp.length; i++) {
                dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
            }
        }
        return dp[dp.length-1];
    }


}
