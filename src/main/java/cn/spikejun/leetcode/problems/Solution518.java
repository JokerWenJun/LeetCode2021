package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution518 {


    @Test
    public void test()
    {
        int[]coins=new int[]{3,5,7,8,9,10,11};
        int change = change(500, coins);
        System.out.println(change);
    }
    //使用动态规划的方法-完全背包
    public int change(int amount, int[] coins) {
        int[]dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j]=dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }




    public int count=0;
    public int change1(int amount, int[] coins) {

        int currentCount=0;
        dfs(coins,amount,currentCount,0);
        int answ=count;
        return answ;
    }

    private void dfs(int[] coins, int amount, int currentCount,int locate) {
        if (currentCount==amount)
        {
            count++;
            return;
        }
        for (int i = locate; i < coins.length; i++) {
            currentCount+=coins[i];
            if (currentCount>amount)
            {
                currentCount-=coins[i];
                continue;
            }
            dfs(coins,amount,currentCount,i);
            currentCount-=coins[i];
        }

    }


}
