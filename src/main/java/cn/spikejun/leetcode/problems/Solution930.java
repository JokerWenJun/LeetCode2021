package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution930 {

    @Test
    public void test()
    {
        int[]nums=new int[]{0,0,0,0,0};
        int i = numSubarraysWithSum(nums, 0);
        System.out.println(i);
    }


    public int numSubarraysWithSum(int[] nums, int goal) {
        int[]preSumArray=new int[nums.length+1];
        preSumArray[0]=0;
        int sum=0;
        int answ=0;
        for (int i = 0; i < nums.length; i++) {
            preSumArray[i+1]=nums[i]+sum;
            sum+=nums[i];
        }
        Map<Integer,Integer> count=new HashMap<>();
        count.put(0,1);
        for (int i = 1; i < preSumArray.length; i++) {
            int target=preSumArray[i]-goal;
            Integer ways = count.get(target);
            if (ways!=null)
            {
                answ+=ways;
            }
            count.put(preSumArray[i],count.getOrDefault(preSumArray[i],0)+1);
        }
        return answ;
    }
}
