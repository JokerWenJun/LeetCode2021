package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionLCP07 {


    @Test
    public void test()
    {
        int[][]relation=new int[][]{{0,1},{0,2},{2,1},{1,2},{1,0},{2,0}};
//        int[][]relation=new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int i = numWays(3, relation, 5);
        System.out.println(i);
    }



    public int numWays(int n, int[][] relation, int k) {
        boolean [][]map=new boolean[n][n];
        //创建map
        for (int i = 0; i < relation.length; i++) {
            int start=relation[i][0];
            int end=relation[i][1];
            map[start][end]=true;
        }
        //创建队列
        Queue<Integer>queue=new ArrayDeque<>();
        queue.add(0);
        int ways=0;
        int step=0;
        while (!queue.isEmpty()&&step<=k-1)
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentPosition=queue.poll();
                for (int j = 0; j < n; j++) {
                    if (map[currentPosition][j])
                    {
                        if (j==n-1)
                        {
                            if (step==k-1)
                            {
                                ways++;
                            }
                            else
                            {
                                queue.add(j);
                            }
                        }
                        else
                        {
                            queue.add(j);
                        }
                    }
                }
            }
            step++;
        }
        return ways;
    }


}
