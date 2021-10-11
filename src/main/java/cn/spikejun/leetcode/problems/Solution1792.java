package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1792 {
    @Test
    public void test()
    {
        int[][]classes=new int[][]{{1,2},{3,5},{2,2}};
        double v = maxAverageRatio(classes, 2);
        System.out.println(v);
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]>priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int x1=o1[0];
                int y1=o1[1];
                int x2=o2[0];
                int y2=o2[1];
                double answ1=((double) (y1-x1))/((double) (y1+1)*y1);
                double answ2=((double) (y2-x2))/((double) (y2+1)*y2);
                if (answ2>=answ1)
                {
                    return 1;
                }
               else
                {
                    return -1;
                }
            }
        });
        for (int[] aClass : classes) {
            priorityQueue.add(aClass);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = priorityQueue.poll();
            poll[0]=poll[0]+1;
            poll[1]=poll[1]+1;
            priorityQueue.add(poll);
        }
        double amount=0;
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            int[] poll = priorityQueue.poll();
            double each=(double)poll[0]/(double) poll[1];
            amount+=each;
        }
        return amount/size;
    }
}
