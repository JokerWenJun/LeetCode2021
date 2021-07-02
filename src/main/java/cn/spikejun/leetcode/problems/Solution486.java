package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution486 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1, 5, 233, 7};
        System.out.println(PredictTheWinner(nums));
    }

    public boolean PredictTheWinner(int[] nums) {
        int size=nums.length;
        int[][]dp=new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i]=nums[i];
        }
        for (int j = 1; j < size; j++) {
            for (int i = j-1; i >= 0; i--) {
                dp[i][j]=Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        if (dp[0][size-1]>=0)
        {
            return true;
        }
        return false;
    }

}
