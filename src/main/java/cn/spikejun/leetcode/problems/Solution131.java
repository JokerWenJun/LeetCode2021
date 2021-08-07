package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution131 {

    private List<List<String>>answ=new ArrayList<>();
    private List<String>route=new ArrayList<>();
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        //首先创建dp数组
        boolean[][]dp=new boolean[chars.length][chars.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],true);
        }
        for (int i = chars.length-1; i>=0;i--) {
            for (int j = i+1; j<chars.length; j++) {
                dp[i][j]=chars[i]==chars[j]&&dp[i+1][j-1];
            }
        }
        dfs(0,chars.length,dp,chars,s);
        return answ;
    }

    private void dfs(int i, int length, boolean[][] dp, char[] chars,String stirng) {
        if (i>=length)
        {
            answ.add(new ArrayList<>(route));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            if (dp[i][j])
            {
                route.add(stirng.substring(i,j+1));
                dfs(j+1,length,dp,chars,stirng);
                route.remove(route.size()-1);
            }
        }
    }
}
