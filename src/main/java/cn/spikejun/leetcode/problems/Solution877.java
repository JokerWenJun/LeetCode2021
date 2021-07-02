package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution877 {

    @Test
    public void test()
    {
        int[]nums=new int[]{5,3,4,5};
        boolean b = stoneGame(nums);
        System.out.println(b);
    }


    public boolean stoneGame(int[] piles) {
        int size=piles.length;
        int[][]dp=new int[size][size];
        //初始化
        for (int i = 0; i < size; i++) {
            dp[i][i]=piles[i];
        }
        for (int i = 1; i < size; i++) {
            for (int j = i-1; j >= 0; j--) {
                dp[j][i]=Math.max(piles[j]-dp[j+1][i],piles[i]-dp[j][i-1]);
            }
        }
        int answ=dp[0][size-1];
        if (answ>0)
        {
            return true;
        }
        return false;
    }


}
