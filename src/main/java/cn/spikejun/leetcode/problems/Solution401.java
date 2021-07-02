package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution401 {



    @Test
    public void test()
    {
//        int[]hours=new int[]{1,2,4,8};
//        int[]minutes=new int[]{1,2,4,8,16,32};
//        hoursList=new ArrayList<>();
//        minuteList=new ArrayList<>();
//        dfsHour(hours,1,0,0);
//        dfsMinute(minutes,5,0,0);
//        System.out.println("!!!");
        System.out.println(10/10);
        List<String> strings = readBinaryWatch(1);
        System.out.println("!!!");

    }

    private List<Integer>hoursList;
    private List<Integer>minuteList;
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn>=9)
        {
            return new ArrayList<String>();
        }
        int[]hours=new int[]{1,2,4,8};
        int[]minutes=new int[]{1,2,4,8,16,32};
        List<String>answ=new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            hoursList=new ArrayList<>();
            minuteList=new ArrayList<>();
            if (i>3)
            {
                break;
            }
            int minuteCount=turnedOn-i;
            int hourCount=i;
            dfsHour(hours,hourCount,0,0);
            dfsMinute(minutes,minuteCount,0,0);
            for (int j = 0; j < hoursList.size(); j++) {
                StringBuffer s=new StringBuffer();
                s.append( hoursList.get(j));
                s.append(":");
                for (int k = 0; k < minuteList.size(); k++) {
                    StringBuffer m=new StringBuffer();
                    if (minuteList.get(k)/10==0)
                    {
                        m.append("0"+ minuteList.get(k));
                    }
                    else
                    {
                        m.append( minuteList.get(k));
                    }
                    answ.add(s.toString()+m.toString());
                }
            }
        }
        return answ;
    }
    private void dfsMinute(int[] minutes, int minuteCount, int location,int count) {
        if (minuteCount==0)
        {
            minuteList.add(count);
            return;
        }
        for (int j = location; j < minutes.length; j++) {
            count+=minutes[j];
            if (count>59)
            {
                count-=minutes[j];
                break;
            }
            else
            {
                minuteCount--;
                dfsMinute(minutes,minuteCount,j+1,count);
            }
            count-= minutes[j];
            minuteCount++;
        }
    }
    private void dfsHour(int[] hours, int hourCount, int location,int count) {
        if (hourCount==0)
        {
            hoursList.add(count);
            return;
        }
        for (int j = location; j < hours.length; j++) {
            count+=hours[j];
            if (count>11)
            {
                count-=hours[j];
                break;
            }
            else
            {
                hourCount--;
                dfsHour(hours,hourCount,j+1,count);
            }
            count-= hours[j];
            hourCount++;
        }
    }


}
