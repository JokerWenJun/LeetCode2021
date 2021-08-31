package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution96 {

    @Test
    public void test()
    {
        int i = numTrees(3);
        System.out.println(i);
    }


    public int numTrees(int n) {
        int methodWays = getMethodWays(1,n);
        return methodWays;
    }

    public int getMethodWays(int left,int rihgt)
    {
        if (left>=rihgt)
        {
            return 1;
        }
        int answ=0;
        for (int i = left; i <=rihgt; i++) {
            answ=answ+getMethodWays(left,i-1)*getMethodWays(i+1,rihgt);
        }
        return answ;
    }
}
