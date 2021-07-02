package cn.spikejun.leetcode.problems;

import org.junit.Test;

import javax.swing.text.StyledEditorKit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {


    @Test
    public void test()
    {
        String s="leetcode";
        String[]wordDict=new String[]{"leet","code"};
//        System.out.println(s.substring(0,1));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>wordSet=new HashSet<>(wordDict);
        boolean[]dp=new boolean[s.length()+1];
        dp[0]=true;
        char[] chars = s.toCharArray();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
