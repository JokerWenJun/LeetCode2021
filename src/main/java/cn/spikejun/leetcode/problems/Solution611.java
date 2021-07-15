package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution611 {

    @Test
    public void test()
    {
        int[]nums=new int[]{2,2,3,4};
        int i = triangleNumber(nums);
        System.out.println(i);
    }



    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int answ=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int max=nums[j]+nums[i];
                //从i到length-1之间找到第一个大于等于max的小标
                Integer index=searchIndex(i+1,nums.length-1,nums,max);
                if (index!=null)
                {
                    answ+=(index-i);
                }
            }
        }
        return answ;
    }

    private Integer searchIndex(int left, int right, int[] nums, int max) {
        if (left>right)
        {
            return null;
        }
        //判断边界
        if (nums[left]>=max)
        {
            return null;
        }
        if (nums[right]<max)
        {
            return right;
        }
        while (left<right)
        {
            int mid=left+(right-left)/2+1;
            if (nums[mid]>=max)
            {
                right=mid-1;
            }
            else
            {
                left=mid;
            }
        }
        return left;
    }
}
