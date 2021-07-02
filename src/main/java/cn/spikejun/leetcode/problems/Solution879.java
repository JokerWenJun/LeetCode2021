package cn.spikejun.leetcode.problems;

import org.junit.Test;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class Solution879 {

    @Test
    public void test()
    {
        int n=5;
        int minProfit=3;
        int[]group=new int[]{2,2};
        int[]profit=new int[]{2,3};
        int i = profitableSchemes(n, minProfit, group, profit);
        System.out.println(i);
    }


    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int)1e9+7;
        int missionSize=group.length;
        int membersSize=n;
        int[][][]dp=new int[missionSize+1][n+1][minProfit+1];
        for (int i = 0; i <= membersSize; i++) {
            dp[0][i][0]=1;
        }
        for (int i = 1; i <=missionSize; i++) {
            for (int j = 0; j <= membersSize; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    int currentMissionPeople=group[i-1];
                    if (j<currentMissionPeople)
                    {
                        dp[i][j][k]=dp[i-1][j][k];
                    }
                    else
                    {
                        dp[i][j][k]=dp[i-1][j][k]+dp[i-1][j-group[i-1]][Math.max(0,k-profit[i-1])];
                    }
                    if (dp[i][j][k]>=mod)
                    {
                        dp[i][j][k]-=mod;
                    }
                }
            }
        }
        int answ=dp[missionSize][membersSize][minProfit];
        return answ;
    }
}
