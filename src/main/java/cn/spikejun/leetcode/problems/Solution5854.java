package cn.spikejun.leetcode.problems;

import java.util.Arrays;

public class Solution5854 {

    public int minimumDifference(int[] nums, int k) {
        if (k==1)
        {
            return 0;
        }
        Arrays.sort(nums);
        if (k>=nums.length)
        {
            return nums[nums.length-1]-nums[0];
        }
        int min=Integer.MAX_VALUE;
        for (int i = k-1; i < nums.length; i++) {
            min=Math.min(min,nums[i]-nums[i-k+1]);
        }
        return min;
    }

}
