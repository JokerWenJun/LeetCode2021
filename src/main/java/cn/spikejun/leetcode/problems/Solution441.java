package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution441 {

    @Test
    public void test()
    {
        System.out.println(1&2&3&4);
    }

    public int arrangeCoins(int n) {
        if (n==0){
            return 0;
        }
        int answ=0;
        long sum=0;
        while (sum<n)
        {
            sum+=answ;
            answ++;
        }
        if (sum==n)
        {
            return answ-1;
        }
        else
        {
            return answ-2;
        }
    }
}
