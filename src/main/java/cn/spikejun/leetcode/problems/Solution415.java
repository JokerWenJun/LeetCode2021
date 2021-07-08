package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution415 {


    @Test
    public void test()
    {
        String s1="123";
        String s2="999";
        String s = addStrings(s1, s2);
        System.out.println(s);
    }


    public String addStrings(String num1, String num2) {
        int count=0;
        int length1 = num1.length()-1;
        int length2 = num2.length()-1;
        String answ;
        StringBuffer answBuff=new StringBuffer();
        while (length1>=0||length2>=0)
        {
            int number1;
            int number2;
            if (length1<0)
            {
                number1=0;
            }
            else
            {
               number1=num1.charAt(length1)-'0';
            }
            if(length2<0)
            {
                number2=0;
            }
            else
            {
                number2=num2.charAt(length2)-'0';
            }
            int currentNumber;
            if (number1+number2+count>=10)
            {
                currentNumber=number1+number2+count-10;
                count=1;
            }
            else
            {
                currentNumber=number1+number2+count;
                count=0;
            }
            answBuff.append(currentNumber+"");
            length1--;
            length2--;
        }
        if (count==1)
        {
            answBuff.append("1");
        }
        answ=answBuff.reverse().toString();
        return answ;
    }
}
