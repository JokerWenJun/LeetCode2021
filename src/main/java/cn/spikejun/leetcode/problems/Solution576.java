package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution576 {

    @Test
    public void test()
    {
        int paths = findPaths(1, 3, 3, 0, 1);
        System.out.println(paths);
    }


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][]directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int mod= (int) (Math.pow(10,9)+7);
        //[k][i][j]->移动了k步到达i，j的总路径数
        int[][][]dp=new int[maxMove+1][m][n];
        dp[0][startRow][startColumn]=1;
        int answ=0;
        for (int k = 0; k < maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[k][i][j]>0)
                    {
                        for (int[] direction : directions) {
                            int nextRow=direction[0]+i;
                            int nextCol=direction[1]+j;
                            if (nextRow>=0&&nextRow<m&&nextCol>=0&&nextCol<n)
                            {
                                dp[k+1][nextRow][nextCol]=(dp[k+1][nextRow][nextCol]+dp[k][i][j])%mod;
                            }
                            else
                            {
                                answ=(answ+dp[k][i][j])%mod;
                            }
                        }
                    }
                }
            }
        }
        return answ;
    }
}
