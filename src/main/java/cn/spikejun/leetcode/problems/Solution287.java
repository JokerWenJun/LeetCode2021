package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution287 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,3,4,2,2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }


    public int findDuplicate(int[] nums) {
        int left=1;
        int right=nums.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            int num=mid;
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]<=num)
                {
                    count++;
                }
            }
            if (count<=num)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }
}
