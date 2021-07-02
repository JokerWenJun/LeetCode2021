package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1143 {

    @Test
    public void test()
    {
        char a='1';
        char b='1';
        String text1="abcde";
        String text2="ace";
        int i = longestCommonSubsequence(text1, text2);
        System.out.println(i);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        int text1ArraySize=text1Array.length;
        int text2ArraySize=text2Array.length;
        int [][]dp=new int[text1ArraySize+1][text2ArraySize+1];
        for (int i = 1; i <= text1ArraySize; i++) {
            for (int j = 1; j <= text2ArraySize; j++) {
                if (text1Array[i-1]==text2Array[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j]=max;
                }
            }
        }
        return dp[text1ArraySize][text2ArraySize];
    }

}
