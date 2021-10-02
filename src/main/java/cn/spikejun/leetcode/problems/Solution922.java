package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Solution922 {
    @Test
    public void test()
    {
        int[]arr=new int[]{4,2,5,7};
        int[] ints = sortArrayByParityII(arr);
        System.out.println(Arrays.toString(ints));
    }
    public int[] sortArrayByParityII(int[] nums) {
        Stack<Integer>odd=new Stack<>() ;
        Stack<Integer>even=new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            //means the index is even
            if (i%2==0)
            {
                if (nums[i]%2!=0)
                {
                    if (odd.isEmpty())
                    {
                        even.add(i);
                    }
                    else
                    {
                        Integer pop = odd.pop();
                        swift(pop,i,nums);
                    }
                }
            }
            else
            {
                if (nums[i]%2==0)
                {
                    if (even.isEmpty())
                    {
                        odd.add(i);
                    }
                    else
                    {
                        Integer pop = even.pop();
                        swift(pop,i,nums);
                    }
                }
            }
        }
        return nums;
    }

    private void swift(Integer a, int b,int[]arr) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
