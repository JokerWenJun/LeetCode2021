package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1041 {

    @Test
    public void test()
    {
        String s="GL";
        boolean robotBounded = isRobotBounded(s);
        System.out.println(robotBounded);
    }


    public boolean isRobotBounded(String instructions) {
        int[][]directions=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int direction=0;
        //left-->-1
        //right-->+1
        int[] beginPosition=new int[]{0,0};
        char[] chars = instructions.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='L')
            {
                direction=(direction-1)%4;
            }
            if (chars[i]=='R')
            {
                direction=(direction+1)%4;
            }
            if (chars[i]=='G')
            {
                if (direction==0)
                {
                    beginPosition[0]=beginPosition[0];
                    beginPosition[1]=beginPosition[1]+1;
                }
                //向右
                if (direction==1||direction==-3)
                {
                    beginPosition[0]=beginPosition[0]+1;
                    beginPosition[1]=beginPosition[1];
                }
                //向左
                if (direction==-1||direction==3)
                {
                    beginPosition[0]=beginPosition[0]-1;
                    beginPosition[1]=beginPosition[1];
                }
                //向下
                if (direction==2||direction==-2)
                {
                    beginPosition[0]=beginPosition[0];
                    beginPosition[1]=beginPosition[1]-1;
                }
            }
        }
        if (direction==0)
        {
            if (beginPosition[0]==0&&beginPosition[1]==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return  true;
    }
}
