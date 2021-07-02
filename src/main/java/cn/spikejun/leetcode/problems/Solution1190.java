package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Deque;
import java.util.Stack;

public class Solution1190 {

    @Test
    public void test()
    {
        String s="a(bcdefghijkl(mno)p)q";
        String s1 = reverseParentheses(s);
        System.out.println(s1);
    }

    public String reverseParentheses(String s) {
        char[] toCharArray = s.toCharArray();
        Stack<Character> stack=new Stack();
        for (int i = 0; i < toCharArray.length; i++) {
            if ((toCharArray[i]>='a'&&toCharArray[i]<='z')||toCharArray[i]=='(')
            {
                stack.push(toCharArray[i]);
            }
            //如果是')'
            else
            {
                StringBuffer stringBuffer=new StringBuffer();
                while (stack.peek()!='(')
                {
                    stringBuffer.append(stack.pop());
                }
                stack.pop();
                String bufftoString = stringBuffer.toString();
                char[] chars = bufftoString.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    stack.push(chars[j]);
                }
            }
        }
        StringBuffer answBuff=new StringBuffer();
        while (!stack.isEmpty())
        {
            answBuff.append(stack.pop());
        }
        StringBuffer reverse = answBuff.reverse();
        String answ=reverse.toString();
        return answ;
    }

}
