package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution1473 {
    /**
     * [0,2,1,2,0]
     * [[1,10],[10,1],[10,1],[1,10],[5,1]]
     * 5
     * 2
     * 3
     */
    @Test
    public void test()
    {
//        StringBuffer stringBuffer1=new StringBuffer();
//        stringBuffer1.append("123");
//        StringBuffer stringBuffer2=new StringBuffer();
//        stringBuffer2.append("1");
            List<Integer>list=new ArrayList<>();
            list.add(null);
            list.add(null);
            System.out.println(list.size());




//        int[]house=new int[]{0,2,1,2,0};
//        int [][]cost=new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}};
//        int m=5;
//        int n=2;
//        int target=3;
//        int i = minCost(house, cost, m, n, target);
//        System.out.println(i);
    }


    private int minValue=0x3f3f3f3f;
    //m个房子，n种颜色
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        //创建dp数组
        int[][][]dp=new int[m+1][n+1][target+1];
        //初始化
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] =minValue ;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    if (k>i)
                    {
                        dp[i][j][k]=minValue;
                        continue;
                    }
                    //涂了颜色
                    if (houses[i-1]!=0)
                    {
                        int color=houses[i-1];
                        if (color==j)
                        {
                            int current=minValue;
                            //上一层的颜色进行遍历
                            for (int p = 1; p <=n; p++) {
                                //前一层颜色与当前相同
                                if (p==color)
                                {
                                    current=Math.min(current,dp[i-1][p][k]);
                                }
                                //前一层颜色与当前不同
                                else
                                {
                                    current=Math.min(current,dp[i-1][p][k-1]);
                                }
                            }
                            dp[i][j][k]=current;
                        }
                        else
                        {
                            dp[i][j][k]=minValue;
                        }
                    }
                    //没有涂色
                    else
                    {
                        int color=j;
                        int current=minValue;
                        //上一层层的颜色进行遍历
                        for (int p = 1; p <=n; p++) {
                            //前一层颜色与当前相同
                            if (p==color)
                            {
                                current=Math.min(current,dp[i-1][p][k]+cost[i-1][j-1]);
                            }
                            //前一层颜色与当前不同
                            else
                            {
                                current=Math.min(current,dp[i-1][p][k-1]+cost[i-1][j-1]);
                            }
                        }
                        dp[i][j][k]=current;
                    }
                }
            }
        }


        //当层数为i=m//k=target时
        int answ=minValue;
        for (int i = 1; i <= n; i++) {
            answ=Math.min(dp[m][i][target],answ);
        }
        return answ==minValue?-1:answ;
    }


}
