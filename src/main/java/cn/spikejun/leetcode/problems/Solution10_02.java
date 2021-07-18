package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution10_02 {

    @Test
    public void test()
    {
        String[]str=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(str);
        System.out.println("!!!!");
    }



    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String currentStr = strs[i];
            char[] currentStrArray = currentStr.toCharArray();
            Arrays.sort(currentStrArray);
            String sortCurrentStr=String.valueOf(currentStrArray);
            List<String> list = map.getOrDefault(sortCurrentStr, new ArrayList<>());
            list.add(currentStr);
            map.put(sortCurrentStr,list);
        }
        List<List<String>>answ=new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            List<String> stringList = map.get(string);
            answ.add(stringList);
        }
        return answ;
    }
}
