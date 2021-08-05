package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution249 {

    @Test
    public void test()
    {
        String[]s=new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> lists = groupStrings(s);
        System.out.println("!!!");
    }


    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>>map=new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String currentStr=strings[i];
            String changeStr=changeCurrentStrToFirstCharIsA(currentStr);
            if (map.containsKey(changeStr))
            {
                map.get(changeStr).add(currentStr);
            }
            else
            {
                List<String>list=new ArrayList<>();
                list.add(currentStr);
                map.put(changeStr,list);
            }
        }
        List<List<String>>answ=new ArrayList<>();
        Set<String> strings1 = map.keySet();
        for (String s : strings1) {
            answ.add(map.get(s));
        }
        return answ;
    }

    private String changeCurrentStrToFirstCharIsA(String currentStr) {
        char[] chars = currentStr.toCharArray();
        //判断首位移动到a需要多少步数
        char firstChar = chars[0];
        if (firstChar=='a')
        {
            return currentStr;
        }
        int step=25-(firstChar-'a')+1;
        StringBuffer buffer=new StringBuffer();
        buffer.append('a');
        for (int i = 1; i < chars.length; i++) {
            int k=(chars[i]-'a'+step)%26;
            char c=(char)(k+'a');
            buffer.append(c);
        }
        return buffer.toString();
    }
}
