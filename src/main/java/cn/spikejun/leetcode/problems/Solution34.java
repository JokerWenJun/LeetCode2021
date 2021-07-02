package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution34 {


    @Test
    public void test()
    {
        int[]nums=new int[]{5,7,7,8,8,10};
        int[] ints = searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }



    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0)
        {
            return new int[]{-1,-1};
        }

        int leftIndex=0;
        int rightIndex=nums.length-1;
        int midBegin=0;
        while (leftIndex<=rightIndex)
        {
            int mid=leftIndex+(rightIndex-leftIndex)/2;
            if (nums[mid]==target)
            {
                midBegin=mid;
                break;
            }
            else if (nums[mid]>target)
            {
                rightIndex=mid-1;
            }
            else if (nums[mid]<target)
            {
                leftIndex=mid+1;
            }
        }
        if (leftIndex>rightIndex)
        {
            return new int[]{-1,-1};
        }
        int []answ=new int[2];
        //找到中间的target点；midBegin
        int left=0;
        int right=midBegin;
        //左半区搜查；
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (nums[mid]!=target)
            {
                left=left+1;
            }
            else
            {
                right=mid;
            }
        }
        answ[0]=left;
        //右半区搜查；
        left=midBegin;
        right=nums.length-1;
        if (nums[right]==target)
        {
            answ[1]=right;
            return answ;
        }
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (nums[mid]!=target)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        answ[1]=left-1;
        return answ;
    }
}
