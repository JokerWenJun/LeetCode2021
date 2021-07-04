package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution645 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,2,4};
        int[] errorNums = findErrorNums(nums);
        String s = Arrays.toString(errorNums);
        System.out.println(s);
    }

    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int repeatNum=-1;
        int missNum=-1;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int i = 1; i <=nums.length; i++) {
            if (map.get(i)==null)
            {
                missNum=i;
            }
            else if (map.get(i)>1)
            {
                repeatNum=i;
            }
        }
        int[]answ=new int[]{repeatNum,missNum};
        return answ;
    }
}
