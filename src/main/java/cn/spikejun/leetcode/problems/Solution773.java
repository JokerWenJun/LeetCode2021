package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution773 {

    @Test
    public void test()
    {
        int[][]board=new int[][]{{3,2,4},{1,5,0}};
        int i = slidingPuzzle(board);
        System.out.println(i);
    }


    public int slidingPuzzle(int[][] board) {
        int step=0;
        Queue<String>queue=new ArrayDeque<>();
        Set<String>vistied=new HashSet<>();
        String beginStr=changeArrayToString(board);
        if (beginStr.equals("123450"))
        {
            return 0;
        }
        vistied.add(beginStr);
        queue.add(beginStr);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String peak = queue.poll();
                //将存在栈中的字符串转化为数组，并且找出0的位置
                int[][]arry=changeStringToArry(peak);
                //0常理上可以进行4个方向上的转动
                //上下左右
                for (int j = 0; j < 4; j++) {
                    //将0向上转
                    if (j==0)
                    {
                        if (zeroY-1<0)
                        {
                            continue;
                        }
                        //将0向上转
                        int originalInteger=arry[zeroY-1][zeroX];
                        arry[zeroY][zeroX]=originalInteger;
                        arry[zeroY-1][zeroX]=0;
                        String s = changeArrayToString(arry);
                        if (s.equals("123450"))
                        {
                            return step+1;
                        }
                        else
                        {
                            if (!vistied.contains(s))
                            {
                                vistied.add(s);
                                queue.add(s);
                            }
                        }
                        arry[zeroY][zeroX]=0;
                        arry[zeroY-1][zeroX]=originalInteger;
                    }
                    //将0向下转
                    if (j==1)
                    {
                        if (zeroY+1>1)
                        {
                            continue;
                        }
                        //将0向下转
                        int originalInteger=arry[zeroY+1][zeroX];
                        arry[zeroY][zeroX]=originalInteger;
                        arry[zeroY+1][zeroX]=0;
                        String s = changeArrayToString(arry);
                        if (s.equals("123450"))
                        {
                            return step+1;
                        }
                        else
                        {
                            if (!vistied.contains(s))
                            {
                                vistied.add(s);
                                queue.add(s);
                            }
                        }
                        arry[zeroY][zeroX]=0;
                        arry[zeroY+1][zeroX]=originalInteger;
                    }
                    //将0向左转
                    if (j==2)
                    {
                        if(zeroX-1<0)
                        {
                            continue;
                        }
                        //将0向左转
                        int originalInteger=arry[zeroY][zeroX-1];
                        arry[zeroY][zeroX]=originalInteger;
                        arry[zeroY][zeroX-1]=0;
                        String s = changeArrayToString(arry);
                        if (s.equals("123450"))
                        {
                            return step+1;
                        }
                        else
                        {
                            if (!vistied.contains(s))
                            {
                                vistied.add(s);
                                queue.add(s);
                            }
                        }
                        arry[zeroY][zeroX]=0;
                        arry[zeroY][zeroX-1]=originalInteger;
                    }
                    //将0向右转
                    if (j==3)
                    {
                        if (zeroX+1>2)
                        {
                            continue;
                        }
                        //将0向下转
                        int originalInteger=arry[zeroY][zeroX+1];
                        arry[zeroY][zeroX]=originalInteger;
                        arry[zeroY][zeroX+1]=0;
                        String s = changeArrayToString(arry);
                        if (s.equals("123450"))
                        {
                            return step+1;
                        }
                        else
                        {
                            if (!vistied.contains(s))
                            {
                                vistied.add(s);
                                queue.add(s);
                            }
                        }
                        arry[zeroY][zeroX]=0;
                        arry[zeroY][zeroX+1]=originalInteger;
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private int zeroX;
    private int zeroY;
    private int[][] changeStringToArry(String peak) {
        int[][]arry=new int[2][3];
        char[] chars = peak.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i<3)
            {
                if (chars[i]=='0')
                {
                    zeroX=i;
                    zeroY=0;
                }
                arry[0][i]=chars[i]-'0';
            }
            else
            {
                if (chars[i]=='0')
                {
                    zeroX=i-3;
                    zeroY=1;
                }
                arry[1][i-3]=chars[i]-'0';
            }
        }
        return arry;
    }

    private String changeArrayToString(int[][] board) {
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                stringBuffer.append(board[i][j]);
            }
        }
        return stringBuffer.toString();
    }
}
