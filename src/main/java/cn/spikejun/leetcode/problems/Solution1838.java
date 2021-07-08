package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1838 {

    @Test
    public void test()
    {
        int[]nums=new int[]{3,9,6};
        int i = maxFrequency(nums, 2);
        System.out.println(i);
    }


    public int maxFrequency(int[] nums, int k) {
        //先排序
        Arrays.sort(nums);
        int cost=0;
        int right=1;
        int left=0;
        int maxLength=1;

        while (right<nums.length)
        {
            int number=nums[right]-nums[right-1];
            cost+=number*(right-left);
            while (cost>k)
            {
                int addNumber=nums[right]-nums[left];
                cost-=addNumber;
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}
