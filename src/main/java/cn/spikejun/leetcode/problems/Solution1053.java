package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1053 {

    @Test
    public void test()
    {
        int arr[]={1,9,4,6,7};
        int[] ints = prevPermOpt1(arr);
        System.out.println(Arrays.toString(ints));
    }


    public int[] prevPermOpt1(int[] arr) {
        int begin=-1;
        for (int i = arr.length-1; i >0; i--) {
            if (arr[i]<arr[i-1])
            {
                begin=i-1;
                break;
            }
        }
        if (begin==-1)
        {
            return arr;
        }
        int currentNum=arr[begin];
        int min=Integer.MIN_VALUE;
        int position=begin;
        for (int i = begin; i < arr.length; i++) {
            if (arr[i]<currentNum)
            {
                if (min<arr[i])
                {
                    min=arr[i];
                    position=i;
                }
            }
        }
        arr[begin]=min;
        arr[position]=currentNum;
        return arr;
    }


}
