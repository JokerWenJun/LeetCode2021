package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution134 {


    @Test
    public void test()
    {
        int[]gas=new int[]{2,3,4};
        int[]cost=new int[]{3,4,3};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int leftGas=0;
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int start=gas[i]-cost[i];
            if (start<0)
            {
                continue;
            }
            int j=(i+1)%length;
            leftGas=start;
            while (i!=j)
            {
                int current=gas[j]-cost[j];
                leftGas+=current;
                if (leftGas<0)
                {
                    break;
                }
                else
                {
                   j=(j+1)%length;
                }
            }
            if (j<i)
            {
                return -1;
            }
            if (j==i)
            {
                return i;
            }
            i=j;
        }
        return -1;
    }


}
