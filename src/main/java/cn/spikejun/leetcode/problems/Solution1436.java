package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1436 {

    @Test
    public void test()
    {
        String s1="abcde";
        String s2="ace";
        int i = longestCommonSubsequence(s1, s2);
        System.out.println(i);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int length1=text1.length();
        int length2=text2.length();
        int[][]dp=new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++)
        {
            for(int j=1;j<=length2;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else
                {
                    dp[i][j]=Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[length1][length2];
    }
    public String destCity(List<List<String>> paths) {
        Map<String,Integer>outDegree=new HashMap<>();
        for (List<String> path : paths) {
            String original = path.get(0);
            String dest = path.get(1);

            outDegree.put(original,outDegree.getOrDefault(original,0)+1);
            if (!outDegree.containsKey(dest))
            {
                outDegree.put(dest,0);
            }
        }
        Set<String> set = outDegree.keySet();
        String result=null;
        for (String s : set) {
            if (outDegree.get(s)==0)
            {
                result=s;
            }
        }
        return result;
    }
}
