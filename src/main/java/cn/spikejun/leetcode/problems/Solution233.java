package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution233 {

    @Test
    public void test()
    {
        int i = countDigitOne(0);
        System.out.println(i);
    }


    public int countDigitOne(int n) {
        if (n==0)
        {
            return 0;
        }



        //将其转化为字符串
        String s=n+"";
        //统计每一位上1出现的次数，将其相加就得到结果
        int answ=0;
        int length = s.length();
        for (int i = length-1; i >= 0; i--) {
            //当前位
            char c = s.charAt(i);
            //判断当前位是==0/==1/>1
            if (c=='0')
            {
                int pre=new Integer(s.substring(0,i));
                int suff= (int) Math.pow(10,length-1-i);
                answ+=pre*suff;
            }
            if (c=='1')
            {
                if (i!=0)
                {
                    int pre=new Integer(s.substring(0,i));
                    int suff= (int) Math.pow(10,length-1-i);
                    answ+=pre*suff;
                }
                if (i<length-1)
                {
                    Integer suffer=new Integer(s.substring(i+1));
                    answ+=suffer+1;
                }
                if (i==length-1)
                {
                    answ+=1;
                }
            }
            if (c>'1')
            {
                if (i!=0)
                {
                    int pre=new Integer(s.substring(0,i));
                    int suff= (int) Math.pow(10,length-1-i);
                    answ+=pre*suff;
                }
//                if (i<length-1)
//                {
                    int suffer= (int) Math.pow(10,length-1-i);
                    answ+=suffer;
//                }
            }
        }
        return answ;
    }
}
