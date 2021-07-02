package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution1074 {

    @Test
    public void test()
    {
        int[][]matrix=new int[][]{{0,1,0},{1,1,1},{0,1,0}};
        int i = numSubmatrixSumTarget(matrix, 0);
        System.out.println(i);
    }


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //列
        int column=matrix[0].length;
        //行
        int rows=matrix.length;

        int answ=0;
        for (int i = 0; i < rows; i++) {
            int []nums=new int[column];
            for (int j = i; j < rows; j++) {
                Map<Integer,Integer>data=new HashMap<>();
                data.put(0,1);
                int preSum=0;
                for (int k = 0; k < column; k++) {
                    nums[k]+=matrix[j][k];
                    preSum+=nums[k];
                    if (data.containsKey(preSum-target))
                    {
                        answ+=data.get(preSum-target);
                    }
                    data.put(preSum,data.getOrDefault(preSum,0)+1);
                }
            }
        }
        return answ;
    }
}
