package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution342_4 {

    @Test
    public void test()
    {
//        System.out.println(5%2);
        System.out.println(isPowerOfFour(4));
    }


    public int maxInt=30;
    public boolean isPowerOfFour(int n) {
        if (n<0)
        {
            return false;
        }
        int rightNumber1ZeroCount=0;
        int Number1Count=0;
        for (int i = maxInt; i >= 0; i--) {
            if ((n>>i&1)==1)
            {
                Number1Count++;
            }
            if (Number1Count>1)
            {
                return false;
            }
            if ((n>>i&1)==0&&Number1Count==1)
            {
                rightNumber1ZeroCount++;
            }
        }
        if (Number1Count==1&&rightNumber1ZeroCount%2==0)
        {
            return true;
        }
        return false;
    }
}
