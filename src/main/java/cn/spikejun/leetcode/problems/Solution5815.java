package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5815 {

    @Test
    public void test()
    {
        int[][]point=new int[][]{{1,2,3},{1,5,1},{3,1,1}};
        long l = maxPoints(point);
        System.out.println(l);
    }


    private long maxPoint=Integer.MIN_VALUE;
    public long maxPoints(int[][] points) {
        int rows=points.length;
        int columns=points[0].length;
        dfs(points,0,-1,rows,columns,0);
        return maxPoint;
    }

    private void dfs(int[][] points, int currentRow, int preColumn, int rows, int columns,long currentPoint) {
        if (currentRow==rows)
        {
            maxPoint=Math.max(currentPoint,maxPoint);
            return;
        }
        for (int i = 0; i < columns; i++) {
            long copyPoint=currentPoint;
            currentPoint+=points[currentRow][i];
            if (currentRow!=0)
            {
                currentPoint-=Math.abs(i-preColumn);
            }
            dfs(points,currentRow+1,i,rows,columns,currentPoint);
            //回溯到原来状态
            currentPoint=copyPoint;
        }
    }
}
