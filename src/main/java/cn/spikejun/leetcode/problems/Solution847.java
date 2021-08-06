package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution847 {
    @Test
    public void test()
    {
        int[][]graph=new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}};
        int i = shortestPathLength(graph);
        System.out.println(i);
    }


    public int shortestPathLength(int[][] graph) {
        /**
         * queue中每个一维数组储存三个数
         * 1:当前点的坐标
         * 2:遍历到当前点所经过的点是一个二进制表表示，比如000101,如果当前的节点为2，就表示当前经过0和2这两个节点
         * 3:当前所走的距离
         */
        int points = graph.length;
        Queue<int[]>queue=new ArrayDeque<>();
        boolean[][]vistied=new boolean[points][(int) (Math.pow(2,points))];
        int distance=0;
        //初始化
        for (int i = 0; i < points; i++) {
            queue.offer(new int[]{i, (int) Math.pow(2,i),0});
            vistied[i][1<<i]=true;
        }
        //开始BFS
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                //判断当前是否已经遍历完成
                if (poll[1]==(int) Math.pow(2,points)-1)
                {
                    return poll[2];
                }
                //搜索当前节点对应的边
                int currentPoint = poll[0];
                for (int j : graph[currentPoint]) {
                    //判断是否进入队列
                    int nextPoint=j;
                    int nextRoute=poll[1]|(1<<j);
                    int nextDistance=poll[2]+1;
                    //代表没有访问过
                    if (!vistied[nextPoint][nextRoute])
                    {
                        vistied[nextPoint][nextRoute]=true;
                        queue.offer(new int[]{nextPoint,nextRoute,nextDistance});
                    }
                }
            }
        }
        return distance;
    }
}
