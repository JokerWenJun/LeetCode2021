package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1937 {

    @Test
    public void test()
    {
        int[][]points=new int[][]{{1,5},{2,3},{4,2}};
        long l = maxPoints(points);
        System.out.println(l);
    }


    public long maxPoints(int[][] points) {
        int rows=points.length;
        int columns=points[0].length;
        long[]preArrayDp=new long[columns];
        for (int i = 0; i < columns; i++) {
            preArrayDp[i]=points[0][i];
        }
        for (int i = 1; i < rows; i++) {
            long[]currentArrayDp=new long[columns];
            long max=Long.MIN_VALUE;
            //正向搜索
            for (int j = 0; j < columns; j++) {
                max=Math.max(max,preArrayDp[j]+j);
                currentArrayDp[j]=Math.max(currentArrayDp[j],points[i][j]-j+max);
            }
            //反方向搜索
            max=Long.MIN_VALUE;
            for (int j = columns-1; j >= 0; j--) {
                max=Math.max(max,preArrayDp[j]-j);
                currentArrayDp[j]=Math.max(currentArrayDp[j],points[i][j]+j+max);
            }
            preArrayDp=currentArrayDp;
        }
        long answ=Long.MIN_VALUE;
        for (int i = 0; i < preArrayDp.length; i++) {
            answ=Math.max(answ,preArrayDp[i]);
        }
        return answ;
    }
}
