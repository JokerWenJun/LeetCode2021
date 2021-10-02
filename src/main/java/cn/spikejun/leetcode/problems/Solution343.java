package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Scanner;

public class Solution343 {

    @Test
    public void test()
    {
        int n=4;
        int lastRow=2*n-1;
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < (n-i); j++) {
                System.out.print(" ");
            }
            int currentRow=i;
            for (int j = 0; j < (2*i-1); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < (n-i); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }




    public int integerBreak(int n) {
        int[]dp=new int[n+1];
        for (int i = 2; i <=n; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                max=Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
