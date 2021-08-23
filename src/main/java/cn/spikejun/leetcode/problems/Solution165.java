package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution165 {

    @Test
    public void test()
    {
        String s1="1.01";
        String s2="1.001";
        int i = compareVersion(s1, s2);

    }


    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("[.]");
        String[] split2 = version2.split("[.]");
        int length1=split1.length;
        int length2=split2.length;
        int length;
        if (length1>=length2)
        {
            length=length1;
        }
        else {
            length=length2;
        }
        for (int i = 0; i < length; i++) {
            String value1;
            String value2;
            if (i>=length1)
            {
                value1="0";
            }
            else {
                value1=split1[i];
            }
            if (i>=length2)
            {
                value2="0";
            }
            else {
                value2=split2[i];
            }

            //compare the value1 and value2
            if (Integer.valueOf(value1)>Integer.valueOf(value2))
            {
                return 1;
            }
            if (Integer.valueOf(value1)<Integer.valueOf(value2))
            {
                return -1;
            }
        }
        return 0;
    }

}
