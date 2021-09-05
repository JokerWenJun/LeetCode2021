package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5863 {


    @Test
    public void test()
    {
        int[]arr=new int[]{3,3,6,4,5};
        int i = countQuadruplets(arr);
        System.out.println(i);
    }
    private int count=0;
    public int countQuadruplets(int[] nums) {
        if (nums.length<4)
        {
            return 0;
        }
        for (int i = 3; i < nums.length; i++) {
            dfs(nums[i],i,3,nums);
        }
        return count;
    }

    private void dfs(int num, int startLocation, int size,int []arr) {
        if (size==0&&num==0)
        {
            count++;
            return;
        }
        if (size==0&&num!=0)
        {
            return;
        }
        for (int i = startLocation-1; i>=0; i--) {
            if (num-arr[i]<0)
            {
                continue;
            }
            dfs(num-arr[i],i,size-1,arr);
        }
    }
}
