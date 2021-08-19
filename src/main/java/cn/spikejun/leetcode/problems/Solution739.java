package cn.spikejun.leetcode.problems;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[]arr=new int[temperatures.length];
        Stack<Integer>stack=new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()])
            {
                arr[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return arr;
    }
}
