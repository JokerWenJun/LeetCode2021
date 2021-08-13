package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1135 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{{1,2,1},{1,3,2},{3,4,4},{1,4,3}};
        int i = minimumCost(4, arr);
        System.out.println(i);
    }

    public int minimumCost(int n, int[][] connections) {
        UnionFind unionFind=new UnionFind(n);
        //先根据权值排序
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int answ=0;
        for (int i = 0; i < connections.length; i++) {
            int[] currentRoute = connections[i];
            int begin=currentRoute[0]-1;
            int end=currentRoute[1]-1;
            if (unionFind.find(begin)!= unionFind.find(end))
            {
                //合并
                unionFind.merge(begin,end);
                answ+=currentRoute[2];
            }
        }
        //判断是否答案有效
        int[] parents = unionFind.parents;
        int flag=unionFind.find(0);
        for (int i = 0; i < parents.length; i++) {
            if (unionFind.find(i)!=flag)
            {
                return -1;
            }
        }
        return answ;
    }
    class UnionFind
    {
        public int[]parents;
        public int[]rank;
        public int num;

        public UnionFind(int num) {
            this.num = num;
            parents=new int[num];
            rank=new int[num];
            for (int i = 0; i < num; i++) {
                parents[i]=i;
                rank[i]=1;
            }
        }

        public int find(int n)
        {
            if (n==parents[n])
            {
                return parents[n];
            }
            else
            {
                parents[n]=find(parents[n]);
                return parents[n];
            }
        }

        public void merge(int x,int y)
        {
            int xParent = parents[x];
            int yParent = parents[y];
            int currentXDeep = rank[x];
            int currentYDeep = rank[y];
            if (currentXDeep<=currentYDeep)
            {
                parents[xParent]=yParent;
            }
            else
            {
                parents[yParent]=xParent;
            }
            if (currentXDeep==currentYDeep&&xParent!=yParent)
            {
                rank[yParent]++;
            }
        }
    }
}
