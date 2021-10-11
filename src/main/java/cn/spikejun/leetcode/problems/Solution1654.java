package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution1654 {


    @Test
    public void test()
    {
        int[]arr=new int[]{18,13,3,9,8,14};
        int i = minimumJumps(arr, 3, 8, 6);
        System.out.println(i);
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        //first we need to create a set to save the block position
        Set<Integer>forbiddenSet=new HashSet<>();
        for (Integer integer : forbidden) {
            forbiddenSet.add(integer);
        }
        // then we need to bfs
        //create a queue that can save the array
        //0 means the pre step is forward;
        //1 means the pre step is backward;
        Queue<int[]>queue=new ArrayDeque<>();
        //first we need to add the zero position to the queue
        //the first element in the array means the position
        //the second element in the array means the direction
        //the third element in the array means the step
        queue.add(new int[]{0,0,0});
        int answ=-1;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int position=poll[0];
                int direction=poll[1];
                int step=poll[2];
                if (poll[0]==x)
                {
                    return poll[2];
                }
                //first we go forward
                if (position+a<=6000&&!forbiddenSet.contains(position+a))
                {
                    forbiddenSet.add(position+a);
                    queue.add(new int[]{position+a,0,step+1});
                }
                //then we think backward
                if (position-b>=0&&!forbiddenSet.contains(position-b)&&direction!=1)
                {
                    queue.add(new int[]{position-b,1,step+1});
                }
            }
        }
        return answ;
    }
}
