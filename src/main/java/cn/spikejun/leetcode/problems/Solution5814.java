package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5814 {

    @Test
    public void test()
    {
        int[]rung=new int[]{3,4,6,7};
        int i = addRungs(rung, 2);
        System.out.println(i);
    }



    public int addRungs(int[] rungs, int dist) {
        int length = rungs.length;
        int[]dp=new int[length+1];
        for (int i = 0; i < rungs.length; i++) {
            if (i==0)
            {
                if ((rungs[i]-0)%dist==0)
                {
                    dp[i+1]=(rungs[i]-0)/dist-1;
                }
                else
                {
                    dp[i+1]=(rungs[i]-0)/dist;
                }
            }
            else
            {
                if ((rungs[i]-rungs[i-1])%dist==0)
                {
                    dp[i+1]=(rungs[i]-rungs[i-1])/dist-1+dp[i];
                }
                else
                {
                    dp[i+1]=(rungs[i]-rungs[i-1])/dist+dp[i];
                }
            }

        }
        return dp[dp.length-1];
    }
}
