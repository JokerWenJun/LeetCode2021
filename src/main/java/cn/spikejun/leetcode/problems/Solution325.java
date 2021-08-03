package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution325 {

    @Test
    public void test()
    {
        int[]nums=new int[]{-2,-1,2,1};
        int i = maxSubArrayLen(nums, 1);
        System.out.println(i);
    }


    public int maxSubArrayLen(int[] nums, int k) {
        //index-sum
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            int target=sum-k;
            //判断map里面有没有当前的target
            if (map.containsKey(target))
            {
                maxLength=Math.max(maxLength,i-map.get(target));
            }
            //然后将当前的target加入到map里面，此时注意的是如果map里面有这个sum那就不用添加
            if (!map.containsKey(sum))
            {
                map.put(sum,i);
            }
        }
        return  maxLength;
    }
}
