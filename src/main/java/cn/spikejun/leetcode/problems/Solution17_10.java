package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution17_10 {

    @Test
    public void test()
    {
        int[]nums=new int[]{3,2};
        int i = majorityElement(nums);
        System.out.println(i);
    }


    public int majorityElement(int[] nums) {

        if (nums.length==1)
        {
            return nums[0];
        }

        Arrays.sort(nums);
        int length=nums.length;
        int target=length/2;

        int preNum=nums[0];
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==preNum)
            {
                count++;
                if (count>target)
                {
                    return preNum;
                }
            }
            else
            {
                count=1;
                preNum=nums[i];
            }
        }
        return -1;
    }
}
