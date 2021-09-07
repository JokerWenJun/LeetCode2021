package cn.spikejun.leetcode.problems;

import java.util.*;

public class Solution1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //nums[i]-count
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int[]countArr=new int[map.size()];
        Set<Integer> set = map.keySet();
        int index=0;
        for (Integer integer : set) {
            countArr[index]=map.get(integer);
            index++;
        }
        Arrays.sort(countArr);
        int length = countArr.length;
        for (int i = 0; i < countArr.length; i++) {
            if (k>=countArr[i])
            {
                k-=countArr[i];
            }
            else
            {
                return countArr.length-i;
            }
        }
        return 0;
    }


}
