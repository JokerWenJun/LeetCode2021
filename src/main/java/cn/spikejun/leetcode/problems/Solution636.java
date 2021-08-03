package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution636 {

    @Test
    public void test()
    {
        List<String>logs=new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        int[] ints = exclusiveTime(2, logs);
        System.out.println("!!!");

    }


    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer>stack=new Stack<>();
        int[]times=new int[n];
        String firstLog = logs.get(0);
        String[] split = firstLog.split(":");
        stack.add(Integer.valueOf(split[0]));
        int preTime=Integer.valueOf(split[2]);
        int i=1;
        while (i<logs.size())
        {
            String currentInterval = logs.get(i);
            String[] currentSplits = currentInterval.split(":");
            if (currentSplits[1].equals("start"))
            {
                if (!stack.isEmpty())
                {
                    times[stack.peek()]+=Integer.valueOf(currentSplits[2])-preTime;
                }
                stack.add(Integer.valueOf(currentSplits[0]));
                preTime=Integer.valueOf(currentSplits[2]);
            }
            else
            {
                Integer pop = stack.pop();
                times[pop]+=Integer.valueOf(currentSplits[2])-preTime+1;
                preTime=Integer.valueOf(currentSplits[2])+1;
            }
            i++;
        }
        return times;
    }
}
