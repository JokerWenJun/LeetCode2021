package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.TreeSet;

public class Solution363 {


    @Test
    public void test()
    {
        int[][]matrix=new int[][]{{2,2,-1}};
        int i = maxSumSubmatrix(matrix, 0);
        System.out.println(i);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int answ=Integer.MIN_VALUE;
        int rows = matrix.length;
        int columns=matrix[0].length;
        for (int upLine = 0; upLine < rows; upLine++) {
            int[]arr=new int[columns];
            for (int floorLine = upLine; floorLine < rows; floorLine++) {
                //叠加下边界的数字
                for (int i = 0; i < columns; i++) {
                    arr[i]+=matrix[floorLine][i];
                }
                //创建红黑树
                TreeSet<Integer>set=new TreeSet<>();
                set.add(0);
                int count=0;
                for (int i = 0; i < columns; i++) {
                    count+=arr[i];
                    Integer ceiling = set.ceiling(count - k);
                    if (ceiling!=null)
                    {
                        answ=Math.max(answ,count-ceiling);
                    }
                    set.add(count);
                }
            }
            
        }
        return answ;
    }
}
