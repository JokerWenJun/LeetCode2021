package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String>list=new ArrayList<>();
        char[] chars = s.toCharArray();
        if (chars.length<10)
        {
            return list;
        }
        int left=0;
        int right=9;
        Set<String>set=new HashSet<>();
        Set<String>answ=new HashSet<>();
        while (right<chars.length)
        {
            String substring = s.substring(left, right + 1);
            if (set.contains(substring))
            {
                answ.add(substring);
            }
            else
            {
                set.add(substring);
            }
            left++;
            right++;
        }
        for (String s1 : answ) {
            list.add(s1);
        }
        return list;
    }
}
