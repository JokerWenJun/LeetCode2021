package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution121 {

    @Test
    public void test(){
        int[] prices=new int[]{7,6,5,4,3,2};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        if (prices.length==1)
        {
            return 0;
        }
        int min=prices[0];
        int answ=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<min)
            {
                min=prices[i];
            }
            else
            {
                int profit=prices[i]-min;
                if (profit>answ)
                {
                    answ=profit;
                }
            }

        }
        return answ;
    }

}
