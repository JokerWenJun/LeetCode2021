package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1235 {

    @Test
    public void test()
    {
        int[]start=new int[]{1,2,3,4,6};
        int[]end=new int[]{3,5,10,6,9};
        int[]profit=new int[]{20,20,100,70,60};
        int i = jobScheduling(start, end, profit);
        System.out.println(i);
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][]jobs=new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int[]dp=new int[jobs.length+1];
        for (int i = 0; i < jobs.length; i++) {
            int[] currentJob = jobs[i];
            int startJobTime=currentJob[0];
            int endJobTime=currentJob[1];
            int currentJobProfit=currentJob[2];
            int searchIndex=binarySearch(startJobTime,jobs);
            if (searchIndex==-1)
            {
                dp[i+1]=Math.max(currentJobProfit,dp[i]);
            }
            else
            {
                dp[i+1]=Math.max(currentJobProfit+dp[searchIndex+1],dp[i]);
            }
        }
        return dp[jobs.length];
    }

    private int binarySearch(int startJobTime, int[][] jobs) {
        int left=0;
        int right=jobs.length-1;
        if (startJobTime<jobs[0][1])
        {
            return -1;
        }
        if (startJobTime>jobs[jobs.length-1][1])
        {
            return jobs.length-1;
        }
        while (left<right)
        {
            int mid=left+(right-left)/2+1;
            if (jobs[mid][1]<=startJobTime)
            {
                left=mid;
            }
            else
            {
                right=mid-1;
            }
        }
        return left;
    }


}
