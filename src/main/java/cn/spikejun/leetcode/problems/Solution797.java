package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Solution797 {

    private List<List<Integer>>answ=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer>route=new ArrayList<>();
        int n = graph.length;
        route.add(0);
        dfs(route,graph,0,n-1);
        return answ;
    }

    private void dfs(List<Integer> route, int[][] graph, int current, int target) {
        if (current==target)
        {
            answ.add(new ArrayList<>(route));
            return;
        }
        int[] currentEdge = graph[current];
        if (currentEdge!=null)
        {
            for (int i = 0; i < currentEdge.length; i++) {
                route.add(currentEdge[i]);
                dfs(route,graph,currentEdge[i],target);
                route.remove(route.size()-1);
            }
        }
    }
}
