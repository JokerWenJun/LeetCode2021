package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution209 {

    @Test
    public void test()
    {
        int[]nums=new int[]{2,3,1,2,4,3};
        int i = minSubArrayLen(7, nums);
        System.out.println(i);
    }


    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int count=0;
        int left=0;
        int right=0;
        count=0;
        while (right<nums.length)
        {
            count+=nums[right];
            while (count>=target)
            {
                min=Math.min(min,right-left+1);
                count-=nums[left];
                left++;
            }
            right++;
        }
        if (min==Integer.MAX_VALUE)
        {
            return 0;
        }
        return min;
    }
}
