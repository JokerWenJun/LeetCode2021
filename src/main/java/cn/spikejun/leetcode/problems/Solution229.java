package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution229 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,1,1,3,3,2,2,2};
        List<Integer> integers = majorityElement(nums);
        System.out.println(integers);
    }

    public List<Integer> majorityElement(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //目标
        int target=nums.length/3;
        //计时器
        int count=1;
        int preNum=nums[0];
        //答案
        List<Integer>answ=new LinkedList<>();
        if (nums.length==1)
        {
            answ.add(nums[0]);
            return answ;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=preNum)
            {
                if (count>target)
                {
                    answ.add(preNum);
                }
                count=1;
                preNum=nums[i];
            }
            else
            {
                count++;
            }
        }
        //判断最后一个字符
        if (count>target)
        {
            answ.add(preNum);
        }
        return answ;
    }


}
