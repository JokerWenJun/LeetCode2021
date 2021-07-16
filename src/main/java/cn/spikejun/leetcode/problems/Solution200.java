package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution200 {

    @Test
    public void test()
    {
        char[][]grid=new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = numIslands(grid);
        System.out.println(i);
    }


    public int numIslands(char[][] grid) {
        int isLand_Num=0;
        int rows=grid.length;
        int columns=grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]=='1')
                {
                    isLand_Num++;
                    //开始dfs
                    dfs(i,j,grid);
                }
            }
        }
        return isLand_Num;
    }

    private void dfs(int i, int j, char[][] grid) {
        int rows=grid.length;
        int columns=grid[0].length;
        if (i<0||j<0||i>rows-1||j>columns-1||grid[i][j]=='0')
        {
            return;
        }
        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
