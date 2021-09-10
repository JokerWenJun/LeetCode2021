package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution502 {

    @Test
    public void test()
    {
        int k=1;
        int w=0;
        int []p=new int[]{1,2,3};
        int[]c=new int[]{1,1,2};
        int maximizedCapital = findMaximizedCapital(k, w, p, c);
        System.out.println(maximizedCapital);

//        PriorityQueue<Integer[]>priorityQueue=new PriorityQueue<>(new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o2[0]-o1[0];
//            }
//        });
//        priorityQueue.add(new Integer[]{3,1});
//        priorityQueue.add(new Integer[]{1,3});
//        Integer[] poll = priorityQueue.poll();
//        System.out.println("!!!");


    }


    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int length = profits.length;
        Integer[][]arr=new Integer[profits.length][2];
        //initialize the arr which the first element of each row is profits and the second element of each row is cost
        for (int i = 0; i < length; i++) {
            arr[i][0]=profits[i];
            arr[i][1]=capital[i];
        }
        //sort the arr according to cost
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1]-o2[1];
            }
        });
        //create the priority queue and the queue is a big heap.
        PriorityQueue<Integer[]>priorityQueue=new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0]-o1[0];
            }
        });
        //first arr is the smallest cost, let's check the first element, if the first element cost is bigger than w, we can't do anything.
//        Integer [] first = arr[0];
////        if (first[1]>w)
////        {
////            return 0;
////        }
//        int answ=0;
//        priorityQueue.add(first);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1]<=w)
            {
                priorityQueue.add(arr[i]);
            }
            else {
                while (w<arr[i][1]&&!priorityQueue.isEmpty())
                {
                    Integer[] currentMaxProfits = priorityQueue.poll();
                    w+=currentMaxProfits[0];
                    k--;
                    if (k==0)
                    {
                        return w;
                    }
                }
                if (w<arr[i][1])
                {
                    return w;
                }
                else {
                    priorityQueue.add(arr[i]);
                }
            }
        }
        while (k!=0&&!priorityQueue.isEmpty())
        {
            w+=priorityQueue.poll()[0];
            k--;
        }
        return w;
    }
}
