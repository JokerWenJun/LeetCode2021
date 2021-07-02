package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution523 {

    @Test
    public void test()
    {
        int[]nums=new int[]{23,2,6,4,7};
        boolean b = checkSubarraySum(nums, 13);
        System.out.println(b);
    }


    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> logData=new HashMap();
        logData.put(0,-1);
        int preNum=0;
        for (int i = 0; i < nums.length; i++) {
            preNum+=nums[i];
            if (logData.containsKey(preNum%k))
            {
                Integer firstIndex = logData.get(preNum % k);
                if (i-firstIndex>=2)
                {
                    return true;
                }
            }
            else
            {
                logData.put(preNum%k,i);
            }
        }
        return false;
    }


}
