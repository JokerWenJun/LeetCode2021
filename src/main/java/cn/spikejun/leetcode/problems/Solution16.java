package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution16 {

    @Test
    public void test()
    {
        int[]arr=new int[]{0,2,1,-3};
        int i = threeSumClosest(arr, 1);
        System.out.println(i);
    }



    private int min=10000000;
    public int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            //判断是否重复
            if (i!=0&&nums[i]==nums[i-1])
            {
                continue;
            }
            int twoNumberSumTarget = target - nums[i];
            int left=i+1;
            int right=nums.length-1;
            while (left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if (Math.abs(sum-target)<Math.abs(min-target))
                {
                    min=sum;
                }
                if (sum==target)
                {
                    return target;
                }
                else if (sum>target)
                {
                    int originalNum=nums[right];
                    right--;
                    while (right>left&&nums[right]==originalNum)
                    {
                        right--;
                    }
                }
                //当<时
                else
                {
                    int originalNum=nums[left];
                    left++;
                    while (left<right&&nums[left]==originalNum)
                    {
                        left++;
                    }
                }
            }
        }
        return min;
    }

}
