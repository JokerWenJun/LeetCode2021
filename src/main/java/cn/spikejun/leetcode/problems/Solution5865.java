package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5865 {

    @Test
    public void test()
    {
        int[]next=new int[]{0,1,2,0};
        int i = firstDayBeenInAllRooms(next);
        System.out.println(i);
    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod= (int) (Math.pow(10,9)+7);
        int length=nextVisit.length;
        int days=0;
        boolean[]visited=new boolean[nextVisit.length];
        int[]visitedNum=new int[nextVisit.length];
        int size=visited.length;
        int currentLocation=0;
        while (size!=0)
        {
            visitedNum[currentLocation]++;
            if ((visitedNum[currentLocation])%2==0)
            {
                currentLocation=(currentLocation+1)%length;
            }
            else
            {
                currentLocation=nextVisit[currentLocation];
            }
            if (visited[currentLocation]==false)
            {
                visited[currentLocation]=true;
                size--;
            }
            days++;
            days%=mod;
        }
        return days;
    }

}
