package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1429 {


    @Test
    public void test()
    {
        int n=7;
        int k=2;
        int i = kthFactor(n, k);
        System.out.println(i);
    }

    public int kthFactor(int n, int k) {
        int factor=1;
        for (;factor*factor<=n;factor++)
        {
            if (n%factor==0)
            {
                k--;
            }
            if (k==0)
            {
                return factor;
            }
        }
        factor--;
        if (factor*factor==n)
        {
            factor--;
        }
        for (;factor>=1;factor--)
        {
            if (n%factor==0)
            {
                k--;
            }
            if (k==0)
            {
                return n/factor;
            }
        }
        return -1;
    }
}
