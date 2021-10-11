package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution174 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{{0,-3}};

        int i = calculateMinimumHP(arr);
        System.out.println(i);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[][]dp=new int[rows+1][columns+1];
        for (int i = 0; i <=rows; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[rows][columns-1]=1;
        dp[rows-1][columns]=1;
        for (int i = rows-1; i>=0; i--) {
            for (int j = columns-1; j>=0; j--) {
                int min=Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=Math.max(min-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
