package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution41 {

    @Test
    public void test()
    {
        int[]arr=new int[]{3,4,-1,1};
        int i = firstMissingPositive(arr);
        System.out.println(i);
    }


    public int firstMissingPositive(int[] nums) {
        int length=nums.length;
        //先将数组中的<=0的数全部变成length+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=0)
            {
                nums[i]=length+1;
            }
        }
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i])>=1&&Math.abs(nums[i])<=length)
            {
                int index=Math.abs(nums[i])-1;
                if (nums[index]>0)
                {
                    nums[index]=-nums[index];
                }
            }
        }
        int answ=length+1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0)
            {
                answ=i+1;
                return answ;
            }
        }
        return answ;
    }


}
