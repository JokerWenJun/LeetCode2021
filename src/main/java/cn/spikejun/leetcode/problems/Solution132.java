package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class Solution132 {

    @Test
    public void test()
    {
        String s="b";
        int i = minCut(s);
        System.out.println(i);
    }


    public int minCut(String s) {
        int length = s.length();
        boolean[][]dp=new boolean[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i],true);
        }
        for (int i = length-1; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                dp[i][j]=s.charAt(i)==s.charAt(j)&&dp[i+1][j-1];
            }
        }
        int[]answ=new int[length];
        Arrays.fill(answ,Integer.MAX_VALUE);
        answ[0]=0;
        for (int i = 0; i <length; i++) {
            //首先判断从0->i是否是回文
            if (dp[0][i])
            {
                answ[i]=0;
            }
            else {
                answ[i]=i;
                for (int j = 1; j <=i; j++) {
                    if (dp[j][i])
                    {
                        answ[i]=Math.min(answ[i],answ[j-1]+1);
                    }
                }
            }
        }
        return answ[answ.length-1];
    }
}
