package cn.spikejun.leetcode.problems;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length==0)
        {
            return 0;
        }
        int rows = matrix.length;
        int columns=matrix[0].length;
        int[][]dp=new int[rows][columns];
        int maxLen=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j]=='1')
                {
                    if (i==0||j==0)
                    {
                        dp[i][j]=1;
                    }
                    else {
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    }
                    maxLen=Math.max(maxLen,dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
}
