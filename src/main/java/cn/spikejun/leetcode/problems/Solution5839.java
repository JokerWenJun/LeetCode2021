package cn.spikejun.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5839 {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int sum=0;
        for (int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
            sum+=piles[i];
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            int deleteCount = poll / 2;
            sum-=deleteCount;
            poll=poll-deleteCount;
            queue.add(poll);
        }
        return sum;
    }
}
