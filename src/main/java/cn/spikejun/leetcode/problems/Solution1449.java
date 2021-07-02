package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1449 {

    @Test
    public void test()
    {
        String s1="12";
        String s2="70";
        System.out.println(s2.compareTo(s1));
        int[]cost=new int[]{7,6,5,5,5,6,8,7,8};
        String s = largestNumber(cost, 12);
        System.out.println(s);


    }


    public String largestNumber(int[] cost, int target) {
        int size=cost.length;
        String[][]dp=new String[size+1][target+1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]="#";
        }
        dp[0][0]="";
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j <= target; j++) {
                if (j<cost[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    if (dp[i][j-cost[i-1]].equals("#"))
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                    else
                    {
                        String notChoseI=dp[i-1][j];
                        String choseI=i+""+dp[i][j-cost[i-1]];
                        String currentAnsw=compareString(notChoseI,choseI);
                        dp[i][j]=currentAnsw;
                    }
                }
            }
        }
        if (dp[size][target].equals("#"))
        {
            return "0";
        }
        return dp[size][target];
    }
    private String compareString(String s1,String s2)
    {
        if (s1.length()>s2.length())
        {
            return s1;
        }
        else if (s2.length()>s1.length())
        {
            return s2;
        }
        else
        {
            if (s1.compareTo(s2)>=0)
            {
                return s1;
            }
            else
            {
                return s2;
            }
        }
    }
}
