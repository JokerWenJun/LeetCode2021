package cn.spikejun.leetcode.problems;

public class SolutionOffer47 {

    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][]dp=new int[rows+1][columns+1];
        for (int i = 1; i <=rows; i++) {
            for (int j = 1; j <=columns; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[rows][columns];
    }
}
