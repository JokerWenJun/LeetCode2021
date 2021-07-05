package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution566 {
    @Test
    public void test()
    {
        int[][]mat=new int[][]{{1,2},{3,4}};
        int[][] ints = matrixReshape(mat, 1, 4);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }


    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows=mat.length;
        int columns=mat[0].length;
        if (rows*columns!=r*c)
        {
            return mat;
        }
        int currentRow=0;
        int currentColumn=0;
        int[][]changeArr=new int[r][c];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (currentColumn==c)
                {
                    currentRow++;
                    currentColumn=0;
                }
                changeArr[currentRow][currentColumn]=mat[i][j];
                currentColumn++;
            }
        }
        return changeArr;
    }

}
