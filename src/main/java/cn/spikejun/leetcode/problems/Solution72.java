package cn.spikejun.leetcode.problems;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int[][]dp=new int[word1Array.length+1][word2Array.length+1];
        //初始化
        for (int i = 1; i <=word2Array.length; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=word1Array.length; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <=word1Array.length; i++) {
            for (int j = 1; j <=word2Array.length; j++) {
                if (word1Array[i-1]==word2Array[j-1])
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[word1Array.length][word2Array.length];
    }
}
