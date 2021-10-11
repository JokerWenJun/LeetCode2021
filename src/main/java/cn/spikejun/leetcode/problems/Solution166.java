package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    @Test
    public void test()
    {
        String s = fractionToDecimal(-2147483648
                , -1);
        System.out.println(s);
    }

    public String fractionToDecimal(int numerator, int denominator) {

        StringBuffer buffer=new StringBuffer();
        boolean isNegative=true;
        if ((numerator<0&&denominator<0)||(numerator>0&&denominator>0))
        {
            isNegative=false;
        }
        if (isNegative)
        {
            buffer.append('-');
        }
        long numLong=numerator;
        long denomLong=denominator;

        if (numLong%denomLong==0)
        {
            return String.valueOf(numLong/denomLong);
        }


        numLong=Math.abs(numLong);
        denomLong=Math.abs(denomLong);
        long integerPart=numLong/denomLong;
        long modPart=numLong%denomLong;
        Map<Long,Integer>map=new HashMap<>();

        buffer.append(integerPart);
        buffer.append(".");
        int index=0;
        StringBuffer frictionBuffer=new StringBuffer();
        while (modPart!=0&&!map.containsKey(modPart))
        {
            map.put(modPart,index);
            modPart=modPart*10;
            frictionBuffer.append(modPart/denomLong);
            modPart=modPart%denomLong;
            index++;
        }
        if (modPart!=0)
        {
            Integer firstPosition = map.get(modPart);
            frictionBuffer.insert(firstPosition,"(");
            frictionBuffer.append(")");
        }
        return buffer.append(frictionBuffer.toString()).toString();
    }
}
