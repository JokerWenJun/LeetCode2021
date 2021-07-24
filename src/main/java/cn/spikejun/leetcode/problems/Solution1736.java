package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1736 {

    @Test
    public void test()
    {
        String s="2?:?0";
        String s1 = maximumTime(s);
        System.out.println(s1);
    }

    public String maximumTime(String time) {
        StringBuffer buffer=new StringBuffer();
        char[] chars = time.toCharArray();
        //先判断小时
        if (chars[0]=='?'&&chars[1]=='?')
        {
            buffer.append("23");
        }
        if (chars[0]!='?'&&chars[1]!='?')
        {
            buffer.append(chars[0]);
            buffer.append(chars[1]);
        }
        if (chars[0]=='?'&&chars[1]!='?')
        {
            if (chars[1]<='3')
            {
                buffer.append('2');
                buffer.append(chars[1]);
            }
            else {
                buffer.append('1');
                buffer.append(chars[1]);
            }
        }
        if (chars[0]!='?'&&chars[1]=='?')
        {
            if (chars[0]=='2')
            {
                buffer.append("23");
            }
            else
            {
                buffer.append(chars[0]);
                buffer.append('9');
            }
        }
        buffer.append(":");
        //处理分钟
        if (chars[3]=='?'&&chars[4]=='?')
        {
            buffer.append("59");
        }
        if (chars[3]!='?'&&chars[4]!='?')
        {
            buffer.append(chars[3]);
            buffer.append(chars[4]);
        }
        if (chars[3]=='?'&&chars[4]!='?')
        {
            buffer.append('5');
            buffer.append(chars[4]);
        }
        if (chars[3]!='?'&&chars[4]=='?')
        {
            buffer.append(chars[3]);
            buffer.append('9');
        }
        return buffer.toString();
    }



}
