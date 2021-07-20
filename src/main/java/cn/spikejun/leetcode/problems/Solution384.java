package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Solution384 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,3};

        Solution384 solution384=new Solution384(nums);
        int[] shuffle = solution384.shuffle();
        System.out.println(Arrays.toString(shuffle));
        int[] reset = solution384.reset();
        System.out.println(Arrays.toString(reset));
        shuffle = solution384.shuffle();
        System.out.println(Arrays.toString(shuffle));
    }


    private int[]originalArray;
    private int[]currentArray;
    private Random random=new Random();
    public Solution384(int[] nums) {
        originalArray=nums;
        currentArray=originalArray.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        currentArray=originalArray.clone();
        return currentArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int length = currentArray.length;
        for (int i = 0; i < length; i++) {
            int randomNum = random.nextInt(length-i)+i;
            //进行交换
            int currentNum=currentArray[i];
            int swapNumber=currentArray[randomNum];
            int temp=currentNum;
            currentArray[i]=swapNumber;
            currentArray[randomNum]=temp;
        }
        return currentArray;
    }
}
