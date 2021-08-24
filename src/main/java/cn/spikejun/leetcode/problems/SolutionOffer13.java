package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SolutionOffer13 {

    @Test
    public void test()
    {
        int m=16;
        int n=8;
        int k=4;
        int i = movingCount(m, n, k);
        System.out.println(i);
//        int value = getTheValueOfRowAddColumn(new int[]{26, 789});
//        System.out.println(value);
    }


    public int movingCount(int m, int n, int k) {
        Queue<int[]>queue=new ArrayDeque<>();
        queue.add(new int[]{0,0});
        Set<String>visited=new HashSet<>();
        visited.add("0-0");
        int[][]directions=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int count=1;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                //judge current position is accurate
//                int value=getTheValueOfRowAddColumn(poll);
//                if (value<=k)
//                {
//                    count++;
//                }
                // begin to change direction
                for (int j = 0; j < directions.length; j++) {
                    int[] nextPosition=new int[]{poll[0]+directions[j][0],poll[1]+directions[j][1]};
                    String s=nextPosition[0]+"-"+nextPosition[1];
                    if (nextPosition[0]<0||nextPosition[0]>m-1||nextPosition[1]<0||nextPosition[1]>n-1||getTheValueOfRowAddColumn(nextPosition)>k||visited.contains(s))
                    {
                        continue;
                    }
//                    String s=nextPosition[0]+"-"+nextPosition[1];
                    visited.add(s);
                    queue.add(nextPosition);
                    count++;
                }
            }
        }
        return count;
    }

    private int getTheValueOfRowAddColumn(int[] poll) {
        int value=0;
        for (int i = 0; i < poll.length; i++) {
            int num = poll[i];
            while (num!=0)
            {
                value+=num%10;
                num=num/10;
            }
        }
        return value;
    }
}
