package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution274 {

    @Test
    public void test()
    {
        int[]arr=new int[]{11,15};
        int i = hIndex(arr);
        System.out.println(i);
    }



    public int hIndex(int[] citations) {
        if (citations.length==1)
        {
            if (citations[0]>=1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        //进行排序
        Arrays.sort(citations);
        //找到h指数的最小值和最大值
        int left=0;
        int right=citations[citations.length-1];

        //判断边界
        int biggerThanMidHNumber = getBiggerThanMidHNumber(right, citations);
        if (right<=biggerThanMidHNumber)
        {
            return right;
        }


        while (left<right)
        {
            int midH=left+(right-left)/2;
            //进行判断是否当前的midH取得的n是否<=还是>
            int count=getBiggerThanMidHNumber(midH,citations);
            //根据当前的count进行判断
            if (count<midH)
            {
                right=midH;
            }
            //>=midH
            else
            {
                left=midH+1;
            }
        }
        //找到第一个h>N的h值
        int maxH=left-1;
        if (maxH<0)
        {
            return 0;
        }
        return maxH;
    }

    private int getBiggerThanMidHNumber(int midH, int[] citations) {
        int left=0;
        int right=citations.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (citations[mid]>=midH)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return citations.length-right;
    }
}
