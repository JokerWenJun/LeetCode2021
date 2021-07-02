package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution162 {

    @Test
    public void test()
    {
        int[]nums=new int[]{5,4,3,2,1};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }

    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[mid+1])
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }
}
