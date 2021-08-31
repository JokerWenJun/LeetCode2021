package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution881 {


    @Test
    public void test()
    {
        int[]arr=new int[]{1,2};
        int i = numRescueBoats1(arr, 3);
        System.out.println(i);
    }


    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int count=0;
        while (left<=right)
        {
            int min=people[left];
            int max=people[right];
            if(min+max<=limit)
            {
                left++;
                right--;
            }
            else
            {
                right--;
            }
            count++;
        }
        return count;
    }


    public int numRescueBoats1(int[] people, int limit) {
        List<Integer>list=new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int count=0;
        while (list.size()!=0)
        {
            Integer currentMaxPeople = list.get(0);
            //first Remove the first index
            list.remove(0);
            //
            Integer target=limit-currentMaxPeople;
            int targetIndex=binarySearch(list,target);
            if (targetIndex!=-1)
            {
                list.remove(targetIndex);
            }
            count++;
        }
        return count;
    }

    private int binarySearch(List<Integer> list, Integer target) {
        if (list.size()==0)
        {
            return -1;
        }
        if (list.get(list.size()-1)>target)
        {
            return -1;
        }
        int left=0;
        int right=list.size()-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (list.get(mid)<=target)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }


}
