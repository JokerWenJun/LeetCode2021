package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution463 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{{1,1,},{1,1}};
        int i = islandPerimeter(arr);
        System.out.println(i);
    }


    private int[][]directions=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int islandPerimeter(int[][]grid)
    {
         int perimeter=0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]==1)
                {
                    for (int[] direction : directions) {
                        int[]newPosition=new int[]{i+direction[0],j+direction[1]};
                        if (newPosition[0]<0||newPosition[0]>rows-1||newPosition[1]<0||newPosition[1]>columns-1||grid[newPosition[0]][newPosition[1]]==0)
                        {
                            perimeter+=1;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}
