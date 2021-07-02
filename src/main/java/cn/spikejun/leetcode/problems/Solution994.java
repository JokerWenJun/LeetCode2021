package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution994 {

    @Test
    public void test()
    {
        int[][]nums=new int[][]{{2,1,1},{0,1,1},{1,0,1}};
//        int[][]nums=new int[][]{{0,2}};
        int i = orangesRotting(nums);
        System.out.println(i);
    }


    public int orangesRotting(int[][] grid) {
        List<int[]>rotOrange=new ArrayList<>();
        Queue<int[]> queue=new LinkedList();
        //记录腐烂的橘子的位置
        int freshOrgange=0;
        //行
        int rows=grid.length;
        //列
        int columns=grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==2)
                {
                    rotOrange.add(new int[]{i,j});
                    queue.add(new int[]{i,j});
                }
                if (grid[i][j]==1)
                {
                    freshOrgange++;
                }
            }
        }
        if (freshOrgange==0)
        {
            return 0;
        }
        int answ=0;
        //开始DFS遍历
        while (!queue.isEmpty())
        {
            int queueNum=queue.size();
            for (int j = 0; j < queueNum; j++) {
                int[] peek = queue.poll();
                //上下左右
                for (int i = 0; i < 4; i++) {
                    int horizontal=0;
                    int vertical=0;
                    if (i==0)
                    {
                        horizontal=peek[1];
                        vertical=peek[0]-1;
                    }
                    else if (i==1)
                    {
                        horizontal=peek[1];
                        vertical=peek[0]+1;
                    }
                    else if (i==2)
                    {
                        horizontal=peek[1]-1;
                        vertical=peek[0];
                    }
                    else if (i==3)
                    {
                        horizontal=peek[1]+1;
                        vertical=peek[0];
                    }
                    //(vertical,horizontal)
                    if (vertical<0||vertical>rows-1||horizontal<0||horizontal>columns-1)
                    {
                        continue;
                    }
                    else
                    {
                        if (grid[vertical][horizontal]==1)
                        {
                            grid[vertical][horizontal]=2;
                            queue.add(new int[]{vertical,horizontal});
                            freshOrgange--;
                        }
                    }
                }
            }
            answ++;
            if (freshOrgange==0)
            {
                return answ;
            }
        }
        if (freshOrgange!=0)
        {
            return -1;
        }
        return answ;
    }
}
