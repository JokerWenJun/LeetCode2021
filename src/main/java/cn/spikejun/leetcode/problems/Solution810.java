package cn.spikejun.leetcode.problems;

public class Solution810 {
    public boolean xorGame(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum^nums[i];
        }
        if (sum==0)
        {
            return true;
        }
        else
        {
            if (nums.length%2==0)
            {
                return true;
            }
        }
        return false;
    }


}
