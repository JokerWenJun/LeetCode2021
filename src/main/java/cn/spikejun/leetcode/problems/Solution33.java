package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution33 {


    @Test
    public void test()
    {
        int[]nums=new int[]{1};
        int search = search(nums, 0);
        System.out.println(search);
    }


    public int search(int[] nums, int target) {
        int flagNumber=nums[0];
        //找到数组种的螺旋点
        int left=0;
        int right=nums.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2+1;
            if (nums[mid]>=flagNumber)
            {
                left=mid;
            }
            else {
                right=mid-1;
            }
        }
        //此时left/right点就是原数组最后一个点
        //判断边界
        int max=nums[left];
        if (target>max)
        {
            return -1;
        }
        if (left+1>=nums.length)
        {
            if (target<nums[0])
            {
                return -1;
            }
        }
        int answ=-1;
        //进行二分
        if (target>=flagNumber)
        {
            answ=binarySearch(0,left,target,nums);
        }
        else
        {
            answ=binarySearch(left+1,nums.length-1,target,nums);
        }
        return answ;
    }

    private int binarySearch(int left, int right, int target,int[]nums) {
        while (left<=right)
        {
            int mid=(left+right)/2;
            if (nums[mid]==target)
            {
                return mid;
            }
            else if (nums[mid]>target)
            {
                right=right-1;
            }
            else {
                left=left+1;
            }
        }
        return -1;
    }
}
