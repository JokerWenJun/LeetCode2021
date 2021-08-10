package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution413 {


    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,3,4};
        int i = numberOfArithmeticSlices(nums);
        System.out.println(i);
    }


    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length<3)
        {
            return 0;
        }
        int[]dp=new int[length];
        dp[0]=0;
        dp[1]=0;
        int sum=0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i]-nums[i-1]==nums[i-1]-nums[i-2])
            {
                dp[i]=dp[i-1]+1;
                sum+=dp[i];
            }
            else
            {
                dp[i]=0;
            }
        }
        return sum;
    }
}
