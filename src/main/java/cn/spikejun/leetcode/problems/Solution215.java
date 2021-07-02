package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution215 {

    public int findKthLargest(int[] nums, int k) {



        return 1;
    }

    @Test
    public void test()
    {
        int[]nums=new int[]{3,1,2,3,5,7,6,5,9,12,1};

        quicklySwift(nums,0,nums.length-1);
        System.out.println("!!!");
    }


    public void quicklySwift(int[]nums,int begin,int end)
    {
        if (begin>=end)
        {
            return;
        }
        int left=begin;
        int right=end;
        int temp=nums[begin];
        while (left<right)
        {
            while (nums[right]>temp&&right>left)
            {
                right--;
            }
            nums[left]=nums[right];
            while (nums[left]<=temp&&right>left)
            {
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        quicklySwift(nums,begin,left-1);
        quicklySwift(nums,right+1,end);
    }

}
