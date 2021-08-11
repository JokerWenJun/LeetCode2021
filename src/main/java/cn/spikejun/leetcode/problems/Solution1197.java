package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution1197 {

    @Test
    public void test()
    {
        int i = minKnightMoves(22, 163);
        System.out.println(i);
    }


    public int minKnightMoves(int x, int y) {
        int[]begin=new int[]{0,0};
        Queue<int[]>positiveQueue=new ArrayDeque<>();
        Queue<int[]>negativeQueue=new ArrayDeque<>();
        positiveQueue.add(begin);
        negativeQueue.add(new int[]{x,y});
        int count=0;
        Set<String>positiveVistied=new HashSet<>();
        Set<String>negitiveVistied=new HashSet<>();
        positiveVistied.add("0-0");
        negitiveVistied.add(x+"-"+y);
        while (!positiveQueue.isEmpty()&&!negativeQueue.isEmpty())
        {
            int positiveSize = positiveQueue.size();
            int negativeSize = negativeQueue.size();
            Queue<int[]>queue;
            Set<String>vistied;
            Set<String>otherVisitied;
            if (positiveSize>negativeSize)
            {
                queue=positiveQueue;
                vistied=positiveVistied;
                otherVisitied=negitiveVistied;
            }
            else
            {
                queue=negativeQueue;
                vistied=negitiveVistied;
                otherVisitied=positiveVistied;
            }
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int[][]nextStep=getNextStep(poll[0],poll[1]);
                for (int[] ints : nextStep) {
                    String s=ints[0]+"-"+ints[1];
                    if (!vistied.contains(s))
                    {
                        //判断对面的set是否有
                        if (otherVisitied.contains(s))
                        {
                            return count+1;
                        }
                        queue.add(ints);
                        vistied.add(s);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private int[][] getNextStep(int x, int y) {
        int[][]answ=new int[8][2];
        answ[0]=new int[]{x-2,y+1};
        answ[1]=new int[]{x-1,y+2};

        answ[2]=new int[]{x-2,y-1};
        answ[3]=new int[]{x-1,y-2};

        answ[4]=new int[]{x+1,y+2};
        answ[5]=new int[]{x+2,y+1};

        answ[6]=new int[]{x+2,y-1};
        answ[7]=new int[]{x+1,y-2};
        return answ;
    }
}
