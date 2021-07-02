package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1833 {

    @Test
    public void test()
    {
        int[]cost=new int[]{1,3,2,4,1};
        int i = maxIceCream1(cost, 7);
        System.out.println(i);
    }
    public int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        for (int i = 0; i < costs.length; i++) {
            if (coins-costs[i]<0)
            {
                break;
            }
            else {
                count++;
                coins=coins-costs[i];
            }
        }
        return count;
    }



    public int maxIceCream(int[] costs, int coins) {
        int icecreamSize=costs.length;
        //创建动态dp
        int[][]dp=new int[icecreamSize+1][coins+1];
        int[]dp1=new int[coins+1];
        for (int i = 1; i <= icecreamSize; i++) {
            for (int j = coins; j >= 0; j--) {
                if (j>=costs[i-1])
                {
                    dp1[j]=Math.max(dp1[j],1+dp1[j-costs[i-1]]);
                }
                else
                {
                    dp1[j]=dp1[j];
                }
            }
        }
        int answ=dp1[coins];



//        for (int i = 1; i <= icecreamSize; i++) {
//            for (int j = 0; j <= coins; j++) {
//                if (j>=costs[i-1])
//                {
//                    dp[i][j]=Math.max(dp[i-1][j],1+dp[i-1][j-costs[i-1]]);
//                }
//                else
//                {
//                    dp[i][j]=dp[i-1][j];
//                }
//            }
//        }
//        int answ=dp[icecreamSize][coins];
        return answ;
    }
}
