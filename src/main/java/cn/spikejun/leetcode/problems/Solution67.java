package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution67 {

    @Test
    public void test()
    {
        String  a="11";
        String b="1";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    //100111000100000
    public String addBinary(String a, String b) {
        a=new StringBuffer(a).reverse().toString();
        b=new StringBuffer(b).reverse().toString();
        char[] charArryA = a.toCharArray();
        char[] charArryB = b.toCharArray();
        StringBuffer answBuffer=new StringBuffer();
        int flag=0;
        int arrawA=0;
        int arrawB=0;
        while (arrawA<a.length()||arrawB<b.length())
        {
            char valueA;
            char valueB;
            if (arrawB>=b.length())
            {
                valueB='0';
            }
            else
            {
                valueB=charArryB[arrawB];
            }
            if (arrawA>=a.length())
            {
                valueA='0';
            }
            else
            {
                valueA=charArryA[arrawA];
            }
            int value=valueA-'0'+valueB-'0'+flag;
            if (value==0)
            {
                answBuffer.append("0");
                flag=0;
            }
            if (value==1)
            {
                answBuffer.append("1");
                flag=0;
            }
            if (value==2)
            {
                answBuffer.append("0");
                flag=1;
            }
            if (value==3)
            {
                answBuffer.append("1");
                flag=1;
            }
            arrawA++;
            arrawB++;
        }
        if (flag==1)
        {
            answBuffer.append("1");
        }
        return answBuffer.reverse().toString();
    }



}
