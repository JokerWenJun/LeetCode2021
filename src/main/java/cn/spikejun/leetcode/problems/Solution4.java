package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution4 {

    @Test
    public void test()
    {
        int[]a=new int[]{1,3,4,9};
        int[]b=new int[]{1,2,3,4,5,6,7,8,9};
        double medianSortedArrays = findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1=nums1.length;
        int length2=nums2.length;
        //算出总的长度
        int totalLength=length1+length2;
        //判断是奇数还是偶数
        if (totalLength%2==0)
        {
            //第k1小的元素
            int k1=totalLength/2;
            //第k2小的元素
            int k2=k1+1;
            //偶数的中位数等于这两个值求出来的数值的平均值
            int number1=getNoKNumber(nums1,nums2,k1);
            int number2=getNoKNumber(nums1,nums2,k2);
            double answ=(number1+number2)/2.0;
            return answ;
        }
        //奇数
        else
        {
            int k=totalLength/2+1;
            int number=getNoKNumber(nums1,nums2,k);
            return number;
        }
    }
    //得到第K小的元素
    private int getNoKNumber(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1=0;
        int index2=0;
        while (true)
        {
            //判断边界也是终止条件
            if (index1==length1)
            {
                return nums2[index2+k-1];
            }
            if (index2==length2)
            {
                return nums1[index1+k-1];
            }
            if (k==1)
            {
                return Math.min(nums1[index1],nums2[index2]);
            }
            //进行正常判断
            int half=k/2;
            int newIndex1=Math.min(length1-1,index1+half-1);
            int newIndex2=Math.min(length2-1,index2+half-1);
            int number1=nums1[newIndex1];
            int number2=nums2[newIndex2];
            if (number1>=number2)
            {
                k-=(newIndex2-index2+1);
                index2=newIndex2+1;
            }
            else
            {
                k-=(newIndex1-index1+1);
                index1=newIndex1+1;
            }
        }
    }
}
