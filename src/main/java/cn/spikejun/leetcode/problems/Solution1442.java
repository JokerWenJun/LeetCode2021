package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1442 {

    @Test
    public void test()
    {
        int[]arr=new int[]{2,3};
        int i = countTriplets(arr);
        System.out.println(i);
        System.out.println(2^3^1^6^7);
    }


    public int countTriplets(int[] arr) {
        int length=arr.length;
        int[]sum=new int[length+1];
        if (length==1)
        {
            return 0;
        }
        for (int i = 1; i <= length; i++) {
            sum[i]=arr[i-1]^sum[i-1];
        }
        int answ=0;
        for (int i = 0; i <= length; i++) {
            for (int j = i+1; j <= length; j++) {
                if (sum[i]==sum[j])
                {
                    int temp=j-i-1;
                    answ+=temp;
                }
            }
        }
        return answ;
    }

}
