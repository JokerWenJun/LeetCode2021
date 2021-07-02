package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1310 {

    @Test
    public void test()
    {
        int []arr=new int[]{1,3,4,8};
        int[][]queries=new int[][]{{0,1},{1,2},{0,3},{3,3}};
        int[] ints = xorQueries(arr, queries);
        System.out.println(Arrays.toString(ints));
    }


    public int[] xorQueries(int[] arr, int[][] queries) {

        int arrSize=arr.length;
        int []dp=new int[arrSize+1];
        dp[0]=0;
        for (int i = 1; i <= arrSize; i++) {
            dp[i]=dp[i-1]^arr[i-1];
        }
        int size=queries.length;
        int []answ=new int[size];
        for (int i = 0; i < size; i++) {
            int beginPos=queries[i][0];
            int endPos=queries[i][1];
            int num=dp[endPos+1]^dp[beginPos];
            answ[i]=num;
        }
        return answ;
    }
}
