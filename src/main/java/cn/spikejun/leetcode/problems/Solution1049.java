package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1049 {

    @Test
    public void test()
    {
        int[]stones=new int[]{1,2};
        int i = lastStoneWeightII(stones);
        System.out.println(i);
    }



    public int lastStoneWeightII(int[] stones) {
        Integer sum=0;
        for (int i = 0; i < stones.length; i++) {
            sum+=stones[i];
        }
        Integer negativeSum=sum/2;
        int[][]dp=new int[stones.length+1][negativeSum+1];
        for (int i = 1; i < stones.length+1; i++) {
            for (int j = 0; j <= negativeSum; j++) {
                if (j>=stones[i-1])
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int trueNegativeSum=dp[stones.length][negativeSum];
        int truePostiveSum=sum-trueNegativeSum;
        int answ=truePostiveSum-trueNegativeSum;
        return answ;
    }
}
