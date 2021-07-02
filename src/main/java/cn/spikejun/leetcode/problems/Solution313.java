package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution313 {

    @Test
    public void test()
    {
        int[]primes=new int[]{2,7,13,19};
        int i = nthSuperUglyNumber(12, primes);
        System.out.println(i);
    }


    public int nthSuperUglyNumber(int n, int[] primes) {
        //创建最小堆
        PriorityQueue<Long>queue=new PriorityQueue<>();
        //创建set来存储已经存在的超级丑数
        Set<Long>existNumbers=new HashSet<>();
        queue.offer(1l);
        existNumbers.add(1l);
        for (int i = 0; i < primes.length; i++) {
            existNumbers.add((long)primes[i]);
            queue.offer((long)primes[i]);
        }
        long answ=0;
        while (n!=0)
        {
            long topSmallestNumber=queue.peek();
            for (int i = 0; i < primes.length; i++) {
                long current=primes[i]*topSmallestNumber;
                if (!existNumbers.contains(current))
                {
                    existNumbers.add(current);
                    queue.offer(current);
                }
            }
            n--;
            answ=queue.poll();
        }
        return (int)answ;
    }
}
