package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution743 {

    @Test
    public void test()
    {
        int[][]times=new int[][]{
                {1,2,1},
        };
        int i = networkDelayTime(times, 2, 2);
        System.out.println(i);
    }

    private int CANOT_ARRIVE=100000;
    public int networkDelayTime(int[][] times, int n, int k) {
        //如果当前的节点为1，则不需要时间就能返回
        if (n==1)
        {
            return 0;
        }
        //创建出图
        int[][]map=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j)
                {
                    map[i][j]=CANOT_ARRIVE;
                }
            }
        }
        for (int i = 0; i < times.length; i++) {
            int beginIndex=times[i][0]-1;
            int endIndex=times[i][1]-1;
            int value=times[i][2];
            map[beginIndex][endIndex]=value;
        }
        //初始化
        boolean[]visited=new boolean[n];
        int[]distance=map[k-1].clone();
        visited[k-1]=true;

        for (int i = 1; i < n; i++) {
            //每次找出离k最近的点并且该点没有被访问过
            int minDistance=CANOT_ARRIVE;
            int minDistanceIndex=-1;
            for (int j = 0; j < distance.length; j++) {
                if (distance[j]<minDistance&&visited[j]==false)
                {
                    minDistanceIndex=j;
                    minDistance=distance[j];
                }
            }
            //如果没有找到，则说明肯定有一个点无法到达
            if (minDistanceIndex==-1)
            {
                return -1;
            }
            //如果找到了，则说明了当前该点离源点就是最近的并且不会随着后面的改变而改变因为后面的距离都比当前的要长
            visited[minDistanceIndex]=true;
            //根据该点更新与该点连接的是有点
            for (int l = 0; l < n; l++) {
                if (map[minDistanceIndex][l]!=CANOT_ARRIVE&&l!=minDistanceIndex&&visited[l]==false)
                {
                    //判断是否更新
                    distance[l]=Math.min(distance[l],map[minDistanceIndex][l]+minDistance);
                }
            }
        }
        //找出distance最大的就是最长的时间
        int answ=-1;
        for (int i = 0; i < distance.length; i++) {
            answ=Math.max(distance[i],answ);
        }
        return answ;
    }
}
