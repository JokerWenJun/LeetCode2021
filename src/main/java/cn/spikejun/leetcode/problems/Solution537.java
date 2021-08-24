package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution537 {

    @Test
    public void test()
    {
        String num1="1+-1i";
        String num2="1+-1i";
        String s = complexNumberMultiply(num1, num2);
        System.out.println(s);
    }


    public String complexNumberMultiply(String num1, String num2) {
        String[] num1Array = num1.split("\\+");
        String[] num2Array = num2.split("\\+");
        int entity=0;
        int imaginePart=0;
        String num1EntityPart = num1Array[0];
        String num1ImaginePart=num1Array[1].substring(0,num1Array[1].length()-1);
        String num2EntityPart = num2Array[0];
        String num2ImaginePart=num2Array[1].substring(0,num2Array[1].length()-1);
        //calculate the first step
        entity=entity+Integer.valueOf(num1EntityPart)*Integer.valueOf(num2EntityPart);
        imaginePart=imaginePart+Integer.valueOf(num1EntityPart)*Integer.valueOf(num2ImaginePart);
        //calculate the second step
        imaginePart=imaginePart+Integer.valueOf(num1ImaginePart)*Integer.valueOf(num2EntityPart);
        entity=entity+Integer.valueOf(num1ImaginePart)*Integer.valueOf(num2ImaginePart)*-1;
        StringBuffer buffer=new StringBuffer();
        if (entity==0)
        {
            buffer.append("0");
        }
        else
        {
            buffer.append(entity+"");
        }
        buffer.append("+");
        if (imaginePart==0)
        {
            buffer.append("0");
        }
        else
        {
            buffer.append(imaginePart+"");
        }
        buffer.append("i");
        return buffer.toString();
    }



}
