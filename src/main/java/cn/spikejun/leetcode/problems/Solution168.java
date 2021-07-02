package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution168 {

    @Test
    public void test()
    {
        String s = convertToTitle(2147483647);
        System.out.println(s);
    }


    public String convertToTitle(int columnNumber) {

        StringBuffer answBuffer=new StringBuffer();
        while (columnNumber>0)
        {
            columnNumber--;
            char c= (char) ('A'+columnNumber%26);
            StringBuffer prefix=new StringBuffer(c+"");
            answBuffer=prefix.append(answBuffer);
            columnNumber=columnNumber/26;
        }
        String s = answBuffer.toString();
        return s;
    }


}
