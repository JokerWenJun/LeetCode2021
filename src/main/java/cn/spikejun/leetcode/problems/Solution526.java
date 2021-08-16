package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution526 {

    @Test
    public void test()
    {
        int i = countArrangement(2);
        System.out.println(i);
    }


    private int count=0;
    public int countArrangement(int n) {
        List<Integer>[]eachBitconFormInteger=new ArrayList[n+1];
        for (int i = 1; i <=n; i++) {
            eachBitconFormInteger[i]=new ArrayList<>();
            for (int j = 1; j <=n; j++) {
                if (j%i==0||i%j==0)
                {
                    eachBitconFormInteger[i].add(j);
                }
            }
        }
        boolean[]visited=new boolean[n+1];
        int beginIndex=0;
        dfs(eachBitconFormInteger,visited,n,beginIndex);
        return this.count;
    }

    private void dfs(List<Integer>[] eachBitconFormInteger, boolean[] visited, int n, int beginIndex) {
        if (n==beginIndex)
        {
            count++;
            return;
        }
        List<Integer> list = eachBitconFormInteger[beginIndex + 1];
        for (Integer integer : list) {
            if (!visited[integer])
            {
                visited[integer]=true;
                dfs(eachBitconFormInteger,visited,n,beginIndex+1);
                visited[integer]=false;
            }
        }
    }
}
