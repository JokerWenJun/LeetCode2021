package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1524 {

    @Test
    public void test()
    {
        int[]arr=new int[]{1,2,3,4,5,6,7};
        int i = numOfSubarrays(arr);
        System.out.println(i);
        int a= (int) (Math.pow(10,9)+7);
        System.out.println(a);

    }


    public int numOfSubarrays(int[] arr) {
        //
        int count=0;
        int oddNum=0;
        int evenNum=1;
        //前缀和数组
        int[]sum=new int[arr.length+1];
        //求出前缀和
        for (int i = 1; i < sum.length; i++) {
            sum[i]=sum[i-1]+arr[i-1];
            if (sum[i]%2==0)
            {
                count+=oddNum;
                count=count%1000000007;
                evenNum++;
            }
            else
            {
                count+=evenNum;
                count=count%1000000007;
                oddNum++;
            }
        }

        return count;
    }
}
