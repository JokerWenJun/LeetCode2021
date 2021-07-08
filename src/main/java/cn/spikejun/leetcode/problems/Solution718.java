package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution718 {

    @Test
    public void test()
    {
        int[]nums1=new int[]{1,2,3,2,1};
        int[]nums2=new int[]{3,2,1,4,7};
        int length = findLength(nums1, nums2);
        System.out.println(length);
    }


    public int findLength(int[] nums1, int[] nums2) {
        int ALength=nums1.length;
        int BLength=nums2.length;
        int[][]dp=new int[ALength+1][BLength+1];
        int max=0;
        for (int i = ALength-1; i >=0; i--) {
            for (int j = BLength-1; j >=0; j--) {
                if (nums1[i]==nums2[j])
                {
                    dp[i][j]=dp[i+1][j+1]+1;
                }
                else
                {
                    dp[i][j]=0;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
