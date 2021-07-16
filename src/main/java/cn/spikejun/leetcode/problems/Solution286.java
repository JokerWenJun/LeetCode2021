package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution286 {

    @Test
    public void test()
    {
        int[][]nums=new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(nums);
        System.out.println("!!!");
    }


    public void wallsAndGates(int[][] rooms) {
        if (rooms.length==0)
        {
            return;
        }


        Queue<int[]>queue=new ArrayDeque<>();
        int rows=rooms.length;
        int columns=rooms[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rooms[i][j]==0)
                {
                    queue.add(new int[]{i,j});
                }
            }
        }
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int row=poll[0];
                int column=poll[1];
                //循环四个方向
                for (int j = 0; j < 4; j++) {
                    int x=0;
                    int y=0;
                    //j==0向上
                    if (j==0)
                    {
                        x=row-1;
                        y=column;
                    }
                    //向下
                    if (j==1)
                    {
                        x=row+1;
                        y=column;
                    }
                    //向左
                    if (j==2)
                    {
                        x=row;
                        y=column-1;
                    }
                    if (j==3)
                    {
                        x=row;
                        y=column+1;
                    }
                    if (x<0||y<0||x>=rows||y>=columns||rooms[x][y]!=Integer.MAX_VALUE)
                    {
                        continue;
                    }
                    else
                    {
                        rooms[x][y]=rooms[row][column]+1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
