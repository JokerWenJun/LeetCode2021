package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1337 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int[] ints = kWeakestRows(arr, 3);
        System.out.println(Arrays.toString(ints));
    }




    public int[] kWeakestRows(int[][] mat, int k) {
        //先定义优先队列
        PriorityQueue<int[]>queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                {
                    return o1[1]-o2[1];
                }
                else
                {
                    return o1[0]-o2[0];
                }
            }
        });
        int length = mat.length;
        for (int i = 0; i < length; i++) {
            int[] currentRow = mat[i];
            //计算出当前行的战斗力
            int value=getCurrentFroceValue(currentRow);
            int[] newarr=new int[]{value,i};
            queue.add(newarr);
        }
        int[]answ=new int[k];
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            answ[i]=poll[1];
        }
        return answ;
    }

    private int getCurrentFroceValue(int[] currentRow) {
       if (currentRow[0]==0)
       {
           return 0;
       }
       int left=0;
       int right=currentRow.length-1;
       while (left<right)
       {
           int mid=left+(right-left)/2+1;
           if (currentRow[mid]==0)
           {
               right=mid-1;
           }
           else
           {
               left=mid;
           }
       }
        return right-0+1;
    }

}
