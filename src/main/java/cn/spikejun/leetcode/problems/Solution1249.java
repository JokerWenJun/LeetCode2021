package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution1249 {

    @Test
    public void test()
    {
        String s="(a(b(c)d)";
        String s1 = minRemoveToMakeValid(s);
        System.out.println(s1);
    }


    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer=new StringBuffer(s);
        Stack<Integer>stack=new Stack<>();
        Set<Integer> erroPosition=new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==')')
            {
                if (stack.isEmpty())
                {
                    erroPosition.add(i);
                }
                else {
                    stack.pop();
                }
            }
            if (chars[i]=='(')
            {
                stack.add(i);
            }
        }
        while (!stack.isEmpty())
        {
            erroPosition.add(stack.pop());
        }
        StringBuffer answBuff=new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (!erroPosition.contains(i))
            {
                answBuff.append(chars[i]);
            }
        }
        return answBuff.toString();
    }
}
