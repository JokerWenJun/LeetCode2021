package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution681 {

    @Test
    public void test()
    {
        String s="19:34";
        String s1 = nextClosestTime(s);
        System.out.println(s1);
    }


    public String nextClosestTime(String time) {
        String[] split = time.split(":");
        Set<Character>set=new HashSet<>();
        String currentHour=split[0];
        set.add(currentHour.charAt(0));
        set.add(currentHour.charAt(1));
        String currentMin=split[1];
        set.add(currentMin.charAt(0));
        set.add(currentMin.charAt(1));
        int mins=Integer.valueOf(currentHour)*60+Integer.valueOf(currentMin);
        for (int i = mins+1; i <=(mins + 24 * 60); i++) {
            int nextMin=i;
            int nextHour=nextMin%(24*60)/60;
            int nextMins=nextMin%(24*60)%60;
            String nextHourStr=new String();
            String nextMinsStr=new String();
            if (nextHour<10)
            {
                nextHourStr+="0";
            }
            nextHourStr=nextHourStr+""+nextHour;
            if (nextMins<10)
            {
                nextMinsStr+="0";
            }
            nextMinsStr=nextMinsStr+""+nextMins;
            if (set.contains(nextHourStr.charAt(0))&&set.contains(nextHourStr.charAt(1))&&set.contains(nextMinsStr.charAt(0))&&set.contains(nextMinsStr.charAt(1)))
            {
                return nextHourStr+":"+nextMinsStr;
            }
        }
        return null;
    }
}
