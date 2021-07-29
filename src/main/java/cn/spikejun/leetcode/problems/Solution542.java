package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution542 {

    @Test
    public void test()
    {
        int[][]array=new int[][]{{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        int[][] ints = updateMatrix(array);
        System.out.println("!!!!");
    }


    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int columns=mat[0].length;
        int[][]newArray=new int[rows][columns];
        Queue<int[]>queue=new ArrayDeque<>();
        //先统计0的数目
        for (int i = 0; i < rows; i++) {
            Arrays.fill(newArray[i],-1);
            for (int j = 0; j < columns; j++) {
                if (mat[i][j]==0)
                {
                    int[]zeroPosition=new int[]{i,j};
                    queue.add(zeroPosition);
                    newArray[i][j]=0;
                }
            }
        }
        int route=0;
        while (!queue.isEmpty())
        {
            route++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int row=poll[0];
                int col=poll[1];
                //分别进行上下左右四个方位进行判断只要不超界限/已经有值
                for (int j = 0; j < 4; j++) {
                    //上
                    if (j==0)
                    {
                        int newRow=row-1;
                        int newCol=col;
                        if (newRow>=0&&newCol>=0&&newRow<rows&&newCol<columns&&newArray[newRow][newCol]==-1)
                        {
                            newArray[newRow][newCol]=route;
                            queue.add(new int[]{newRow,newCol});
                        }
                    }
                    //下
                    if (j==1)
                    {
                        int newRow=row+1;
                        int newCol=col;
                        if (newRow>=0&&newCol>=0&&newRow<rows&&newCol<columns&&newArray[newRow][newCol]==-1)
                        {
                            newArray[newRow][newCol]=route;
                            queue.add(new int[]{newRow,newCol});
                        }
                    }
                    //左
                    if (j==2)
                    {
                        int newRow=row;
                        int newCol=col-1;
                        if (newRow>=0&&newCol>=0&&newRow<rows&&newCol<columns&&newArray[newRow][newCol]==-1)
                        {
                            newArray[newRow][newCol]=route;
                            queue.add(new int[]{newRow,newCol});
                        }
                    }
                    //右
                    if (j==3)
                    {
                        int newRow=row;
                        int newCol=col+1;
                        if (newRow>=0&&newCol>=0&&newRow<rows&&newCol<columns&&newArray[newRow][newCol]==-1)
                        {
                            newArray[newRow][newCol]=route;
                            queue.add(new int[]{newRow,newCol});
                        }
                    }
                }
            }
        }
        return  newArray;
    }
}
