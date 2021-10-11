package cn.spikejun.leetcode.problems;

public class Solution256 {

    public int minCost(int[][] costs) {
        int houseSize=costs.length;
        int colorSize=costs[0].length;
        int[][]dp=new int[houseSize][colorSize];
        dp[0]=costs[0];
        for (int i = 1; i < houseSize; i++) {
            for (int j = 0; j < colorSize; j++) {
                int minCost=Integer.MAX_VALUE;
                for (int k = 0; k < colorSize; k++) {
                    if (j==k)
                    {
                        continue;
                    }
                    minCost=Math.min(minCost,dp[i-1][k]);
                }
                dp[i][j]=minCost+costs[i][j];
            }
        }
        int answ=Integer.MAX_VALUE;
        for (int i = 0; i < colorSize; i++) {
            answ=Math.min(answ,dp[houseSize-1][i]);
        }
        return answ;
    }
}
