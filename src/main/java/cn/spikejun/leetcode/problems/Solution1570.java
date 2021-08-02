package cn.spikejun.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution1570 {

    class SparseVector {

        //index-value
        Map<Integer,Integer> map;
        SparseVector(int[] nums) {
            map=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]!=0)
                {
                    map.put(i,nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            //判断哪个向量更加稀疏，用更少的那个去乘更稠密的
            Map<Integer, Integer> otherMap = vec.map;
            int answ=0;
            if (otherMap.size()>this.map.size())
            {
                Set<Integer> set = map.keySet();
                for (Integer integer : set) {
                    if (otherMap.containsKey(integer))
                    {
                        answ+=otherMap.get(integer)*map.get(integer);
                    }
                }
            }
            else
            {
                Set<Integer> set = otherMap.keySet();
                for (Integer integer : set) {
                    if (map.containsKey(integer))
                    {
                        answ+=otherMap.get(integer)*map.get(integer);
                    }
                }
            }
            return answ;
        }
    }
}
