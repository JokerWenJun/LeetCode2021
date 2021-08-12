package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution48 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
//                {7,4,1},
//                {8,5,2},
//                {9,6,3}
        };
        rotate(arr);
        System.out.println("!!!");
    }


    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        //首先上下翻转
        for (int i = 0; i <= (rows / 2 - 1); i++) {
            for (int j = 0; j < columns; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[rows-1-i][j];
                matrix[rows-1-i][j]=temp;
            }
        }
        //再对角线翻转
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < columns; j++) {
                int temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}
