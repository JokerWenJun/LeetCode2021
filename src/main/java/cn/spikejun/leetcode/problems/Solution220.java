package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.TreeSet;

public class Solution220 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,5,9,1,5,9};
        boolean b = containsNearbyAlmostDuplicate(nums, 2, 3);
        System.out.println(b);
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long>treeSet=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Long current=nums[i]*1l;
            //小于等于nums[i]的最大值
            Long floor = treeSet.floor(current);
            //大于等于nums[i]的最小值
            Long ceiling = treeSet.ceiling(current);
            if (floor!=null&&current-floor<=t)
            {
                return true;
            }
            if (ceiling!=null&&ceiling-current<=t)
            {
                return true;
            }
            treeSet.add(current);
            //维持滑动窗口的长度
            if (i>=k)
            {
                treeSet.remove(nums[i-k]*1l);
            }
        }
        return false;
    }


}
