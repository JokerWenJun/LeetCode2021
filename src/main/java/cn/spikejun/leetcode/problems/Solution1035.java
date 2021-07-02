package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1035 {

    @Test
    public void test()
    {
        int[]num1=new int[]{2,5,1,2,5};
        int[]num2=new int[]{10,5,2,1,5,2};
        int i = maxUncrossedLines(num1, num2);
        System.out.println(i);
    }


    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int num1Size=nums1.length;
        int num2Size=nums2.length;
        int[][]dp=new int[num1Size+1][num2Size+1];
        for (int i = 1; i <= num1Size; i++) {
            for (int j = 1; j <= num2Size; j++) {
                if (nums1[i-1]==nums2[j-1])
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

        int answ=dp[num1Size][num2Size];
        return answ;
    }
}
