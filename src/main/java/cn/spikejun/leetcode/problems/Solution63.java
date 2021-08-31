package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution63 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int i = uniquePathsWithObstacles(arr);
        System.out.println(i);
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][]dp=new int[rows+1][columns+1];
        if (obstacleGrid[0][0]!=1)
        {
            dp[1][1]=1;
        }
        for (int i = 1; i < rows+1; i++) {
            for (int j = 1; j < columns+1; j++) {
                if (obstacleGrid[i-1][j-1]==1)
                {
                    dp[i][j]=0;
                }
                else {
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[rows][columns];
    }
}
