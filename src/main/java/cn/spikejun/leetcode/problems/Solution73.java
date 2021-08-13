package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution73 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(arr);
        System.out.println("!!!");
    }


    public void setZeroes(int[][] matrix) {
        boolean firstRowContainZero=false;
        boolean firstColumnContainZero=false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        //首先判断第一行和第一列有没有0
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0]==0)
            {
                firstColumnContainZero=true;
            }
        }
        for (int i = 0; i < columns; i++) {
            if (matrix[0][i]==0)
            {
                firstRowContainZero=true;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }            
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }
        if (firstRowContainZero)
        {
            for (int i = 0; i < columns; i++) {
                matrix[0][i]=0;
            }
        }
        if (firstColumnContainZero)
        {
            for (int i = 0; i < rows; i++) {
                matrix[i][0]=0;
            }
        }
    }


}
