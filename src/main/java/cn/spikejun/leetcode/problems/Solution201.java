package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution201 {

    @Test
    public void test()
    {
        String s="1111111111111111111111111111111";
        System.out.println(s.length());
    }

    public int rangeBitwiseAnd(int left, int right) {

        int rightShift=0;
        while (left<right)
        {
            left>>=1;
            right>>=1;
            rightShift++;
        }
        return right<<rightShift;
    }

}
