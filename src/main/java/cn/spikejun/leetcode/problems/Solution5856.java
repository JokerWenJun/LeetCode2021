package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution5856 {

    @Test
    public void test()
    {
        int[]arr=new int[]{2,3,3,4,4,4,5,6,7,10};
        int i = minSessions(arr, 12);
        System.out.println(i);
    }


    public int minSessions(int[] tasks, int sessionTime) {
        List<Integer>list=new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            list.add(tasks[i]);
        }
        Collections.sort(list);
        int count=0;
        while (!list.isEmpty())
        {
            count++;
            int[][]dp=new int[list.size()+1][sessionTime+1];
            boolean[][]bl=new boolean[list.size()+1][sessionTime+1];
            for (int i = 1; i <=list.size(); i++) {
                for (int j = 1; j <=sessionTime; j++) {
                    if (j>=list.get(i-1))
                    {
                        if (dp[i-1][j-list.get(i-1)]+list.get(i-1)>dp[i-1][j])
                        {
                             dp[i][j]=dp[i-1][j-list.get(i-1)]+list.get(i-1);
                             bl[i][j]=true;
                        }
                        else
                        {
                            dp[i][j]=dp[i-1][j];
                        }
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                        bl[i][j]=false;
                    }
                }
            }
            int index= dp.length-1;
            int currentSum=sessionTime;
            while (index>0)
            {
                if (bl[index][currentSum]==true)
                {
                    currentSum-=list.get(index-1);
                    list.set(index-1,-1);
                    index--;
                }
                else
                {
                    index--;
                }
            }
            List<Integer>temp=new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)!=-1)
                {
                    temp.add(list.get(i));
                }
            }
            list=temp;
        }
        return count;
    }

}
