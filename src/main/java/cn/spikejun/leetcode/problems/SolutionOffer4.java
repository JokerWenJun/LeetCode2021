package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class SolutionOffer4 {


    @Test
    public void test()
    {
        int[][]arr=new int[][]{{-5},
};
        boolean numberIn2DArray = findNumberIn2DArray(arr, -10);
        System.out.println(numberIn2DArray);
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0)
        {
            return false;
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        int currenttRow=0;
        int currentCol=columns-1;
        while (currenttRow<rows&&currentCol>=0)
        {
            if (matrix[currenttRow][currentCol]==target)
            {
                return true;
            }
            else if (matrix[currenttRow][currentCol]>target)
            {
                currentCol--;
            }
            else if (matrix[currenttRow][currentCol]<target)
            {
                currenttRow++;
            }
        }
        return false;
    }


}
