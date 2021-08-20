package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    @Test
    public void test()
    {
        int[][]matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list.toString());
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>answ=new ArrayList<>();
        int[][]directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[]currentLocation=new int[]{0,0};
        int rows=matrix.length;
        int columns=matrix[0].length;
        int size=rows*columns;
        int i=0;
        int currentDirection=0;
        while (i<size)
        {
            answ.add(new Integer(matrix[currentLocation[0]][currentLocation[1]]));
            matrix[currentLocation[0]][currentLocation[1]]=101;
            //begin to move
            int[] currentDir = directions[currentDirection];
            //judge whether change direction
            int[]next=new int[]{currentLocation[0]+currentDir[0],currentLocation[1]+currentDir[1]};
            if (next[0]<0||next[0]>rows-1||next[1]<0||next[1]>columns-1||matrix[next[0]][next[1]]==101)
            {
                currentDirection=(currentDirection+1)%4;
                currentDir=directions[currentDirection];
                next=new int[]{currentLocation[0]+currentDir[0],currentLocation[1]+currentDir[1]};
            }
            currentLocation=next;
            i++;
        }
        return answ;
    }
}
