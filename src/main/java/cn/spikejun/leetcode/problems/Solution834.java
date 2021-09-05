package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution834 {
    private List<List<Integer>>graph;
    private int []distance;
    private int []childs;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        //change edges to graph which each points link to other points
        graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] eachSide = edges[i];
            int src=eachSide[0];
            int des=eachSide[1];
            graph.get(src).add(des);
            graph.get(des).add(src);
        }
        //create two array, first array means the total distance of each point to the other points.
        //second means the  number of child points of each points.
        distance=new int[n];
        childs=new int[n];
        //because each points must have one child(itself),so lets fill the childs array with one.
        Arrays.fill(childs,1);
        //begin the main step
        //first step is calculating the the total distance of each point with their child. the processing also can help us calculate
        //the number of child of each points.
        calculateTheDistanceAndNumberOfTheirChilds(0,-1);
        //the step two is calculating the answ array
        calculateTheDistanceOfEachPointWithTheOtherPoint(0,-1);
        return distance;
    }

    private void calculateTheDistanceOfEachPointWithTheOtherPoint(int root, int parent) {
        List<Integer> neighbor = graph.get(root);
        for (int i = 0; i < neighbor.size(); i++) {
            if (neighbor.get(i)==parent)
            {
                continue;
            }
            distance[neighbor.get(i)]=distance[root]-childs[neighbor.get(i)]+graph.size()-childs[neighbor.get(i)];
            calculateTheDistanceOfEachPointWithTheOtherPoint(neighbor.get(i),root);
        }
    }

    private void calculateTheDistanceAndNumberOfTheirChilds(int root, int parent) {
        List<Integer> neighbor = graph.get(root);
        for (int i = 0; i < neighbor.size(); i++) {
            if (neighbor.get(i)==parent)
            {
                continue;
            }
            calculateTheDistanceAndNumberOfTheirChilds(neighbor.get(i),root);
            childs[root]+=childs[neighbor.get(i)];
            distance[root]+=distance[neighbor.get(i)]+childs[neighbor.get(i)];
        }
    }
}
