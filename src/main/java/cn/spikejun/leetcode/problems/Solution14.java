package cn.spikejun.leetcode.problems;

public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        int length=strs[0].length();
        int i=0;
        StringBuffer buffer=new StringBuffer();
        while (i<length)
        {
            char originalChar=strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length()<=i)
                {
                    return buffer.toString();
                }
                if (strs[j].charAt(i)!=originalChar)
                {
                    return buffer.toString();
                }
            }
            buffer.append(originalChar);
            i++;
        }
        return buffer.toString();
    }
}
