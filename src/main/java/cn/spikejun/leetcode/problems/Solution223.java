package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution223 {

    @Test
    public void test()
    {
        int i = computeArea(-2, -2, 2, 2, 3, 3, 4, 4);
        System.out.println(i);
    }


    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int xMin=Math.min(ax1,bx1);
        int aNewX1=ax1-xMin;
        int aNewX2=ax2-xMin;
        int bNewX1=bx1-xMin;
        int bNewX2=bx2-xMin;
        int yMin=Math.min(ay1,by1);
        int aNewY1=ay1-yMin;
        int aNewY2=ay2-yMin;
        int bNewY1=by1-yMin;
        int bNewY2=by2-yMin;
        int intervalX=0;
        int intervalY=0;
        int [][]xArrays=new int[][]{{aNewX1,aNewX2},{bNewX1,bNewX2}};
        int [][]yArrays=new int[][]{{aNewY1,aNewY2},{bNewY1,bNewY2}};
        Arrays.sort(xArrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Arrays.sort(yArrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        if (xArrays[1][0]>=xArrays[0][1])
        {
            intervalX=0;
        }
        else
        {
            if (xArrays[1][1]<=xArrays[0][1])
            {
                intervalX=xArrays[1][1]-xArrays[1][0];
            }
            else
            {
                intervalX=xArrays[0][1]-xArrays[1][0];
            }
        }

        if (yArrays[1][0]>=yArrays[0][1])
        {
            intervalY=0;
        }
        else
        {
            if (yArrays[1][1]<=yArrays[0][1])
            {
                intervalY=yArrays[1][1]-yArrays[1][0];
            }
            else
            {
                intervalY=yArrays[0][1]-yArrays[1][0];
            }
        }
//        System.out.println("!!");
        return (aNewY2-aNewY1)*(aNewX2-aNewX1)+(bNewY2-bNewY1)*(bNewX2-bNewX1)-intervalX*intervalY;
    }
}
