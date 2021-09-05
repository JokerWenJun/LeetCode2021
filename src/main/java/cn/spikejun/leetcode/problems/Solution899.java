package cn.spikejun.leetcode.problems;

import java.util.Arrays;

public class Solution899 {

    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if (k==1)
        {
            String answ=null;
            for (int i = 0; i < chars.length; i++) {
                String current=s.substring(i)+s.substring(0,i);
                if(answ!=null&&current.compareTo(answ)<0)
                {
                    answ=current;
                }else if (answ==null)
                {
                    answ=current;
                }
            }
            return answ;
        }
        else
        {
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
}
