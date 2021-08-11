package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution446 {

    @Test
    public void test()
    {
        int[]nums=new int[]{0,2000000000,-294967296};
        int i = numberOfArithmeticSlices(nums);
        System.out.println(i);
    }


    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<3)
        {
            return 0;
        }
        Map<Long,Integer>[]maps=new HashMap[nums.length];
        int answ=0;
        for (int i = 0; i < nums.length; i++) {
            maps[i]=new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d=(1L)*nums[i]-nums[j];
                answ+=maps[j].getOrDefault(d,0);
                maps[i].put(d,maps[i].getOrDefault(d,0)+1+maps[j].getOrDefault(d,0));
            }
        }
        return answ;
    }
}
