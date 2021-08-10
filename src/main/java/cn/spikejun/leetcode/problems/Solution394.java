package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Stack;

public class Solution394 {

    @Test
    public void test()
    {
        String s="2[abc]3[cd]ef";
        String s1 = decodeString(s);
        System.out.println(s1);
    }


    public String decodeString(String s) {
        Stack<String>stack=new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //如果当前的元素为[，直接入栈
            if (chars[i]=='[')
            {
                stack.add(String.valueOf(chars[i]));
            }
            //如果当前为字符，也就是a-z
            if (chars[i]>='a'&&chars[i]<='z')
            {
                stack.add(String.valueOf(chars[i]));
            }
            //如果当前为数字，我们需要判断是否是一位数还是多位数
             if (chars[i]>='0'&&chars[i]<='9')
             {
                 StringBuffer number=new StringBuffer();
                 while (i<chars.length&&chars[i]>=0&&chars[i]<='9')
                 {
                     number.append(chars[i]);
                     i++;
                 }
                 i--;
                 stack.add(number.toString());
             }
             //如果当前为]
            if (chars[i]==']')
            {
                StringBuffer buffer=new StringBuffer();
                while (!stack.isEmpty())
                {
                    if (stack.peek().equals("["))
                    {
                        stack.pop();
                        break;
                    }
                    else
                    {
                        buffer.append(stack.pop());
                    }
                }
                int count=Integer.valueOf(stack.pop());
                buffer.reverse();
                char[] toCharArray = buffer.toString().toCharArray();
                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < toCharArray.length; k++) {
                        stack.add(String.valueOf(toCharArray[k]));
                    }
                }
            }
        }
        StringBuffer answBuffer=new StringBuffer();
        //此时stack里面的就是答案
        while (!stack.isEmpty())
        {
            answBuffer.append(stack.pop());
        }
        return answBuffer.reverse().toString();
    }
}
