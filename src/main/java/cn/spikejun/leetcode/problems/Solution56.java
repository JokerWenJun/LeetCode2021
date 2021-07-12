package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution56 {

    @Test
    public void test()
    {
        int[][]intervals=new int[][]{{1,4},{4,5}};
        int[][] merge = merge(intervals);
        System.out.println("!!!!!");
    }



    public int[][] merge(int[][] intervals) {
        //先将interval进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               if (o1[0]==o2[0])
               {
                   return o1[1]-o2[1];
               }
                else
               {
                   return o1[0]-o2[0];
               }
            }
        });
        //记录每一个合并好的区间
        List<int[]> answ=new LinkedList<>();
        //
        Stack<int[]>stack=new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty())
            {
                stack.add(intervals[0]);
                continue;
            }
            int[] pop = stack.pop();
            int[] currentInterval = intervals[i];
            //如果相交
            if (currentInterval[0]<=pop[1])
            {
                int left=pop[0];
                int right=Math.max(pop[1],currentInterval[1]);
                int[] newInterval=new int[]{left,right};
                stack.add(newInterval);
            }
            //如果不相交
            else
            {
                answ.add(pop);
                stack.add(currentInterval);
            }
        }

        if (!stack.isEmpty())
        {
            answ.add(stack.pop());
        }
        int[][]arr=new int[answ.size()][2];
        for (int i = 0; i < answ.size(); i++) {
            arr[i]=answ.get(i);
        }
        return arr;
    }
}
