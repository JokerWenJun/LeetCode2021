package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution735 {


    @Test
    public void test()
    {
        int []arr=new int[]{1,-2,-2,-2};
        int[] ints = asteroidCollision(arr);
        System.out.println(Arrays.toString(ints));
    }


    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty())
            {
                stack.add(asteroids[i]);
            }
            else
            {
                Integer peek = stack.peekLast();
                //代表相撞
                if (asteroids[i]*peek<0)
                {
                    if (peek<0&&asteroids[i]>0)
                    {
                        stack.addLast(asteroids[i]);
                        continue;
                    }
                    if (Math.abs(peek)>Math.abs(asteroids[i]))
                    {
                        continue;
                    }
                    if (Math.abs(peek)==Math.abs(asteroids[i]))
                    {
                        stack.pollLast();
                        continue;
                    }
                    if (Math.abs(peek)<Math.abs(asteroids[i]))
                    {
                        stack.pollLast();
                        if (stack.isEmpty())
                        {
                            stack.addLast(asteroids[i]);
                            continue;
                        }
                        //判断是否还会相碰
                        while (!stack.isEmpty())
                        {
                            int top=stack.peekLast();
                            if (asteroids[i]*top<0)
                            {
                                if (Math.abs(top)==Math.abs(asteroids[i]))
                                {
                                    stack.pollLast();
                                    break;
                                }
                                if (Math.abs(top)<Math.abs(asteroids[i]))
                                {
                                    stack.pollLast();
                                    if (stack.isEmpty())
                                    {
                                        stack.addLast(asteroids[i]);
                                        break;
                                    }
                                }
                                if (Math.abs(top)>Math.abs(asteroids[i]))
                                {
                                    break;
                                }
                            }
                            else
                            {
                                stack.addLast(asteroids[i]);
                                break;
                            }
                        }
                        continue;
                    }
                }
                //代表同号
                else {
                    stack.addLast(asteroids[i]);
                }
            }
        }
        int size = stack.size();
        int[]answ=new int[size];
        for (int i = 0; i < answ.length; i++) {
            answ[i]=stack.pollFirst();
        }
        return answ;
    }
}
