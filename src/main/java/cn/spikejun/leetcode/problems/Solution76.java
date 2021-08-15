package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution76 {

    @Test
    public void test()
    {
        String s="ADOBECODEBANC";
        String t="ABC";
        String s1 = minWindow(s, t);

        System.out.println(s1);
    }


    private Map<Character,Integer>tMap;
    public String minWindow(String s, String t) {
        int minLength=Integer.MAX_VALUE;
        char[] chars = t.toCharArray();
        this.tMap=new HashMap<>();
        for (char aChar : chars) {
            tMap.put(aChar,tMap.getOrDefault(aChar,0)+1);
        }
        Map<Character,Integer>sMap=new HashMap<>();
        char[] sChars = s.toCharArray();
        int i=0;
        int j=0;
        int minLeft=-1;
        int minRight=-1;
        while (i<=j&&i<sChars.length&&j<sChars.length)
        {
            while (i<=j&&i<sChars.length&&j<sChars.length)
            {
                sMap.put(sChars[j],sMap.getOrDefault(sChars[j],0)+1);
                if (checkSisContainT(sMap))
                {
                    if (j-i+1<minLength)
                    {
                        minLength=j-i+1;
                        minLeft=i;
                        minRight=j;
                    }
                    break;
                }
                else
                {
                    j++;
                }
            }
            while (i<=j&&i<sChars.length&&j<sChars.length)
            {
                if (checkSisContainT(sMap))
                {
                    if (j-i+1<minLength)
                    {
                        minLength=j-i+1;
                        minLeft=i;
                        minRight=j;
                    }
                    Integer leftCharCount = sMap.get(sChars[i]);
                    if (leftCharCount-1==0)
                    {
                        sMap.remove(sChars[i]);
                    }
                    else
                    {
                        sMap.put(sChars[i],leftCharCount-1);
                    }
                    i++;
                }
                else
                {
                    break;
                }
            }
            j++;
        }
        if (minLeft==-1)
        {
            return "";
        }
        return s.substring(minLeft,minRight+1);
    }

     private boolean checkSisContainT(Map<Character,Integer> s)
     {
         Set<Character> tCharacters = tMap.keySet();
         for (Character tCharacter : tCharacters) {
             Integer tInteger = tMap.get(tCharacter);
             Integer sInteger = s.getOrDefault(tCharacter, 0);
             if (sInteger<tInteger)
             {
                 return false;
             }
         }
         return true;
     }
}
