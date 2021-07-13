package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution973 {


    @Test
    public void test()
    {
        int[][]points=new int[][]{{1,3},{-2,2}};
        int[][] ints = kClosest(points, 1);
        System.out.println("!!!!");

//        PriorityQueue<int[]>queue=new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (Math.pow(o1[0],2)+Math.pow(o1[1],2)>(Math.pow(o2[0],2)+Math.pow(o2[1],2)))
//                {
//                    return -1;
//                }
//                else {
//                    return 1;
//                }
//            }
//        });
//        queue.add(new int[]{1,1});
//        queue.add(new int[]{2,1});
//        queue.add(new int[]{-11,1});
//        int[] poll1 = queue.poll();
//        int[] poll2 = queue.poll();

    }


    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]>queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (Math.pow(o1[0],2)+Math.pow(o1[1],2)>(Math.pow(o2[0],2)+Math.pow(o2[1],2)))
                {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
        int length = points.length;
        for (int i = 0; i < length; i++) {
            queue.add(points[i]);
            if (queue.size()>k)
            {
                queue.poll();
            }
        }
        int[][]answ=new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            answ[i]=poll;
        }
        return answ;
    }
}
