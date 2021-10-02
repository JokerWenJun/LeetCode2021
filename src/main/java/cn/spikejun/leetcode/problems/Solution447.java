package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution447 {

    @Test
    public void test()
    {

    }

    public int numberOfBoomerangs(int[][] points) {
        int pointsCount = points.length;
        int answ=0;
        for (int i = 0; i < pointsCount; i++) {
            Map<Integer,Integer>map=new HashMap<>();
            int[] currentPoint = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i==j)
                {
                    continue;
                }
                int[] otherPoint = points[j];
                int distance=(otherPoint[0]-currentPoint[0])*(otherPoint[0]-currentPoint[0])+(otherPoint[1]-currentPoint[1])*(otherPoint[1]-currentPoint[1]);
                map.put(distance,map.getOrDefault(distance,0)+1);
            }
            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                Integer count = map.get(integer);
                answ+=(count)*(count-1);
            }
        }
        return answ;
    }

}
