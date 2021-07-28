package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution932 {

    private Map<Integer, List<Integer>>map;
    public int[] beautifulArray(int n) {
        map=new HashMap<>();
        List<Integer>number1List=new ArrayList<>();
        number1List.add(1);
        map.put(1,number1List);
        List<Integer>nList=function(n);
        int[]nums=new int[nList.size()];
        for (int i = 0; i < nList.size(); i++) {
            nums[i]=nList.get(i);
        }
        return nums;
    }

    private List<Integer> function(int n) {
        if (!map.containsKey(n))
        {
            List<Integer>currentList=new ArrayList<>();
            List<Integer> oddNumberList = function((n + 1) / 2);
            List<Integer> evenNumberList = function((n ) / 2);
            for (Integer integer : oddNumberList) {
                currentList.add(integer*2-1);
            }
            for (Integer integer : evenNumberList) {
                currentList.add(integer*2);
            }
            map.put(n,currentList);
        }
        return map.get(n);
    }
}
