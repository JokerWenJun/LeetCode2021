package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1004 {

    @Test
    public void test()
    {
        int[]A=new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int i = longestOnes(A, 3);
        System.out.println(i);

    }


    public int longestOnes(int[] nums, int k) {
        int maxcount=0;
        int left=0;
        int right=0;
        int number1Count=0;
        while (right<nums.length)
        {
            if (nums[right]==1)
            {
                number1Count++;
                maxcount=Math.max(number1Count,maxcount);
            }
            if (right-left+1-maxcount>k)
            {
                if (nums[left]==1)
                {
                    number1Count--;
                }
                left++;
            }
            right++;
        }
        return right-left;
    }
}
