package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {

    @Test
    public void test()
    {
        int[]arr=new int[]{0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(arr);
        System.out.println(i);
    }


    public int longestConsecutive(int[] nums) {
        if (nums.length==0)
        {
            return 0;
        }
        Set<Integer>existNum=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            existNum.add(nums[i]);
        }
        int maxLength=1;
        for (int i = 0; i < nums.length; i++) {
            if (!existNum.contains(nums[i]-1))
            {
               int currentLength=0;
               int current=nums[i];
               int index=i;
               while (existNum.contains(current))
               {
                   currentLength++;
                   current++;
               }
               maxLength=Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }
}
