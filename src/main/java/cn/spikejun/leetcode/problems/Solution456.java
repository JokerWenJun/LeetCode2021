package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution456 {

    @Test
    public void test()
    {
        int[]arr=new int[]{1,2,3,4};
        boolean pattern = find132pattern(arr);
        System.out.println(pattern);
    }


    public boolean find132pattern(int[] nums) {
        int max=Integer.MIN_VALUE;
        Stack<Integer>stack=new Stack<>();
        for (int i = nums.length-1; i >=0; i--) {
            int currentNum=nums[i];
            if (currentNum<max)
            {
                return true;
            }
            while (!stack.isEmpty()&&nums[i]>stack.peek())
            {
                Integer pop = stack.pop();
                max=Math.max(max,pop);
            }
            stack.add(currentNum);
        }
        return false;
    }
}
