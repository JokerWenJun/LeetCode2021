package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution516 {

    @Test
    public void test()
    {
        String s="cbbd";
        int i = longestPalindromeSubseq(s);
        System.out.println(i);
    }


    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][]dp=new int[chars.length][chars.length];
        int length = s.length();
        for (int i = length-1; i >=0; i--) {
            for (int j = i; j < length; j++) {
                if (j==i)
                {
                    dp[i][j]=1;
                }
                else {
                    if (chars[i]==chars[j])
                    {
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                    else
                    {
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][length-1];
    }
}
