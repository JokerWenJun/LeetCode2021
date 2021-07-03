package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution658 {

    @Test
    public void test()
    {
        int[]arr=new int[]{0,1,2,2,2,3,6,8,8,9};
        List<Integer> closestElements = findClosestElements(arr, 5, 9);
        System.out.println(closestElements);
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer>answ=new LinkedList<>();
        if (x<=arr[0])
        {
            for (int i = 0; i < k; i++) {
                answ.add(arr[i]);
            }
            return answ;
        }
        if (x>=arr[arr.length-1])
        {
            for (int i = k-1; i >= 0; i--) {
                answ.add(arr[arr.length-1-i]);

            }
            return answ;
        }
        //k代表的是个数
        //x代表的标志
        int left=0;
        int right=arr.length-1;
        if (x>arr[0]&&x<arr[arr.length-1])
        {
            while (left<right)
            {
                int mid=left+(right-left)/2;
                if (arr[mid]<=x)
                {
                    left=mid+1;
                }
                //arr[mid]>x
                else
                {
                    right=mid;
                }

            }
        }

        int leftArr=right-1;
        int rightArr=right;

        while (k>0&&leftArr>=0&&rightArr<=arr.length-1)
        {
            if (x-arr[leftArr]<=arr[rightArr]-x)
            {
                answ.add(arr[leftArr]);
                leftArr--;
            }
            else if (x-arr[leftArr]>arr[rightArr]-x)
            {
                answ.add(arr[rightArr]);
                rightArr++;
            }
            k--;
        }
        if (k!=0)
        {
            if (leftArr<0)
            {
                for (int i = 0; i < k; i++) {
                    answ.add(arr[rightArr]);
                    rightArr++;
                }
            }
            //右边碰界限
            else
            {
                for (int i = 0; i < k; i++) {
                    answ.add(arr[leftArr]);
                    leftArr--;
                }
            }
        }


        answ.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return answ;
    }
}
