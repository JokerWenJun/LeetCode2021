package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1109 {

    @Test
    public void test()
    {

    }


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]answ=new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] eachBook = bookings[i];
            int beginFlight = eachBook[0];
            int endFlight = eachBook[1];
            int addSeats = eachBook[2];
            for (int j = beginFlight; j <=endFlight; j++) {
                answ[j-1]+=addSeats;
            }
        }
        return answ;
    }

}
