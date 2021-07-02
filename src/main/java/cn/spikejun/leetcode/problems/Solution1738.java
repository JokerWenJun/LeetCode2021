package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1738 {

    @Test
    public void test()
    {
        int[][]matrix=new int[][]{{10,9,5},{2,0,4},{1,0,7},{3,4,8}};
        int i = kthLargestValue(matrix, 4);
        System.out.println(i);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        //状态数组
        int[][]dp=new int[rows][columns];
        List<Integer>nums=new ArrayList<>();
        dp[0][0]=matrix[0][0];
        nums.add(dp[0][0]);
        //横向初始化
        for (int i = 1; i < columns; i++) {
            dp[0][i]=matrix[0][i]^dp[0][i-1];
            nums.add(dp[0][i]);
        }
        //竖向初始化
        for (int i = 1; i < rows; i++) {
            dp[i][0]=matrix[i][0]^dp[i-1][0];
            nums.add(dp[i][0]);
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j]=dp[i-1][j-1]^dp[i-1][j]^dp[i-1][j-1]^dp[i][j-1]^dp[i-1][j-1]^matrix[i][j];
                nums.add(dp[i][j]);
            }
        }
        Integer[]numsArray=new Integer[columns*rows];
        nums.toArray(numsArray);
        Arrays.sort(numsArray);
        return numsArray[numsArray.length-k];
    }



}
