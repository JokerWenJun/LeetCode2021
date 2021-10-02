package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution650 {

    @Test
    public void test()
    {
        int i = minSteps(3);
        System.out.println(i);
    }


    public int minSteps(int n) {
        if (n==0||n==1)
        {
            return 0;
        }

        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <=n; i++) {
            for (int j = 1; j*j <=i; j++) {
                if (i%j==0)
                {
                    dp[i]=Math.min(dp[i],dp[j]+i/j);
                    dp[i]=Math.min(dp[i],dp[i/j]+j);
                }
            }
        }
        return dp[n];
    }


}
