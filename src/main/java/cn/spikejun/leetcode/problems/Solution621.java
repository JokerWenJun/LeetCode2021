package cn.spikejun.leetcode.problems;

import java.util.*;

public class Solution621 {

    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer>eachTaskCount=new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            eachTaskCount.put(tasks[i],eachTaskCount.getOrDefault(tasks[i],0)+1);
        }
        //每个任务能执行的时间点
        List<Integer>nextBeginTime=new ArrayList<>();
        //每个任务的数量
        List<Integer>taskCount=new ArrayList<>();
        //循环map
        Set<Character> characters = eachTaskCount.keySet();
        for (Character character : characters) {
            taskCount.add(eachTaskCount.get(character));
            //初始状态每个任务开始的时间都为1
            nextBeginTime.add(1);
        }
        //时间
        int time=0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < nextBeginTime.size(); ++j) {
                if (taskCount.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextBeginTime.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < taskCount.size(); ++j) {
                if (taskCount.get(j) != 0 && nextBeginTime.get(j) <= time) {
                    if (best == -1 || taskCount.get(j) > taskCount.get(best)) {
                        best = j;
                    }
                }
            }
            nextBeginTime.set(best, time + n + 1);
            taskCount.set(best, taskCount.get(best) - 1);
        }
        return time;
    }
}
