package cn.spikejun.leetcode.problems;

public class Solution1646 {
    public int getMaximumGenerated(int n) {
        if (n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        int[]nums=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        int max=1;
        for (int i = 2; i < nums.length; i++) {
            if (i%2==0)
            {
                int index = i / 2;
                nums[i]=nums[index];
            }
            else {
                int index1=(i-1)/2;
                int index2=index1+1;
                nums[i]=nums[index1]+nums[index2];
            }
            max=Math.max(nums[i],max);
        }
        return max;
    }
}
