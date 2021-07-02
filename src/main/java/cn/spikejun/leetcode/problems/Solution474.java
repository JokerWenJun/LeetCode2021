package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution474 {

    @Test
    public void  test()
    {
        String[]strs=new String[]{"10", "0001", "111001", "1", "0"};
        int m=5;
        int n=3;
        int maxForm = findMaxForm(strs, m, n);
        System.out.println(maxForm);
    }

    //m为最大0的个数；n为最大1的个数
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][]dp=new int[length+1][m+1][n+1];
        for (int i = 1; i <= length; i++) {
            String s=strs[i-1];
            int countZeros=0;
            int countOnes=0;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar=='0')
                {
                    countZeros++;
                }
                else
                {
                    countOnes++;
                }
            }
            //循环0的个数
            for (int j = 0; j <= m; j++) {
                //循环1的个数
                for (int k = 0; k <=n; k++) {
                    if (countZeros>j||countOnes>k)
                    {
                        dp[i][j][k]=dp[i-1][j][k];
                    }
                    //如果当前的字符串的0和1的个数都小于指定的m和n，那么就有两种选择，一种是选择这个字符串一种是不选这个字符串
                    else
                    {
                        int noSelectCurrentString=dp[i-1][j][k];
                        int selectCurrentString=dp[i-1][j-countZeros][k-countOnes]+1;
                        dp[i][j][k]=Math.max(noSelectCurrentString,selectCurrentString);
                    }
                }
            }
        }
        int answ=dp[strs.length][m][n];
        return answ;
    }


}
