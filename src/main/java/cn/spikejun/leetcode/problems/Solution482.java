package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution482 {

    @Test
    public void test()
    {
        String s="2-5g-3-J";
        String s1 = licenseKeyFormatting(s, 2);
        System.out.println(s1);
    }

    public String licenseKeyFormatting(String s, int k) {
        s= s.replaceAll("-", "");
        Deque<String>deque=new ArrayDeque<>();
        int count=s.length()/k;
        int i=s.length()-1;
        for (i=s.length()-1;i-k+1>=0;i-=k)
        {
            String substring = s.substring(i - k + 1, i + 1);
            deque.addFirst(substring);
        }
        if (i>=0)
        {
            String substring = s.substring(0, i+ 1);
            deque.addFirst(substring);
        }

        StringBuffer buffer=new StringBuffer();
        if (deque.size()!=0)
        {
            buffer.append(deque.pollFirst().toUpperCase());
        }
        int size = deque.size();
        for (int j = 0; j < size; j++) {
            buffer.append('-');
            buffer.append(deque.pollFirst().toUpperCase());
        }
        return buffer.toString();
    }
}
