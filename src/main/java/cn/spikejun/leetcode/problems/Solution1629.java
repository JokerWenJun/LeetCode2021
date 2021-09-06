package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1629 {

    @Test
    public void test()
    {

    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Character answChar=keysPressed.charAt(0);
        int max=releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i]-releaseTimes[i-1]>max)
            {
                answChar=keysPressed.charAt(i);
                max=releaseTimes[i]-releaseTimes[i-1];
            }else if (releaseTimes[i]-releaseTimes[i-1]==max&&keysPressed.charAt(i)>answChar)
            {
                answChar=keysPressed.charAt(i);
            }
        }
        return answChar;

    }
}
