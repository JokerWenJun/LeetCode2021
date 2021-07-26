package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1713 {

    @Test
    public void test()
    {
        int[]target=new int[]{1,3,8};
        int[]arr=new int[]{2,6};
        int i = minOperations(target, arr);
        System.out.println(i);
    }


    public int minOperations(int[] target, int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i],i);
        }
        //将arr转变为只含有target下标的数组
        List<Integer>arrList=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
            {
                arrList.add(map.get(arr[i]));
            }
        }
        if (arrList.size()==0)
        {
            return target.length;
        }
        int[]dp=new int[arr.length+1];
        dp[1]=arrList.get(0);
        int length=1;
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i)>dp[length])
            {
                length++;
                dp[length]=arrList.get(i);
            }
            else
            {
                //在dp数组里面找到第一个比arrList.get(i)大的数字
                //进行二分查找
                Integer flag=arrList.get(i);
                int left=1;
                int right=length;
                while (left<right)
                {
                    int mid=left+(right-left)/2;
                    if (dp[mid]<flag)
                    {
                        left=mid+1;
                    }
                    else
                    {
                        right=mid;
                    }
                }
                dp[left]=flag;
            }
        }
        return target.length-length;
    }
}
