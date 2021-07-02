package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution416 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,3,5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }



    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum%2!=0)
        {
            return false;
        }
        int target=sum/2;
        boolean[][]dp=new boolean[nums.length+1][target+1];
        dp[0][0]=true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if(j<nums[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }

}
