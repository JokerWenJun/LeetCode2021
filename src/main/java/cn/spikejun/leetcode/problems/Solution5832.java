package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5832 {

    @Test
    public void test()
    {
        int[]nums=new int[]{6,2,0,9,7};
        int[] ints = rearrangeArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int minBeginIndex=0;
        int maxBeginIndex=0;
        if (length%2==0)
        {
            minBeginIndex=0;
            maxBeginIndex=length/2;
        }
        else
        {
            minBeginIndex=0;
            maxBeginIndex=length/2+1;
        }
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < (length / 2); i++) {
            list.add(nums[minBeginIndex+i]);
            list.add(nums[maxBeginIndex+i]);
        }
        if (length%2!=0)
        {
            list.add(nums[length/2]);
        }
        int[]answ=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answ[i]=list.get(i);
        }
        return answ;
    }
}
