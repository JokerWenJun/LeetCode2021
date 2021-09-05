package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class Solution587 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        int[][] ints = outerTrees(arr);
        System.out.println("!!!!");
    }



    public int[][] outerTrees(int[][] trees) {
        if (trees.length<2)
        {
            return trees;
        }
        //find the most left and bottom point
        int[]beginPoint=findTheBeginPoint(trees);
        //sort the arr
        Arrays.sort(trees, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int[]line1=new int[]{o1[0]-beginPoint[0],o1[1]-beginPoint[1]};
                int[]line2=new int[]{o2[0]-beginPoint[0],o2[1]-beginPoint[1]};
                int result=line1[0]*line2[1]-line1[1]*line2[0];
                if (result==0)
                {
                    int distanceOne=distanceOfFirstPoint(o1,beginPoint);
                    int distanceTwo=distanceOfFirstPoint(o2,beginPoint);
                    return distanceOne-distanceTwo;
                }
                else if (result<0)
                {
                    return 1;
                }else
                {
                    return -1;
                }
            }
        });
        //handle the last line which may have many points in the line
        int index=trees.length-1;
        while (index>=0&&getTheAngle(beginPoint,trees[trees.length-1],trees[index])==0)
        {
            index--;
        }
        index++;
        for (int i = index,j=trees.length-1;i<j; i++,j--) {
            int[]temp=trees[i].clone();
            trees[i]=trees[j];
            trees[j]=temp;
        }
        //begin the Graham
        Deque<int[]>deque=new ArrayDeque<>();
        deque.addLast(trees[0]);
        deque.addLast(trees[1]);
        for (int i = 2; i < trees.length; i++) {
            int[] poll = deque.pollLast();
            while (!deque.isEmpty()&&getTheAngle(deque.peekLast(),poll,trees[i])<0)
            {
                poll=deque.pollLast();
            }
            deque.addLast(poll);
            deque.addLast(trees[i]);
        }
        int[][]answ=new int[deque.size()][2];
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            answ[i]=deque.pollLast();
        }
        return answ;
    }

    private int getTheAngle(int[]beginPoint,int[]o1,int[]o2)
    {
        int[]line1=new int[]{o1[0]-beginPoint[0],o1[1]-beginPoint[1]};
        int[]line2=new int[]{o2[0]-beginPoint[0],o2[1]-beginPoint[1]};
        int result=line1[0]*line2[1]-line1[1]*line2[0];
        return result;
    }

    private int distanceOfFirstPoint(int[] o1, int[] beginPoint) {

        return (o1[0]-beginPoint[0])*(o1[0]-beginPoint[0])+(o1[1]-beginPoint[1])*(o1[1]-beginPoint[1]);

    }

    private int[] findTheBeginPoint(int[][] trees) {
        int length = trees.length;
        int y=Integer.MAX_VALUE;
        int x=0;
        for (int i = 0; i < length; i++) {
            if (trees[i][1]<y)
            {
                y=trees[i][1];
                x=trees[i][0];
            }
            else if (trees[i][1]==y)
            {
                x=Math.min(x,trees[i][0]);
            }
        }
        return new int[]{x,y};
    }
}
