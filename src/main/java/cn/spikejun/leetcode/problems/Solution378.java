package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution378 {
    @Test
    public void test()
    {
        int [][]matrix=new int[][]{{-5}};
        int i = kthSmallest(matrix, 1);
        System.out.println(i);
    }


    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int minValue=matrix[0][0];
        int maxValue=matrix[n-1][n-1];
        //从minValue-maxValue之间进行二分查找
        while (minValue<maxValue)
        {
            int midValue=minValue+(maxValue-minValue)/2;
            int number=getNumberWhichBigToMidValue(midValue,matrix);
            if (number<k)
            {
                minValue=midValue+1;
            }
            if (number>=k)
            {
                maxValue=midValue;
            }
        }
        return minValue;
    }

    private int getNumberWhichBigToMidValue(int midValue, int[][] matrix) {
        //从(n-1)(0)处开始寻找
        int n=matrix.length;
        int count=0;
        int i=n-1;
        int j=0;
        while (j<n&&i>=0)
        {
            if (matrix[i][j]<=midValue)
            {
                count+=i+1;
                j++;
            }
            else
            {
                i--;
            }
        }
        return count;
    }
}
