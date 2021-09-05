package cn.spikejun.leetcode.problems;

public class Solution97 {


    public boolean isInterleave(String s1, String s2, String s3) {



        char[] str1Array = s1.toCharArray();
        char[] str2Array = s2.toCharArray();
        char[] str3Array = s3.toCharArray();
        if (str1Array.length+str2Array.length!=str3Array.length)
        {
            return false;
        }


        boolean[][]dp=new boolean[str1Array.length+1][str2Array.length+1];
        dp[0][0]=true;
        for (int i = 0; i <=str1Array.length; i++) {
            for (int j = 0; j <=str2Array.length; j++) {
                int s3CurrentLocation=i+j-1;
                if (i>0)
                {
                    dp[i][j]=dp[i][j]||(str1Array[i-1]==str3Array[s3CurrentLocation]&&dp[i-1][j]);
                }
                if (j>0)
                {
                    dp[i][j]=dp[i][j]||(str2Array[j-1]==str3Array[s3CurrentLocation]&&dp[i][j-1]);
                }
            }
        }
        return dp[str1Array.length][str2Array.length];
    }

}
