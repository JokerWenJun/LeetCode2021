package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution598 {

    @Test
    public void test()
    {
        int m=3;
        int n=3;
        int[][]operations=new int[][]{{2,2},{3,3}};
        int i = maxCount(m, n, operations);
        System.out.println(i
        );
    }


    public int maxCount(int m, int n, int[][] ops) {
        int currentIntersectionX=m;
        int currentIntersectionY=n;
        for (int i = 0; i < ops.length; i++) {
            int[] op = ops[i];
            currentIntersectionX=Math.min(currentIntersectionX,op[0]);
            currentIntersectionY=Math.min(currentIntersectionY,op[1]);
        }
        return currentIntersectionX*currentIntersectionY;
    }
}
