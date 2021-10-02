package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class SolutionOffer46 {


    @Test
    public void test()
    {
        int i = translateNum(506);
        System.out.println(i);
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int[]dp=new int[chars.length+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            if (chars[i-2]<='2')
            {
                if (chars[i-2]=='1')
                {
                    dp[i]+=dp[i-2];
                }
                else if (chars[i-2]=='2')
                {
                    if (chars[i-1]<='5')
                    {
                        dp[i]+=dp[i-2];
                    }
                }
            }
            dp[i]+=dp[i-1];
        }
        return dp[chars.length];
    }
}
