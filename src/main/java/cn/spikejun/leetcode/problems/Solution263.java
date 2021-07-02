package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution263 {

    @Test
    public void test()
    {

        System.out.println(2/2);
        System.out.println(6%4);
        System.out.println(isUgly(0));
    }


    public boolean isUgly(int n) {
//        if (n==1)
//        {
//            return true;
//        }
        int []nums=new int[]{2,3,5};
        for (int i = 0; i < nums.length; i++) {
            if (n==0)
            {
                break;
            }
            while (n%nums[i]==0)
            {
                n=n/nums[i];
            }
        }
        if (n!=1)
        {
            return false;
        }
        return true;
    }
}
