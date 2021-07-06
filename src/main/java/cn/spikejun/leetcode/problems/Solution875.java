package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution875 {

    @Test
    public void test()
    {
        int[]piles=new int[]{30,11,23,4,20};
        int i = minEatingSpeed(piles, 6);
        System.out.println(i);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;
        int maxSpeed=-1;
        for (int pile : piles) {
            maxSpeed=Math.max(maxSpeed,pile);
        }
        //最小速度->最大速度
        while (minSpeed<maxSpeed)
        {
            int midSpeed=minSpeed+(maxSpeed-minSpeed)/2;
            int currentHours=getHours(midSpeed,piles);
            if (currentHours>h)
            {
                minSpeed=midSpeed+1;
            }
            else
            {
                maxSpeed=midSpeed;
            }
        }
        return maxSpeed;
    }

    private int getHours(int speed, int[] piles) {
        int hour=0;
        int i=0;
        while (i<piles.length)
        {
            if (speed>=piles[i])
            {
                hour++;
                i++;
                continue;
            }
            else
            {
                if (piles[i]%speed==0)
                {
                    hour=hour+piles[i]/speed;
                }
                else
                {
                    hour=hour+piles[i]/speed+1;
                }
                i++;
                continue;
            }
        }
        return hour;
    }

}
