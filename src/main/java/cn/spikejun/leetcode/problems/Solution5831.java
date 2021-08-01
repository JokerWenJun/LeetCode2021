package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5831 {


    @Test
    public void test()
    {
        int[]arr=new int[]{1,2,3};
        long l = numberOfWeeks(arr);
        System.out.println(l);
    }

    public long numberOfWeeks(int[] milestones) {
        long totalWeeks=0;
        long maxWeeks=0;
        for (int i = 0; i < milestones.length; i++) {
            totalWeeks+=milestones[i];
            maxWeeks=Math.max(maxWeeks,milestones[i]);
        }
        long exceptMaxWeeks=totalWeeks-maxWeeks;
        if (maxWeeks<=exceptMaxWeeks+1)
        {
            return totalWeeks;
        }
        else
        {
            return exceptMaxWeeks*2+1;
        }
    }
}
