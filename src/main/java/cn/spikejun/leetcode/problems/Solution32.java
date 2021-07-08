package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Stack;

public class Solution32 {

    @Test
    public void test()
    {
        String s="(()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
    public int longestValidParentheses(String s) {
        Stack<Integer>stack=new Stack<>();
        stack.add(-1);
        char[] charArray = s.toCharArray();
        int maxLength=0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]=='(')
            {
                stack.add(i);
            }
            //当前位置为)
            else
            {
                stack.pop();
                if (stack.isEmpty())
                {
                    stack.add(i);
                }
                else
                {
                    maxLength=Math.max(maxLength,i-stack.peek());
                }
            }
        }
        return maxLength;
    }
}
