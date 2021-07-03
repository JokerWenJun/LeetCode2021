package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution785 {

    @Test
    public void test()
    {
        int[][]graph=new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        boolean bipartite = isBipartite(graph);
        System.out.println(bipartite);
    }


    private int NOCOLOR=0;
    private int GREEN=1;
    private int RED=2;
    private int[]colors;
    public boolean isBipartite(int[][] graph) {
        int nodeNum=graph.length;
        colors=new int[nodeNum];
        Arrays.fill(colors,NOCOLOR);
        for (int i = 0; i < nodeNum; i++) {
            //判断当前的点是否已经上色
            if (colors[i]==NOCOLOR)
            {
                //如果没有上色则从当前的点进行BFS
                colors[i]=GREEN;
                Queue<Integer>queue=new ArrayDeque();
                queue.add(i);
                while (!queue.isEmpty())
                {
                    Integer node = queue.poll();
                    int nextColor=colors[node]==GREEN?RED:GREEN;
                    for (int j = 0; j < graph[node].length; j++) {
                        if (colors[graph[node][j]]==NOCOLOR)
                        {
                            colors[graph[node][j]]=nextColor;
                            queue.add(graph[node][j]);
                        }
                        else
                        {
                            if (colors[graph[node][j]]!=nextColor)
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
