package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Solution398 {

    @Test
    public void test()
    {
        Random random=new Random();
        System.out.println(random.nextInt());
    }

    private int[]arr;
    public Solution398(int[] nums) {
        arr=nums;
    }
    public int pick(int target) {
        int n=0;
        int index=-1;
        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            if (target==arr[i])
            {
                n++;
                if (random.nextInt(n)==0)
                {
                    index=i;
                }
            }
        }
        return index;
    }
}
