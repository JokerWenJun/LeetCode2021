package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution764 {

    @Test
    public void test()
    {

        int[][]mines=new int[][]{{0,0},{0,1},{0,2},{0,7},{1,2},{1,3},{1,9},{2,3},{2,5},{2,7},{2,8},{3,2},{3,5},{3,7},{4,2},{4,3},{4,5},{4,7},{5,1},{5,4},{5,8},{5,9},{7,2},{7,5},{7,7},{7,8},{8,5},{8,8},{9,0},{9,1},{9,2},{9,8}};
        int i = orderOfLargestPlusSign(10, mines);
        System.out.println(i);
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][]arr=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i],1);
        }
        for (int i = 0; i < mines.length; i++) {
            int[]zeroPosition=mines[i];
            arr[zeroPosition[0]][zeroPosition[1]]=0;
        }
        int answ=0;
        int[][]leftDp=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    leftDp[i][j] = 0;
                } else {
                    if (i - 1 < 0 || j - 1 < 0 ||  arr[i][j - 1] == 0) {
                        leftDp[i][j] = 1;
                    } else {
                        leftDp[i][j] = 1 + leftDp[i][j - 1];
                    }
                }
            }
        }
        int[][]downDp=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    downDp[i][j] = 0;
                } else {
                    if (i - 1 < 0 || j - 1 < 0 || arr[i - 1][j] == 0) {
                        downDp[i][j] = 1;
                    } else {
                        downDp[i][j] = 1 + downDp[i-1][j];
                    }
                }
            }
        }
        int[][]rightDp=new int[n][n];
        int[][]upDp=new int[n][n];
        for (int i = n-1; i >=0; i--) {
            for (int j = n-1; j>=0; j--) {
                if (arr[i][j]==0)
                {
                    rightDp[i][j]=0;
                    upDp[i][j]=0;
                }
                else
                {
                    //handle right
                    if (j+1>n-1||rightDp[i][j+1]==0)
                    {
                        rightDp[i][j]=1;
                    }
                    else
                    {
                        rightDp[i][j]=1+rightDp[i][j+1];
                    }

                    //handle up
                    if (i+1>n-1||upDp[i+1][j]==0)
                    {
                        upDp[i][j]=1;
                    }
                    else
                    {
                        upDp[i][j]=1+upDp[i+1][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(downDp[i][j], Math.min(Math.min(leftDp[i][j], rightDp[i][j]), upDp[i][j]));
                answ=Math.max(min,answ);
            }
        }
        return answ;
    }
}
