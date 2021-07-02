package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,1,1};
        int i = subarraySum(nums, 2);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>data=new HashMap<>();
        data.put(0,1);
        int answ=0;
        int preSum=0;
        for (int i = 0; i < nums.length; i++) {
            preSum+=nums[i];
            if (data.containsKey(preSum-k))
            {
                answ+=data.get(preSum-k);
            }
            data.put(preSum,data.getOrDefault(preSum,0)+1);
        }
        return answ;
    }


}
