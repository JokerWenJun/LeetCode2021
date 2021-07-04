package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution790 {

    @Test
    public void test()
    {
        int i = numTilings(30);
        System.out.println(i);
    }


    public int numTilings(int n) {
        //创建mod
        int mod= 1000000007;
        //创建dp
        long[][]dp=new long[n+1][3];
        //0:当前列都满
        //1:当前列缺下面
        //2:当前列缺上面
        dp[0][0]=1;
        dp[0][1]=0;
        dp[0][2]=0;
        for (int i = 1; i <=n; i++) {
            dp[i][0]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
            if (i>=2)
            {
                dp[i][0]+=dp[i-2][0];
            }
            dp[i][0]=dp[i][0]%mod;

            dp[i][1]=dp[i-1][2];
            if(i>=2)
            {
                dp[i][1]+=dp[i-2][0];
            }
            dp[i][1]=dp[i][1]%mod;

            dp[i][2]=dp[i-1][1];
            if(i>=2)
            {
                dp[i][2]+=dp[i-2][0];
            }
            dp[i][2]=dp[i][2]%mod;
        }
        int answ= (int) dp[n][0];

        return answ;
    }


    public int numTilings1(int N) {
        int MOD = 1_000_000_007;
        long[] dp = new long[]{1, 0, 0, 0};
        for (int i = 0; i < N; ++i) {
            long[] ndp = new long[4];
            ndp[0b00] = (dp[0b00] + dp[0b11]) % MOD;
            ndp[0b01] = (dp[0b00] + dp[0b10]) % MOD;
            ndp[0b10] = (dp[0b00] + dp[0b01]) % MOD;
            ndp[0b11] = (dp[0b00] + dp[0b01] + dp[0b10]) % MOD;
            dp = ndp;
        }
        return (int) dp[0];
    }


}
