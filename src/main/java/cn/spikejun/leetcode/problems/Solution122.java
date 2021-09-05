package cn.spikejun.leetcode.problems;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int answ=0;
        for (int i = 1; i < prices.length; i++) {
            int count=Math.max(0,prices[i]-prices[i-1]);
            answ+=count;
        }
        return answ;
    }
}
