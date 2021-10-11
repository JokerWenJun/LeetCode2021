package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution150 {
    @Test
    public void test()
    {
        String[]tokens=new String[]{"4","13","5","/","+"};
        int i = evalRPN(tokens);
        System.out.println(i);
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer>deque=new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/"))
            {
                String signal = tokens[i];
                Integer lastInteger = deque.pollLast();
                Integer secondLastInteger = deque.pollLast();
                int answ=0;
                if (signal.equals("+"))
                {
                    answ=lastInteger+secondLastInteger;
                }else if (signal.equals("-"))
                {
                    answ=secondLastInteger-lastInteger;
                }else if (signal.equals("*"))
                {
                    answ=secondLastInteger*lastInteger;
                }else if (signal.equals("/"))
                {
                  answ=secondLastInteger/lastInteger;
                }
                deque.addLast(answ);
            }
            //means current String is a digital
            else
            {
                int parseInt = Integer.parseInt(tokens[i]);
                deque.addLast(parseInt);
            }
        }
        Integer integer = deque.pollLast();

        return integer;
    }
}
