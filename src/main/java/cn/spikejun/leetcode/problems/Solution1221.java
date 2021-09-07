package cn.spikejun.leetcode.problems;

public class Solution1221 {

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int righCount=0;
        int leftCount=0;
        int answ=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='R')
            {
                if (leftCount>0)
                {
                    leftCount--;
                    if (leftCount==0)
                    {
                        answ++;
                    }
                }
                else {
                    righCount++;
                }
            }
            else {
                if (righCount>0)
                {
                    righCount--;
                    if (righCount==0)
                    {
                        answ++;
                    }
                }
                else {
                    leftCount++;
                }
            }
        }
        return answ;
    }

}
