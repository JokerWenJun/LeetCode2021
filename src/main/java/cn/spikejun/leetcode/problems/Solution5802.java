package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5802 {

    @Test
    public void test()
    {
        int i = countGoodNumbers(806166225460393l);
        System.out.println(i);
    }

    public int mod= (int) (Math.pow(10,9)+7);
    public int countGoodNumbers(long n) {
        long oddNumberCount=n/2;
        long evenNumberCount=n/2;
        if (n%2!=0)
        {
            evenNumberCount++;
        }
        //答案=5^evenNumber*4^oddNumber;
        long part1= myPow(5, evenNumberCount)%mod;
        long part2=myPow(4, oddNumberCount)%mod;
        int answ= (int) ((part1*part2)%mod);
        return answ;
    }

    private long myPow(int x,long N)
    {

        if (N==0)
        {
            return 1l;
        }
        long pow = myPow(x, N / 2);
        if (N%2==0)
        {
            return (pow*pow)%mod;
        }
        else
        {
            return (pow*pow*x)%mod;
        }

    }


}
