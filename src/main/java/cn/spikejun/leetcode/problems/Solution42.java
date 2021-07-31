package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution42 {

    @Test
    public void test()
    {
        int[]arr=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(arr);
        System.out.println(trap);
    }


    public int trap(int[] height) {
        Deque<Integer>deque=new ArrayDeque<>();
        int length = height.length;
        int answ=0;
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty()&&height[i]>height[deque.peekLast()])
            {
                //无论怎么样第一个小于当前列的是不能计算面积的
                Integer pollIndex = deque.pollLast();
                //如果此时队列为空就直接bbreak
                if (deque.isEmpty())
                {
                    break;
                }
                Integer peekIndex = deque.peekLast();
                int currentWidth=i-peekIndex-1;
                int currentHeight=Math.min(height[i],height[peekIndex])-height[pollIndex];
                answ+=currentWidth*currentHeight;
            }
            deque.offerLast(i);
        }
        return answ;
    }
}
