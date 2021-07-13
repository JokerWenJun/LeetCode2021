package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution29 {

    @Test
    public void test()
    {
        int divide = divide(-2147483648, -2147483648);
        System.out.println(divide);
    }


    public int divide(int dividend, int divisor) {

        int flag=1;
        if (divisor==1||divisor==-1)
        {
            if (divisor==-1)
            {
                if (dividend==Integer.MIN_VALUE)
                {
                    return Integer.MAX_VALUE;
                }
                else
                {
                    return -1*dividend;
                }
            }
            else
            {
                return dividend;
            }
        }
        if (dividend>0&&divisor<0||dividend<0&&divisor>0)
        {
            flag=-1;
        }
        if (dividend<0)
        {
            dividend*=-1;
        }
        if (divisor<0)
        {
            divisor*=-1;
        }
        if (dividend==0)
        {
            return 0;
        }
        long answ = 0;
        long count=1;
        long ldividend=dividend;
        long ldivisor=divisor;
        if (ldividend<0)
        {
            ldividend*=-1;
        }
        if (ldivisor<0)
        {
            ldivisor*=-1;
        }
        long beginDivisor=ldivisor;
        while (ldividend>=ldivisor)
        {
            if (ldivisor+ldivisor<ldividend)
            {
                ldivisor=ldivisor+ldivisor;
                count+=count;
            }
            //>=
            else {
                answ=answ+count;
                ldividend=ldividend-ldivisor;
                ldivisor=beginDivisor;
                count=1;
            }
        }
        if (answ>=Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        return (int) answ*flag;
    }
}
