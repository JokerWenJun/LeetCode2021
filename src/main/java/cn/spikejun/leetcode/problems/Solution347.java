package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution347 {
    @Test
    public void test()
    {
        int[]nums=new int[]{1,1,1,2,2,3};
        int[] ints = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>numsMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value=numsMap.getOrDefault(nums[i],0)+1;
            numsMap.put(nums[i],value);
        }
        PriorityQueue<Integer>integersQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numsMap.get(o1)-numsMap.get(o2);
            }
        });

        for (Integer integer : numsMap.keySet()) {
            integersQueue.offer(integer);
            if (integersQueue.size()>k)
            {
                integersQueue.poll();
            }
        }
        int[]answ=new int[k];
        for (int i = 0; i < k; i++) {
            answ[i]=integersQueue.poll();

        }
        return answ;
    }

}
