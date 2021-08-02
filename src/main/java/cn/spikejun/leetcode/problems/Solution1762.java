package cn.spikejun.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1762 {

    public int[] findBuildings(int[] heights) {
        Deque<Integer>deque=new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty()&&heights[i]>=heights[deque.peekLast()])
            {
                deque.pollLast();

            }
            deque.offerLast(i);
        }
        //此时dequeue中的元素就是答案
        int size = deque.size();
        int[]answ=new int[size];
        for (int i = 0; i < answ.length; i++) {
            answ[i]=deque.pollFirst();
        }
        return answ;
    }
}
