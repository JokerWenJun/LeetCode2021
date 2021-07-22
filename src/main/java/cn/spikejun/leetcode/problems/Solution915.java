package cn.spikejun.leetcode.problems;

public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int[] maxArray=new int[nums.length];
        int[]minsArray=new int[nums.length];
        int flag=nums[0];
        maxArray[0]=nums[0];
        for (int i = 1; i < maxArray.length; i++) {
            flag=Math.max(nums[i],flag);
            maxArray[i]=flag;
        }
        int length = nums.length;
        flag=nums[nums.length-1];
        minsArray[length-1]=nums[length-1];
        for (int i = length-2; i >=0; i--) {
            flag=Math.min(flag,nums[i]);
            minsArray[i]=flag;
        }
        for (int i = 0; i < maxArray.length-1; i++) {
            if (maxArray[i]<=minsArray[i+1])
            {
                return i+1;
            }
        }
        return 0;
    }
}
