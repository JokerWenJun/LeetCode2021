package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {


    @Test
    public void test()
    {
        int[][]intervals=new int[][]{{2,5},{6,7},{8,9}};
        int[]newinterval=new int[]{0,1};
        int[][] insert = insert(intervals, newinterval);
        System.out.println("!!!!");
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0)
        {
            return new int[][]{newInterval};
        }
        List<int[]>list=new ArrayList<>();
        int length = intervals.length;
        boolean isInsert=false;
        for (int i = 0; i < length; i++) {
            int[] currentInterval = intervals[i];
            //判断是否有交集
            //表示当前的间隔与当前的
            if (newInterval[1]<currentInterval[0]||newInterval[0]>currentInterval[1])
            {
                //在插入区间的左边
                if (newInterval[0]>currentInterval[1])
                {
                    list.add(currentInterval);
                }
                //在插入区间的右边
                else
                {
                    if (!isInsert)
                    {
                        //讲插入区间插入
                        list.add(newInterval);
                        isInsert=true;
                    }
                    //插入新的区间
                    list.add(currentInterval);
                }
            }
            //表示当前的区间与目标区间发生了碰撞
            else
            {
                int left=Math.min(newInterval[0],currentInterval[0]);
                int right=Math.max(newInterval[1],currentInterval[1]);
                newInterval[0]=left;
                newInterval[1]=right;
            }
        }
        //判断是否已经将插入区间插入
        if (!isInsert)
        {
            list.add(newInterval);
        }
        int[][]answ=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answ[i]=list.get(i);
        }
        return answ;
    }

}
