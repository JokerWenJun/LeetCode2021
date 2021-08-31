package cn.spikejun.leetcode.problems;

public class Solution330 {
    public int minPatches(int[] nums, int n) {
        int count=0;
        long total=0;
        int index=0;
        while (total<n)
        {
            if (index<nums.length&&nums[index]<=total+1)
            {
                total += nums[index++];
            }
            else
            {
                count++;
                total=total*2+1;
            }
        }
        return count;
    }
}
