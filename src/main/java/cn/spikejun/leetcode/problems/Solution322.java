package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution322 {

    @Test
    public void test()
    {
        int[]coins=new int[]{186,419,83,408};
        int i = coinChange(coins, 6249);
        System.out.println(i);
    }




    public int coinChange(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount];
    }
    public int coinChange1(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i>=coins[j])
                {
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        System.out.println(dp[amount]);
        if (dp[amount]==Integer.MAX_VALUE-1||dp[amount]<0)
        {
            dp[amount]=-1;
        }
        return dp[amount];
    }


}
