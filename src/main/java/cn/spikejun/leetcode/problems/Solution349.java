package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer>answ=new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]))
            {
                answ.add(nums2[i]);
            }
        }
        int[]arr=new int[answ.size()];
        int i=0;
        for (Integer integer : answ) {
            arr[i]=integer;
            i++;
        }
        return arr;
    }
}
