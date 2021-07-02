package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution494 {


    @Test
    public void test()
    {
        int[]nums=new int[]{2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
        int targetSumWays = findTargetSumWays(nums, 1000);
        System.out.println(targetSumWays);
    }


    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int negativeSum=(sum-target)/2;
        if ((sum-target)%2!=0||negativeSum<0)
        {
            return 0;
        }
        int[][]dp=new int[nums.length+1][negativeSum+1];

        dp[0][0]=1;


        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= negativeSum; j++) {
                if (j>=nums[i-1])
                {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int answ=dp[nums.length][negativeSum];
        return answ;
    }


}
