package cn.spikejun.leetcode.problems;

public class Solution921 {

    public int minAddToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int leftCount=0;
        int rightCount=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(')
            {
                leftCount++;
            }
            else
            {
                if (leftCount>0)
                {
                    leftCount--;
                }
                else
                {
                    rightCount++;
                }
            }
        }
        return leftCount+rightCount;
    }
}
