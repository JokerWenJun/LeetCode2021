package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5863 {


    @Test
    public void test()
    {
        int[]arr=new int[]{3,3,6,4,5};
        System.out.println(firstDayBeenInAllRooms(arr));
    }
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        long[] dp = new long[nextVisit.length+1];
        int mod = 1000000007;
        for (int i = 0; i < nextVisit.length; i++) {

            if (nextVisit[i] == i) {
                dp[i+1] = (dp[i] + 2+mod) % mod;
            } else {
                dp[i+1] = (2 * dp[i] - dp[nextVisit[i]] + 2+mod ) % mod;
            }
        }
        return (int)dp[dp.length-2];
    }
}
