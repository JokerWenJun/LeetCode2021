package cn.spikejun.leetcode.problems;

public class Solution1480 {
    public int[] runningSum(int[] nums) {
        int[]answ=new int[nums.length];
        int currentSum=0;
        for (int i = 0; i < nums.length; i++) {
            answ[i]=currentSum+nums[i];
            currentSum=answ[i];
        }
        return answ;
    }
}
