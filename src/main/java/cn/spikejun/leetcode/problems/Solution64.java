package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution64 {

    @Test
    public void test()
    {
//        int[][]nums=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
//        int i = minPathSum(nums);
//        System.out.println(i);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(123%10);

    }


    public int minPathSum(int[][] grid) {
        int[][]dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        //横向初始化
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        //竖向初始化
        for (int i = 1; i < grid.length; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //开始dp
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j]=Math.min(grid[i][j]+dp[i-1][j],grid[i][j]+dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


}
