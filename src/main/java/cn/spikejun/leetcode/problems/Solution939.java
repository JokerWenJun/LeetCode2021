package cn.spikejun.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Solution939 {
    public int mincostTickets(int[] days, int[] costs) {
        int[]dp=new int[365+30];
        Set<Integer> set=new HashSet<>();
        for (int day : days) {
            set.add(day-1);
        }
        for (int i = 364; i>=0; i--) {
            if (!set.contains(i))
            {
                dp[i]=dp[i+1];
            }
            else
            {
                dp[i]=Math.min(costs[0]+dp[i+1],costs[1]+dp[i+7]);
                dp[i]=Math.min(dp[i],costs[2]+dp[i+30]);
            }
        }
        return dp[0];
    }
}
