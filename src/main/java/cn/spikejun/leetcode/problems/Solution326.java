package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution326 {


    @Test
    public void test()
    {
        boolean powerOfThree = isPowerOfThree(45);
        System.out.println(powerOfThree);
    }

    public boolean isPowerOfThree(int n) {

        if (n==0||n<0)
        {
            return false;
        }
        while (n!=1)
        {
            if (n%3!=0)
            {
                return false;
            }
            n=n/3;
        }

        return true;
    }
}
