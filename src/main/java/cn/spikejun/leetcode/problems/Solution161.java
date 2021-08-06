package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution161 {

    @Test
    public void test()
    {
        String s="acbbcda";
        String t="abbdad";
        isOneEditDistance(s,t);
    }


    public boolean isOneEditDistance(String s, String t) {
        if (s.equals("")&&t.equals(""))
        {
            return false;
        }
        int sLength = s.length();
        int tLength=t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        //其实很简单，就三种情况，相等，s=t+1,s=t-1
        if (sLength==tLength)
        {
            int count=0;
            for (int i = 0; i < sChars.length; i++) {
                if (sChars[i]!=tChars[i])
                {
                    if (count>1)
                    {
                        return false;
                    }
                    else
                    {
                        count++;
                    }
                }
            }
            if (count==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        if (sLength<tLength)
        {
            if (sLength+1!=tLength)
            {
                return false;
            }
            int count=0;
            int i=0;
            int j=0;
            while (i<sLength&&j<tLength)
            {
                if (sChars[i]!=tChars[j])
                {
                    if (count>0)
                    {
                        return false;
                    }
                    else
                    {
                        count++;
                        j++;
                    }
                }
                else
                {
                    i++;
                    j++;
                }
            }
            return true;
        }
        if (sLength>tLength)
        {
            if (tLength+1!=sLength)
            {
                return false;
            }
            int count=0;
            int i=0;
            int j=0;
            while (i<sLength&&j<tLength)
            {
                if (sChars[i]!=tChars[j])
                {
                    if (count>0)
                    {
                        return false;
                    }
                    else
                    {
                        count++;
                        i++;
                    }
                }
                else
                {
                    i++;
                    j++;
                }
            }
            return true;
        }
        return false;
    }
}
