package cn.spikejun.leetcode.problems;

import java.lang.reflect.Array;
import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            char[] clone = chars.clone();
            Arrays.sort(clone);
            String s = String.valueOf(clone);
            if (map.containsKey(s))
            {
                map.get(s).add(String.valueOf(chars));
            }
            else
            {
                List<String>list=new ArrayList<>();
                list.add(String.valueOf(chars));
                map.put(s,list);
            }
        }
        List<List<String>>answ=new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            answ.add(map.get(string));
        }
        return answ;
    }
}
