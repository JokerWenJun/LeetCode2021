package cn.spikejun.leetcode.problems;

public class Solution552 {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        //创建dp
        //前n天
        //出现了几个A
        //结尾连续了几个L
        int[][][]dp=new int[n+1][2][3];
        //初始化状态。首先当n=0是A=0 L=0是为1,其余都为0
        dp[0][0][0]=1;
        //循环天数
        for (int i = 1; i <=n; i++) {
            //如果当前为P
            for (int j = 0; j <=1; j++) {
                for (int k=0;k<=2;k++)
                {
                    dp[i][j][0]=(dp[i][j][0]+dp[i-1][j][k])%MOD;
                }
            }
            //如果当前为A
            for (int k=0;k<=2;k++)
            {
                dp[i][1][0]=(dp[i][1][0]+dp[i-1][0][k])%MOD;
            }
            //如果当前天为L
            for (int j=0;j<=1;j++)
            {
                for (int k=1;k<=2;k++)
                {
                    dp[i][j][k]=(dp[i][j][k]+dp[i-1][j][k-1])%MOD;
                }
            }
        }

        int answ=0;
        for (int i=0;i<=1;i++)
        {
            for (int j=0;j<=2;j++)
            {
                answ=(answ+dp[n][i][j])%MOD;
            }
        }
        return answ;
    }
}
