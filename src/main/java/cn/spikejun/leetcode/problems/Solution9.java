package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution9 {

    @Test
    public void test()
    {
        int x=121;
        boolean palindrome = isPalindrome(x);
        System.out.println(palindrome);
    }


    public boolean isPalindrome(int x) {
        String s=x+"";
        if (s.charAt(0)=='-'||s.charAt(0)=='+')
        {
            return false;
        }
        StringBuffer stringBuffer=new StringBuffer(s);
        String s1 = stringBuffer.reverse().toString();
        if (s1.equals(s))
        {
            return true;
        }
        return false;
    }
}
