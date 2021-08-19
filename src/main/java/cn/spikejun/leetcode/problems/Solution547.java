package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution547 {

//    [[1,1,1,0,1,1,1,0,0,0],[1,1,0,0,0,0,0,1,0,0],[1,0,1,0,0,0,0,0,0,0],[0,0,0,1,1,0,0,0,1,0],[1,0,0,1,1,0,0,0,0,0],[1,0,0,0,0,1,0,0,0,0],[1,0,0,0,0,0,1,0,1,0],[0,1,0,0,0,0,0,1,0,1],[0,0,0,1,0,0,1,0,1,1],[0,0,0,0,0,0,0,1,1,1]]
    @Test
    public void test()
    {
        int[][]arr=new int[][]{{1,1,1,0,1,1,1,0,0,0},{1,1,0,0,0,0,0,1,0,0},{1,0,1,0,0,0,0,0,0,0},{0,0,0,1,1,0,0,0,1,0},{1,0,0,1,1,0,0,0,0,0},{1,0,0,0,0,1,0,0,0,0},{1,0,0,0,0,0,1,0,1,0},{0,1,0,0,0,0,0,1,0,1},{0,0,0,1,0,0,1,0,1,1},{0,0,0,0,0,0,0,1,1,1}};
        int circleNum = findCircleNum(arr);
        System.out.println(circleNum);
    }



    class UnionFind
    {
        int []parents;
        int []deeps;
        public UnionFind(int n)
        {
            parents=new int[n];
            deeps=new int[n];
            for (int i = 0; i < n; i++) {
                parents[i]=i;
                deeps[i]=1;
            }
        }

        public int find(int x)
        {
            if (x!=parents[x])
            {
                parents[x]=find(parents[x]);
            }
            return parents[x];
        }

        public void merge(int x,int y)
        {
            int xParent = find(x);
            int xDeep = deeps[x];
            int yParent = find(y);
            int yDeep = deeps[y];
            if (xParent==yParent)
            {
                return;
            }
            if (xDeep!=yDeep)
            {
                if (xDeep>yDeep)
                {
                    parents[yParent]=xParent;
                }
                else {
                    parents[xParent]=yParent;
                }
            }
            else
            {
                parents[yParent]=xParent;
                deeps[xParent]+=1;
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        UnionFind uf=new UnionFind(length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (i!=j&&isConnected[i][j]==1)
                {
                    uf.merge(i,j);
                }
            }
        }
        Set<Integer>set=new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(uf.find(i));
        }
        return set.size();
    }

}
