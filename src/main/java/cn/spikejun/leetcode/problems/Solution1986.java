package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1986 {


    @Test
    public void test()
    {
        int[]arr=new int[]{1,2,3};
        int i = minSessions(arr, 3);
        System.out.println(i);

    }

    public int minSessions(int[] tasks, int sessionTime) {
        int n=tasks.length;
        int m=1<<n;
        int[]dp=new int[m];
        Arrays.fill(dp,20);
        for (int i = 1; i < m; i++) {
            int index=0;
            int currentValue=i;
            int cost=0;
            while (currentValue>0)
            {
                int eachBit=currentValue&1;
                if (eachBit==1)
                {
                    cost=cost+tasks[index];
                }
                currentValue>>=1;
                index++;
            }
            if (cost<=sessionTime)
            {
                dp[i]=1;
            }
        }
        for (int i = 1; i < m; i++) {
            if (dp[i]==1)
            {
                continue;
            }
            for (int j = 1; j <=i; j++) {
                if ((i|j)==i)
                {
                    dp[i]=Math.min(dp[i],dp[j]+dp[i^j]);
                }
            }
        }
        return dp[m-1];
    }
}
