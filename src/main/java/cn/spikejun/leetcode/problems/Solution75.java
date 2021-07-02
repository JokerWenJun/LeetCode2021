package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution75 {


    @Test
    public void test()
    {
        int[]nums=new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        quicklySort(nums,left,right);
    }

    private void quicklySort(int[] nums, int left, int right) {
        if (left>=right)
        {
            return;
        }
        int flag=nums[left];
        int leftArr=left;
        int rightArr=right;
        while (leftArr<rightArr)
        {
            while (nums[rightArr]>=flag&&leftArr<rightArr)
            {
                rightArr--;
            }
            if (leftArr<rightArr)
            {
                nums[leftArr]=nums[rightArr];
            }
            while (nums[leftArr]<flag&&leftArr<rightArr)
            {
                leftArr++;
            }
            if (leftArr<rightArr)
            {
                nums[rightArr]=nums[leftArr];
            }
        }
        nums[leftArr]=flag;
        //左边分治
        quicklySort(nums,left,leftArr-1);
        //右边分治
        quicklySort(nums,rightArr+1,right);
    }
}
