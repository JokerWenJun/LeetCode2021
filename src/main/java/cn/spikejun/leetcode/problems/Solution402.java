package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution402 {

    @Test
    public void test()
    {
        String num="1432219";
        String s = removeKdigits(num, 3);
        System.out.println(s);
    }


    public String removeKdigits(String num, int k) {
        Deque<Character>deque=new ArrayDeque<>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            while (!deque.isEmpty()&&chars[i]<deque.peekLast()&&k>0)
            {
                deque.pollLast();
                k--;
            }
            deque.addLast(chars[i]);
        }
        StringBuffer buffer=new StringBuffer();
        int size = deque.size();
        boolean flag=false;
        for (int i = 0; i < size-k; i++) {
            Character poll = deque.pollFirst();
            if (poll=='0'&&!flag)
            {
                continue;
            }
            flag=true;
            buffer.append(poll);
        }
        return buffer.toString().equals("")?"0":buffer.toString();
    }
}
