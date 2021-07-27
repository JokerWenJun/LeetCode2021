package cn.spikejun.leetcode.problems;

public class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        //
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        long count=Math.abs(sum-goal);
        if (count%limit==0)
        {
            return (int) (count/limit);
        }
        else
        {
            return (int) (count/limit+1);
        }
    }
}
