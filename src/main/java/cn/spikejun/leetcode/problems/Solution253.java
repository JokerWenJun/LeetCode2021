package cn.spikejun.leetcode.problems;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution253 {



    public int minMeetingRooms(int[][] intervals) {
        //
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //
        PriorityQueue<Integer>priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int[] currentMettingTime = intervals[i];
            if (priorityQueue.isEmpty())
            {
                priorityQueue.add(currentMettingTime[1]);
            }
            else
            {
                //比较当前会议的开始时间和开会时间最晚的公司的
                Integer peek = priorityQueue.peek();
                int beginTime=currentMettingTime[0];
                if (beginTime<peek)
                {
                    priorityQueue.add(currentMettingTime[1]);
                }
                else
                {
                    priorityQueue.poll();
                    priorityQueue.add(currentMettingTime[1]);
                }
            }
        }
        return priorityQueue.size();
    }
}
