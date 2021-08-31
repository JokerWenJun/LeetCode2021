package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution137 {

    @Test
    public void test()
    {
        int[]arr=new int[]{2,2,2,3};
        int i = singleNumber(arr);
        System.out.println(i);
    }


    public int singleNumber(int[] nums) {

        int[]arr=new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                arr[i]+=(nums[j]>>i)&1;
            }
            arr[i]=arr[i]%3;
        }
        int answ=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1)
            {
                answ=answ+(1<<i);
            }
        }
        return answ;
    }
}
