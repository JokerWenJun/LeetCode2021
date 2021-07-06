package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution746 {


    @Test
    public void test()
    {
        int[]cost=new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[]dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        /**
         *状态转移:
         * dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
         */
        for (int i = 2; i <= cost.length; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }

}
