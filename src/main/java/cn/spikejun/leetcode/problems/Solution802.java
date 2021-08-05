package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer>answ=new ArrayList<>();
        //总共多少个节点
        int length = graph.length;
        /**
         * 0:代表还没有访问，也就是最初始的状态
         * 1:代表已经在环中
         * 2:代表没在环上
         */
        int[]colors=new int[length];
        for (int i = 0; i < length; i++) {
            //判断当前节点是否安全
            if (isSafe(i,graph,colors))
            {
                answ.add(i);
            }
        }
        return answ;
    }

    private boolean isSafe(int index, int[][] graph, int[] colors) {
        if (colors[index]>0)
        {
            return colors[index]==2;
        }
        //如果还没有涂色,就先让它涂成1
        colors[index]=1;
        for (int i = 0; i < graph[index].length; i++) {
            //如果当前连接的任何一个节点是不安全的，那么它就是不安全的
            if (!isSafe(graph[index][i],graph,colors))
            {
                return false;
            }
        }
        //如果它的所有节点都是安全节点那么它当前就是安全节点
        colors[index]=2;
        return true;
    }
}
