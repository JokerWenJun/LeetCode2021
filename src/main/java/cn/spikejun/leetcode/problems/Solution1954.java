package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1954 {

    @Test
    public void test()
    {

//        long l = minimumPerimeter(100000000000000);
//        System.out.println(l);
    }

    public long minimumPerimeter(long neededApples) {
        long left=0;
        long right= (long) (Math.sqrt(neededApples/12.0)+1);
        while (left<right)
        {
            long mid=left+(right-left)/2;
            long value=2*mid*(mid+1)*(2*mid+1);
            if (value<neededApples)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left*8;
    }
}
