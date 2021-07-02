package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution279 {

    @Test
    public void test()
    {
        int i = numSquares(13);
        System.out.println(i);
    }


    public int numSquares(int n) {
        Integer bigMax=Integer.MAX_VALUE;
        int[]dp=new int[n+1];
        Arrays.fill(dp,bigMax);
        dp[0]=0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j>=(i*i))
                {
//                    System.out.println("j:"+j+"i:"+i);
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}
