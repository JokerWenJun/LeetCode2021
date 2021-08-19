package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution45 {

    @Test
    public void test()
    {
        int[]arr=new int[]{2,3,0,1,4};
        int jump = jump(arr);
        System.out.println(jump);
    }
    

    public int jump(int[] nums) {
        int[]dp=new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]!=Integer.MAX_VALUE&&i-j<=nums[j])
                {
                    dp[i]=Math.min(dp[i],1+dp[j]);
                }
            }
        }
        return dp[nums.length-1];
    }
}
