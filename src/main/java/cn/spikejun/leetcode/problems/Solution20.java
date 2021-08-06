package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution20 {


    @Test
    public void test()
    {
        String s="{[]}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }


    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character>deque=new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('||chars[i]=='['||chars[i]=='{')
            {
                deque.addLast(chars[i]);
            }
            else
            {
                if (deque.size()==0)
                {
                    return false;
                }
                if (chars[i]==')')
                {
                    if (deque.peekLast()=='(')
                    {
                        deque.pollLast();
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
                if (chars[i]==']')
                {
                    if (deque.peekLast()=='[')
                    {
                        deque.pollLast();
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
                if (chars[i]=='}')
                {
                    if (deque.peekLast()=='{')
                    {
                        deque.pollLast();
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return deque.size()==0;
    }
}
