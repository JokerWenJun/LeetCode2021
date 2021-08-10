package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution926 {

    @Test
    public void test()
    {
        String s="00011000";
        int i = minFlipsMonoIncr(s);
        System.out.println(i);
    }

    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int cout=0;
        int[]num1Count=new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1')
            {
                cout++;
            }
            num1Count[i]=cout;
        }
        //如果count==0，代表不需要翻转
        if (cout==0)
        {
            return 0;
        }
        int answ=cout;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1')
            {
                int currentCount=0;
                //前面的转变
                currentCount=currentCount+num1Count[i]-1;
                currentCount+=chars.length-1-i-(num1Count[num1Count.length-1]-num1Count[i]);
                answ=Math.min(answ,currentCount);
            }
        }
        return answ;
    }
}
