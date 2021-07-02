package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution231_2 {

    @Test
    public void test()
    {
//        String s="1111111111111111111111111111111";
//        System.out.println(s.length());
        System.out.println(Math.pow(2,20));
        int n=31;
        boolean powerOfTwo = isPowerOfTwo(n);
        System.out.println(powerOfTwo);
    }

    public int maxInt=30;

    public boolean isPowerOfTwo(int n) {
        if (n<0)
        {
            return false;
        }
        boolean answ=false;
        int count=0;
        for (int i = maxInt; i >= 0; i--) {
            int singleBit=n>>i&1;
            if (singleBit==1)
            {
                count++;
            }
        }
        if (count==1)
        {
            return true;
        }
        return false;
    }


}
