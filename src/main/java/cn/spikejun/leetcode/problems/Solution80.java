package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution80 {

    @Test
    public void test()
    {
        int[]arr=new int[]{0,0,0,5,4,4,4,2,1,1,1,1,2,3,3};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        int preNum=10001;
        int count=0;
        while (j<nums.length)
        {
            if (nums[j]==preNum)
            {
                count++;
                if (count<=1)
                {
                    nums[i]=nums[j];
                    i++;
                }
            }
            else
            {
                count=0;
                preNum=nums[j];
                nums[i]=nums[j];
                i++;
            }
            j++;
        }
        return i;
    }


}
