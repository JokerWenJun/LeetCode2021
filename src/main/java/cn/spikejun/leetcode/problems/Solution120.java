package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution120 {


    @Test
    public void test()
    {
        int[][]arr=new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer>currentRow=new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                currentRow.add(arr[i][j]);
            }
            triangle.add(currentRow);
        }
        int i = minimumTotal(triangle);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][]dp=new int[size][size];
        for (int i = 0; i < triangle.size(); i++) {
            if (i==0)
            {
                dp[0][0]=triangle.get(i).get(i);
                continue;
            }
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j < currentRow.size(); j++) {
                if (j==0)
                {
                    dp[i][j]=dp[i-1][j]+currentRow.get(j);
                }
                else if (j==currentRow.size()-1)
                {
                    dp[i][j]=dp[i-1][j-1]+currentRow.get(j);
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+currentRow.get(j);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < dp[size - 1].length; i++) {
            min=Math.min(dp[size-1][i],min);
        }
        return min;
    }



    private int minRoute=Integer.MAX_VALUE;
    public int minimumTotal1(List<List<Integer>> triangle) {
        int depth=triangle.size();
        dfs(0,0,0,triangle,0);
        return minRoute;
    }

    private void dfs(int currentDepth, int currentRow, int currentColumn, List<List<Integer>> triangle, int amount) {
        amount+= triangle.get(currentDepth).get(currentColumn);
        if (currentDepth==triangle.size()-1)
        {
            minRoute=Math.min(minRoute,amount);
            return;
        }
        for (int i=0;i<2;i++)
        {
            int nextRow=currentRow+1;
            int nextcolumn=currentColumn+i;
            dfs(currentDepth+1,nextRow,nextcolumn,triangle,amount);
        }
    }
}
