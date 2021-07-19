package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {

    @Test
    public void test()
    {
        String s="cbaebabacd";
        String p="abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println("!!!");

    }


    public List<Integer> findAnagrams(String s, String p) {
        char[] chars = p.toCharArray();
        int[]targetStringEachCharNumber=new int[26];
        for (int i = 0; i < chars.length; i++) {
            targetStringEachCharNumber[chars[i]-'a']++;
        }
        int targetStringLength=p.length();
        char[] originalCharArray = s.toCharArray();
        int[] originalStringEachCharNumber=new int[26];
        List<Integer>answ=new ArrayList<>();
        if (targetStringLength>originalCharArray.length)
        {
            return answ;
        }


        for (int i = 0; i < targetStringLength-1; i++) {
            originalStringEachCharNumber[originalCharArray[i]-'a']++;
        }
        for (int i = targetStringLength-1; i < originalCharArray.length; i++) {
            originalStringEachCharNumber[originalCharArray[i]-'a']++;
            int beginIndex=i-targetStringLength+1;
            if (Arrays.equals(originalStringEachCharNumber,targetStringEachCharNumber))
            {
                answ.add(beginIndex);
            }
            originalStringEachCharNumber[originalCharArray[beginIndex]-'a']--;
        }
        return answ;
    }
}
