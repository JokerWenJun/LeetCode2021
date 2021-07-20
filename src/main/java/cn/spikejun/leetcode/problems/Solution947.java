package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution947 {

    @Test
    public void test()
    {
        int[][]stone=new int[][]{
                {0,0},
                {0,1},
                {1,0},
                {1,2},
                {2,1},
                {2,2}
        };
        int i = removeStones(stone);
        System.out.println(i);
    }


    class UnionFind
    {
        private int count;
        private int[]parent;
        private int[] hight;
        public UnionFind( int n) {
            //最开始是每一个点就是一个分区
            count=n;
            parent=new int[n];
            hight=new int[n];
            //每一个分区最开始的父亲节点就是它自己
            for (int i = 0; i < n; i++) {
                parent[i]=i;
            }
        }

        public int find(int x)
        {
            if (x==parent[x])
            {
                return parent[x];
            }
            else
            {
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public void merge(int x,int y)
        {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot==yRoot)
            {
                return;
            }
            parent[xRoot]=yRoot;
            count--;
        }

        public int getCount()
        {
            return count;
        }
    }


    public int removeStones(int[][] stones) {
        int length = stones.length;
        UnionFind unionFind=new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                {
                    unionFind.merge(i,j);
                }
            }
        }
        return length-unionFind.count;
    }
}
