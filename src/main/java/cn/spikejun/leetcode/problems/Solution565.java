package cn.spikejun.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Solution565 {
    private int maxLength=-1;
    public int arrayNesting(int[] nums) {
        boolean[]visited=new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i])
            {
                dfs(nums,i,visited,0);
            }
        }
        return maxLength;
    }

    private void dfs(int[] nums, int index, boolean[]existNum,int length) {
        if (existNum[nums[index]])
        {
            maxLength=Math.max(maxLength,length);
        }
        else {
            existNum[nums[index]]=true;
            dfs(nums,nums[index],existNum,length+1);
        }
    }
}
