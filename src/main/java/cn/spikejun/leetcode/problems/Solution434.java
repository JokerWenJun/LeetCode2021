package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution434 {

    @Test
    public void test()
    {

        String s=", , , ,        a, eaefa";
        int i = countSegments(s);
        System.out.println(i);
    }

    public int countSegments(String s) {
        if (s==null||s.equals(""))
        {
            return 0;
        }
        String[] sps = s.split(" ");
        int index=0;
        for (String sp : sps) {
            if (!sp.equals(""))
            {
                index++;
            }
        }
        return index;
    }
}
