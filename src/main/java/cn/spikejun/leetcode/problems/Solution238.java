package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution238 {


    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,3,4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int[]leftPrefixArray=new int[length];
        int[]rightPrefixArray=new int[length];
        leftPrefixArray[0]=1;
        rightPrefixArray[length-1]=1;
        for (int i = 1; i < length; i++) {
            leftPrefixArray[i]=leftPrefixArray[i-1]*nums[i-1];
        }
        for (int i = length-2; i >= 0; i--) {
            rightPrefixArray[i]=rightPrefixArray[i+1]*nums[i+1];
        }
        int[]answ=new int[length];
        for (int i = 0; i < length; i++) {
            answ[i]=leftPrefixArray[i]*rightPrefixArray[i];
        }
        return answ;
    }
}
