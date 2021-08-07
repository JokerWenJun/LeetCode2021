package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Set;

public class Solution457 {

    @Test
    public void test()
    {
        int[]arr=new int[]{-2,-3,-9};
        boolean b = circularArrayLoop(arr);
        System.out.println(b);
//        System.out.println(-10%5);
    }


    private Integer NOTARRIVE=1001;
    public boolean circularArrayLoop(int[] nums) {
        int preIndex=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==NOTARRIVE)
            {
                continue;
            }
            int currentIndex=i;
            int flag=nums[i]/Math.abs(nums[i]);
            if (dfs(nums,preIndex,i,flag))
            {
                return true;
            }
            else
            {
                nums[i]=NOTARRIVE;
            }
        }
        return false;
    }

    private boolean dfs(int[] nums, int preIndex, int currentIndex,int flag) {
        //判断失败的条件
        if (nums[currentIndex]==NOTARRIVE||currentIndex==preIndex||nums[currentIndex]*flag<0)
        {
            return false;
        }
        if (nums[currentIndex]==0)
        {
            return true;
        }
        int step=nums[currentIndex];
        nums[currentIndex]=0;
        int nextIndex;
        if (flag>0)
        {
            nextIndex=(currentIndex+step)%nums.length;
        }
        else
        {
            nextIndex=nums.length-1-((nums.length-1-currentIndex+Math.abs(step))%nums.length);
        }
        if (dfs(nums,currentIndex,nextIndex,flag))
        {
            return true;
        }
        else
        {
            nums[currentIndex]=NOTARRIVE;
            return false;
        }
    }
}
