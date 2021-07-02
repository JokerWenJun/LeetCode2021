package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution852 {

    @Test
    public void test()
    {
        int[]arr=new int[]{0,10,5,2};
        int i = peakIndexInMountainArray(arr);
        System.out.println(i);
    }



    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        //[<<<<<<>>>>>>]其实整个数组可以分为小于左边和大于左边两种类型的数字
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (arr[mid]<arr[mid+1])
            {
                left=mid+1;
            }
            else
            //arr[mid]>arr[mid+1]
            {
                right=mid;
            }
        }
        return right;
    }


}
