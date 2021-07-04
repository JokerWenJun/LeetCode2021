package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution5801 {

    @Test
    public void test()
    {
        int[]dist=new int[]{4,2,3};
        int[]speed=new int[]{2,1,1};
        int i = eliminateMaximum(dist, speed);
        System.out.println(i);
    }


    public int eliminateMaximum(int[] dist, int[] speed) {
        int []times=new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            double time=(double)(dist[i]-1)/(double)speed[i];
            double ceil = Math.floor(time);
            times[i]= (int) ceil;
        }
        int count=0;
        Arrays.sort(times);
        int preNum=times[0];
        for (int i = 0; i < times.length; i++) {
            if (i<=times[i])
            {
                count++;
            }
            else
            {
                return count;
            }

        }
        return count;
    }
}
