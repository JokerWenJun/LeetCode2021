package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution171 {


    @Test
    public void test()
    {
        int fxshrxw = titleToNumber("FXSHRXW");
        System.out.println(fxshrxw);
    }
    public int titleToNumber(String columnTitle) {
        int answ=0;
        char[] chars = columnTitle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            answ=answ*26+chars[i]-'A'+1;
        }
        return answ;
    }
}
