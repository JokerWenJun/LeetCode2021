package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1885 {

    @Test
    public void test()
    {
        int[]nums1=new int[]{1,10,6,2};
        int[]nums=new int[]{1,4,1,5};
        long l = countPairs(nums1, nums);
        System.out.println(l);
    }


    public long countPairs(int[] nums1, int[] nums2) {
        long answ=0;
        List<Integer>list=new ArrayList<>();
        //first we need to add head and tails, it helps me to binary search
        list.add(1-100000);
        list.add(100010);
        //then we need to traverse the num
        for (int i = 0; i < nums1.length; i++) {
            int a=nums1[i];
            int b=nums2[i];
            int minus=a-b;
            //first we need to search the index of element that is more than b-a+1
            int index=getIndex(list,b-a+1);
            int size = list.size();
            answ=answ+size-1-index;
            int addIndex = getIndex(list, minus);
            list.add(addIndex,minus);
        }
        return answ;
    }

    private int getIndex(List<Integer> list, int target) {
        int left=0;
        int right=list.size()-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (list.get(mid)<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }
}
