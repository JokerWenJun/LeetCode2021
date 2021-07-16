package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {

    @Test
    public void test()
    {
        int[]nums=new int[]{-1,0,-5,-2,-2,-4,0,1,-2};
        List<List<Integer>> lists = fourSum(nums, -9);
        System.out.println("!!!!");
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length==0)
        {
            return new ArrayList<>();
        }
        //先排序
        Arrays.sort(nums);
        List<List<Integer>>answ=new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if (i!=0&&nums[i]==nums[i-1])
            {
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j!=i+1&&nums[j]==nums[j-1])
                {
                    continue;
                }
                //可以选择两个指针进行
                int targetSum=target-nums[i]-nums[j];
                int left=j+1;
                int right=nums.length-1;
//                if (targetSum<nums[left])
//                {
//                    continue;
//                }
                while (left<right)
                {
                    int currentSum=nums[left]+nums[right];
                    if (currentSum>targetSum)
                    {
                        right--;
                    }
                    else if (currentSum<targetSum)
                    {
                        left++;
                    }
                    else
                    {
                        //代表相等将符合条件的添加进去
                        List<Integer>list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        answ.add(list);
                        //排除相同的left和right对应的值
                        while (left<right&&nums[left]==nums[left+1])
                        {
                            left++;
                        }
                        while (left<right&&nums[right]==nums[right-1])
                        {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return answ;
    }
}
