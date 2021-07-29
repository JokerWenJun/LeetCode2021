package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution26 {

    @Test
    public void test()
    {
        int[]nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }



    public int findLength(int []A,int []B){

        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    public int removeDuplicates(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if (j==0)
            {
                nums[i]=nums[j];
                i++;
                continue;
            }
            if (nums[j]!=nums[j-1])
            {
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}
