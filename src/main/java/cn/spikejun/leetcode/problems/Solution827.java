package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution827 {

    @Test
    public void test()
    {
        int[][]grid=new int[][]{{0,0},{0,1}};
        int i = largestIsland(grid);
        System.out.println(i);
    }



    //每一个岛屿的大小
    private int eachIslandArea=0;
    public int largestIsland(int[][] grid) {
        //下标--岛屿的大小
        Map<Integer,Integer>eachIsLandIndexToCount=new HashMap<>();
        //当前岛屿最大的面积
        int currentMaxIsLand=0;
        //每个岛屿的下标
        int index=2;
        int rows = grid.length;
        int columns = grid[0].length;
        //先统计出每个岛屿的大小
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]==1)
                {
                    dfs(i,j,index,grid);
                    eachIsLandIndexToCount.put(index,eachIslandArea);
                    index++;
                    currentMaxIsLand=Math.max(currentMaxIsLand,eachIslandArea);
                    this.eachIslandArea=0;
                }
            }
        }
        //代表全是水
        if (currentMaxIsLand==0)
        {
            return 1;
        }
        //再次遍历整个map，遍历标记为0的位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]==0)
                {
                    //判断其上下左右四个方向are的下标，注意这里储存的方法不能使用list是可能存在不同方向相同下标的岛屿
                    Set<Integer>set =getSurroundingIsLandIndex(i,j,grid);
                    int combinArea=1;
                    if (set.size()==0)
                    {
                        combinArea=1;
                    }
                    else
                    {
                        for (Integer surrendingIndex : set) {
                            Integer area = eachIsLandIndexToCount.get(surrendingIndex);
                            combinArea+=area;
                        }
                    }
                    currentMaxIsLand=Math.max(combinArea,currentMaxIsLand);
                }
            }
        }
        return currentMaxIsLand;
    }

    private Set<Integer> getSurroundingIsLandIndex(int i, int j, int[][] grid) {
        int rows = grid.length;
        int cloumns = grid[0].length;
        Set<Integer>set=new HashSet<>();
        for (int k = 0; k < 4; k++) {
            if (k==0)
            {
                int nextRow=i-1;
                int nextCol=j;
                //判断是否符合规范
                if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns&&grid[nextRow][nextCol]!=0)
                {
                    set.add(grid[nextRow][nextCol]);
                }
            }
            if (k==1) {
                int nextRow=i+1;
                int nextCol=j;
                //判断是否符合规范
                if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns&&grid[nextRow][nextCol]!=0)
                {
                    set.add(grid[nextRow][nextCol]);
                }
            }
            if (k==2)
            {
                int nextRow=i;
                int nextCol=j-1;
                //判断是否符合规范
                if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns&&grid[nextRow][nextCol]!=0)
                {
                    set.add(grid[nextRow][nextCol]);
                }
            }
            if (k==3)
            {
                int nextRow=i;
                int nextCol=j+1;
                //判断是否符合规范
                if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns&&grid[nextRow][nextCol]!=0)
                {
                    set.add(grid[nextRow][nextCol]);
                }
            }
        }
        return set;
    }

    private void dfs(int i, int j, int index,int[][]map) {
        if (map[i][j]!=1)
        {
            return;
        }
        else
        {
            int rows=map.length;
            int cloumns=map[0].length;
            //表示当前的岛屿的大小+1
            eachIslandArea++;
            //先将这块标记为index，表示属于哪个区域的岛屿
            map[i][j]=index;
            //开始上下左右进行遍历
            for (int k = 0; k < 4; k++) {
                //上
                if (k==0)
                {
                    int nextRow=i-1;
                    int nextCol=j;
                    //判断是否符合规范
                    if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns)
                    {
                        dfs(nextRow,nextCol,index,map);
                    }
                }
                //下
                if (k==1)
                {
                    int nextRow=i+1;
                    int nextCol=j;
                    //判断是否符合规范
                    if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns)
                    {
                        dfs(nextRow,nextCol,index,map);
                    }
                }
                //左
                if (k==2)
                {
                    int nextRow=i;
                    int nextCol=j-1;
                    //判断是否符合规范
                    if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns)
                    {
                        dfs(nextRow,nextCol,index,map);
                    }
                }
                //右
                if (k==3)
                {
                    int nextRow=i;
                    int nextCol=j+1;
                    //判断是否符合规范
                    if (nextRow>=0&&nextCol>=0&&nextRow<rows&&nextCol<cloumns)
                    {
                        dfs(nextRow,nextCol,index,map);
                    }
                }
            }
        }
    }
}
