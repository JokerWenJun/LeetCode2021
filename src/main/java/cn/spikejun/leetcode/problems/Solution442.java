package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (nums[abs-1]<0)
            {
                list.add(abs);
            }
            else
            {
                nums[abs-1]=nums[abs-1]*-1;
            }
        }
        return list;
    }
}
