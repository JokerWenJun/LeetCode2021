package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution583 {


    @Test
    public void test()
    {
        String word1="set";
        String word2="eat";
        int i = minDistance(word1, word2);
        System.out.println(i);
    }

    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2= word2.toCharArray();
        int[][]dp=new int[chars1.length+1][chars2.length+1];
        int length1 = chars1.length;
        int length2 = chars2.length;
        for (int i = 0; i <=length1; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=length2; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=length1; i++) {
            for (int j = 1; j <=length2; j++) {
                if (chars1[i-1]==chars2[j-1])
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i-1][j-1]+2,dp[i][j-1]+1));
                }
            }
        }
        return dp[length1][length2];
    }
}
