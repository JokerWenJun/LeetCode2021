package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution205 {

    @Test
    public void test()
    {
        String s="foo";
        String t="bar";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }


    public boolean isIsomorphic(String s, String t) {
        //创建映射
        Map<Character,Character> map=new HashMap<>();
        char[] sToCharArray = s.toCharArray();
        char[] tToCharArray = t.toCharArray();
        Set<Character>exisDisplay=new HashSet<>();
        for (int i = 0; i < sToCharArray.length; i++) {
            char sChar = sToCharArray[i];
            char tChar = tToCharArray[i];
            Character character = map.get(sChar);
            if (character==null)
            {
                boolean contains = exisDisplay.contains(tChar);
                if (contains==true)
                {
                    return false;
                }
                map.put(sChar,tChar);
                exisDisplay.add(tChar);
            }
            else
            {
                if (character!=tChar)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
