package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution43 {

    @Test
    public void test()
    {
        String s1="123";
        String s2="456";
        String multiply = multiply(s1, s2);
        System.out.println(multiply);
    }




    public String multiply(String num1, String num2) {
        int num1Length = num1.length();
        int num2Length = num2.length();
        if (num1.equals("0")||num2.equals("0"))
        {
            return "0";
        }

        int[]buffer=new int[num1Length+num2Length];
        Arrays.fill(buffer,0);
        num1=new StringBuffer(num1).reverse().toString();
        num2=new StringBuffer(num2).reverse().toString();
        char[] nums1StrArray = num1.toCharArray();
        char[] nums2StrArray = num2.toCharArray();
        for (int i = 0; i < nums1StrArray.length; i++) {
            int count1=nums1StrArray[i]-'0';
            for (int j = 0; j < nums2StrArray.length; j++) {
                int count2=nums2StrArray[j]-'0';
                buffer[i+j]+=count1*count2;
            }
        }
        int flag=0;
        for (int i = 0; i < buffer.length; i++) {
            int num = buffer[i] + flag;
            int count = num / 10;
            int leave=num%10;
            buffer[i]=leave;
            flag=count;
        }
        boolean isFirstZero=true;
        StringBuffer stringBuffer=new StringBuffer();

        for (int i = buffer.length-1; i>=0; i--) {
            if (buffer[i]==0&&isFirstZero)
            {
                continue;
            }
            else
            {
                if (buffer[i]!=0)
                {
                    stringBuffer.append(buffer[i]);
                    isFirstZero=false;
                }
                else
                {
                    stringBuffer.append(buffer[i]);
                }
            }
        }
        return stringBuffer.toString();
    }
}
