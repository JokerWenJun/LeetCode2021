package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution7 {
    @Test
    public void test()
    {
        System.out.println(reverse(-123));
    }

    public int reverse(int x) {

        long answ=0;
        int copy=x;
        while (copy!=0)
        {
            answ=answ*10+copy%10;
            copy=copy/10;
        }
        if (answ>Integer.MAX_VALUE||answ<Integer.MIN_VALUE)
        {
            return 0;
        }
        return (int)answ;
    }
}
