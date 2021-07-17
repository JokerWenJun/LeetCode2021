package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution38 {

    @Test
    public void test()
    {
        String s = countAndSay(5);
        System.out.println(s);
    }


    public String countAndSay(int n) {
        String[]dp=new String[n];
        dp[0]="1";
        for (int i = 1; i < dp.length; i++) {
            String s=dp[i-1];
            char[] chars = s.toCharArray();
            StringBuffer stringBuffer=new StringBuffer();
            char preChar=chars[0];
            int count=1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j]!=preChar)
                {
                    stringBuffer.append(count+""+preChar);
                    preChar=chars[j];
                    count=1;
                }
                else {
                    count++;
                }
            }
            stringBuffer.append(count+""+preChar);
            dp[i]=stringBuffer.toString();
        }
        return dp[n-1];
    }
}
