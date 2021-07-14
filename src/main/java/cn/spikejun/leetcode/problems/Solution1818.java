package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1818 {

    @Test
    public void test(){
        int[]nums1=new int[]{1,10,4,4,2,7};
        int[]nums2=new int[]{9,3,5,1,7,4};
        int i = minAbsoluteSumDiff(nums1, nums2);
        System.out.println(i);
    }



    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod= (int) (Math.pow(10,9)+7);
        long originalSum=0;
        int length=nums1.length;
        for (int i = 0; i < length; i++) {
            originalSum+=Math.abs(nums1[i]-nums2[i]);
        }
        int[]copySum1= Arrays.copyOf(nums1,length);
        //排序
        Arrays.sort(copySum1);
        long min=originalSum;
        for (int i = 0; i < length; i++) {
            int originalInterval=Math.abs(nums1[i]-nums2[i]);
            //在copyNum1中找到离num2[i]最接近的值
            int num=findTheClosesoftNumber2(copySum1,nums2[i]);
            int newInterval=Math.abs(num-nums2[i]);
            if (newInterval<originalInterval)
            {
                min=Math.min(min,originalSum-(originalInterval-newInterval));
            }
        }
        return (int) (min%mod);
    }

    private int findTheClosesoftNumber2(int[] copySum1, int i) {
        //判断边界
        if(i<copySum1[0])
        {
           return copySum1[0];
        }
        if (i>copySum1[copySum1.length-1])
        {
            return copySum1[copySum1.length-1];
        }
        int left=0;
        int right=copySum1.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (copySum1[mid]<=i)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        //此时left和right对应的数组中的元素是最小的大于i的值,left和right的左边为小于等于i的值
        if (Math.abs(copySum1[left]-i)>=Math.abs(copySum1[left-1]-i))
        {
            return copySum1[left-1];
        }
        else
        {
            return copySum1[left];
        }
    }
}
