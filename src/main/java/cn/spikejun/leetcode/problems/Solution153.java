package cn.spikejun.leetcode.problems;

public class Solution153 {

    public int findMin(int[] nums) {
        int flag=nums[0];
        if (flag<=nums[nums.length-1])
        {
            return flag;
        }
        int left=0;
        int right=nums.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (nums[mid]>=flag)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return nums[left];
    }
}
