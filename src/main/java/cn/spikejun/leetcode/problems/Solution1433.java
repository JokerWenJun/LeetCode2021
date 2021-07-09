package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1433 {

    @Test
    public void test()
    {
        String s1="szy";
        String s2="cid";
        boolean b = checkIfCanBreak(s1, s2);
        System.out.println(b);
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        boolean i1=true;
        for (int i = 0; i < charArray2.length; i++) {
            if (charArray2[i]<charArray1[i])
            {
                i1=false;
            }
        }
        boolean i2=true;
        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i]<charArray2[i])
            {
                i2=false;
            }
        }
        return i1||i2;
    }
}
