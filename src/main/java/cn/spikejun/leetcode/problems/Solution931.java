package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution931 {

    @Test
    public void test()
    {
//        int[][]matrix=new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        int[][]matrix=new int[][]{{-48}};
        int i = minFallingPathSum(matrix);
        System.out.println(i);
    }



    public int minFallingPathSum(int[][] matrix) {
        //创建动态数组
        int[][]dp=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=matrix[0][i];
        }
        int length=dp.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j==0)
                {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                }
                else if (j==matrix[0].length-1)
                {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]))+matrix[i][j];
                }
            }
        }
        int answ=Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            answ=Math.min(dp[length-1][i],answ);
        }
        return answ;
    }
}
