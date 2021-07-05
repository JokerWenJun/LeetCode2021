package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution31 {


    @Test
    public void test()
    {
//        int[]arr=new int[]{21,1124,124,332,1,2,52,12};
//        Arrays.sort(arr,6,8);
//        System.out.println(Arrays.toString(arr));
        int[]nums=new int[]{1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int changePosition=-1;
        int changeNumber=0;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i]<=nums[i-1])
            {
                continue;
            }
            else
            {
                changePosition=i-1;
                changeNumber=nums[i-1];
                break;
            }
        }
        if (changePosition==-1)
        {
            Arrays.sort(nums);
            return;
        }
        int minPosition=changePosition+1;
        int minNumber=nums[minPosition];
        for (int i = changePosition+1; i < nums.length; i++) {
            if (nums[i]<=changeNumber)
            {
                continue;
            }
            else {
                if (nums[i]<=minNumber)
                {
                    minNumber=nums[i];
                    minPosition=i;
                }
            }
        }
        //进行更换
        nums[changePosition]=minNumber;
        nums[minPosition]=changeNumber;
        //排序
        Arrays.sort(nums,changePosition+1,nums.length);
    }
}
