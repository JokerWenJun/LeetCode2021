package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5838 {


    @Test
    public void test()
    {
        String s="iloveleetcode";
        String[]strs=new String[]{"i","love","leetcode","apples"};
        boolean prefixString = isPrefixString(s, strs);
        System.out.println(prefixString);
    }


    public boolean isPrefixString(String s, String[] words) {
        StringBuffer buffer=new StringBuffer();
        int begin=0;
        for (int i = 0; i < words.length; i++) {
            buffer.append(words[i]);
            int length = words[i].length();
            if (s.length()-begin<length)
            {
                return false;
            }
            for (int j = 0; j < length; j++) {
                if (words[i].charAt(j)!=s.charAt(j+begin))
                {
                    return false;
                }
            }
            begin+=length;
            if (begin==s.length())
            {
                return true;
            }
        }
        return false;
    }
}
