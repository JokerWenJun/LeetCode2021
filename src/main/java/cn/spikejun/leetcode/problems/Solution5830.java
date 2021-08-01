package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5830 {

    @Test
    public void test()
    {
        boolean three = isThree(9);
        System.out.println(three);
    }


    public boolean isThree(int n) {
        if (n==0||n==1||n==2)
        {
            return false;
        }
        double sqrt = Math.sqrt(n);
        int num=(int)sqrt;
        if (n%num!=0)
        {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
