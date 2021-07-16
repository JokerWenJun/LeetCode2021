package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class SolutionOffer53 {

    @Test
    public void test()
    {
        int[]nums=new int[]{5,7,7,8,8,10};
        int search = search(nums, 6);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if (nums.length==0)
        {
            return 0;
        }


        //判断边界
        if (nums[0]>target)
        {
            return 0;
        }
        if (nums[nums.length-1]<target)
        {
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (nums[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        //此时left和right指向的是左边界
        int leftIndex=left;
        if (nums[leftIndex]!=target)
        {
            return 0;
        }
        left=0;
        right=nums.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2+1;
            if (nums[mid]<=target)
            {
                left=mid;
            }
            else
            {
                right=mid-1;
            }
        }
        int rightIndex=left;
        int length=rightIndex-leftIndex+1;

        return length;
    }
}
