package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution647 {

    @Test
    public void test()
    {
        String s="aaa";
        int i = countSubstrings(s);
        System.out.println(i);
    }

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int answ=0;
        for (int i = 0; i < chars.length; i++) {
            //中间点要不然是当前点，要不然就是当前点+1
            if (i!=chars.length-1)
            {
                answ+=getPalindromeCount(i,i,chars);
                answ+=getPalindromeCount(i,i+1,chars);
            }
            else
            {
                answ+=getPalindromeCount(i,i,chars);
            }
        }
        return answ;
    }

    private int getPalindromeCount(int left, int right, char[] chars) {
        int count=0;
        while (left>=0&&right<=chars.length-1)
        {
            if (chars[left]==chars[right])
            {
                count++;
                left--;
                right++;
            }
            else
            {
                break;
            }
        }
        return count;
    }
}
