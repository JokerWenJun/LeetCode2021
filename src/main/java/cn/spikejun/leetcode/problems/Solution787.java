package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution787 {

    @Test
    public void test()
    {
        int[][] edges= new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int cheapestPrice = findCheapestPrice(4, edges, 0, 3, 1);
        System.out.println(cheapestPrice);
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[]edge=new ArrayList[n];
        int[]prices=new int[n];
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            if (edge[from]==null)
            {
                edge[from]=new ArrayList<>();
            }
            edge[from].add(new int[]{to,price});
        }
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src]=0;
        Queue<int[]>queue=new ArrayDeque<>();
        queue.add(new int[]{src,0,0});
        while (!queue.isEmpty())
        {
            int[] poll = queue.poll();
            int currrentPlace = poll[0];
            int step = poll[1];
            List<int[]> edges = edge[currrentPlace];
            if (edges==null)
            {
                continue;
            }
            if (step>k)
            {
                continue;
            }
            for (int[] eachEdge : edges) {
                int to = eachEdge[0];
                int edgePrice = eachEdge[1];
                if (edgePrice+poll[2]<prices[to])
                {
                    prices[to]=edgePrice+poll[2];
                    queue.add(new int[]{to,step+1,prices[to]});
                }
            }
        }
        if (prices[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return prices[dst];
    }
}
