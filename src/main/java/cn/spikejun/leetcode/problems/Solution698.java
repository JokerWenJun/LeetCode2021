package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution698 {

    @Test
    public void test()
    {

    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%k!=0)
        {
            return false;
        }

        int target=sum/k;
        if (nums[nums.length-1]>target)
        {
            return false;
        }
        boolean[]visited=new boolean[nums.length];
        boolean result=dfs(nums,0,target,k,visited,nums.length-1);
        return result;
    }

    private boolean dfs(int[] nums, int currentSum, int target, int k, boolean[] visited, int currentLocation) {
        if (k==1)
        {
            return true;
        }
        if (currentSum==target)
        {
             return dfs(nums,0,target,k-1,visited,nums.length-1);
        }
        for (int i = currentLocation; i>=0; i--) {
            if (visited[i])
            {
                continue;
            }
            if (currentSum+nums[i]>target)
            {
                continue;
            }
            visited[i]=true;
            boolean dfs = dfs(nums, currentSum + nums[i], target, k, visited, i - 1);
            if (dfs)
            {
                return true;
            }
            visited[i]=false;
            while (i>0&&nums[i]==nums[i-1])
            {
                i--;
            }
        }
        return false;
    }

}
