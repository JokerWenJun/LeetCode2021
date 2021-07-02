package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution525 {

    @Test
    public void test()
    {
        int[]nums=new int[]{0};
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>gapOfZeroAndOne=new HashMap<>();
        gapOfZeroAndOne.put(0,-1);
        int preZeroCount=0;
        int preOneCount=0;
        int answ=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0)
            {
                preZeroCount++;
            }
            else
            {
                preOneCount++;
            }
            if (gapOfZeroAndOne.containsKey(preZeroCount-preOneCount))
            {
                Integer fistPosition = gapOfZeroAndOne.get(preZeroCount - preOneCount);
                if (answ<i-fistPosition)
                {
                    answ=i-fistPosition;
                }
            }
            else
            {
                gapOfZeroAndOne.put(preZeroCount-preOneCount,i);
            }
        }
        return answ;
    }
}
