package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution695 {

    @Test
    public void test()
    {

    }



    private int currentCount=0;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int maxIsLand=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]==1)
                {
                    dfsSearchIsLand(i,j,grid);
                    maxIsLand=Math.max(maxIsLand,currentCount);
                    currentCount=0;
                }
            }
        }
        return maxIsLand;
    }

    private void dfsSearchIsLand(int i, int j, int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (i<0||j<0||i>rows-1||j>columns-1||grid[i][j]==0)
        {
            return;
        }
        else
        {
            currentCount++;
            grid[i][j]=0;
            //上下左右四个方向
            for (int k = 0; k < 4; k++) {
                if (k==0)
                {
                    dfsSearchIsLand(i-1,j,grid);
                }
                if (k==1)
                {
                    dfsSearchIsLand(i+1,j,grid);
                }
                if (k==2)
                {
                    dfsSearchIsLand(i,j-1,grid);
                }
                if (k==3)
                {
                    dfsSearchIsLand(i,j+1,grid);
                }
            }
        }
    }
}
