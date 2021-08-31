package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5855 {


    @Test
    public void test()
    {
        String s1="1234";
        String s2="5678";
        System.out.println(s1.compareTo(s2));
        String[]nums=new String[]{"3","3"};
        String s = kthLargestNumber(nums, 2);
        System.out.println(s);

    }


    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String>priorityQueue=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length())
                {
                    return 1;
                }
                if (o1.length()<o2.length())
                {
                    return -1;
                }
                if (o1.length()==o2.length())
                {
                    return o1.compareTo(o2);
                }
                return 0;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size()<k)
            {
                priorityQueue.add(nums[i]);
            }
            else
            {
                priorityQueue.add(nums[i]);
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
