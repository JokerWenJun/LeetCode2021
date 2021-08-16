package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution159 {

    @Test
    public void test()
    {
        String s="ccaabbb";
        int i = lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(i);
    }


    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer>currentStrEachCharCount=new HashMap<>();
        char[] chars = s.toCharArray();
        if (chars.length<=2)
        {
            return chars.length;
        }
        int maxLength=2;
        int left=0;
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            currentStrEachCharCount.put(currentChar,currentStrEachCharCount.getOrDefault(currentChar,0)+1);
            while (currentStrEachCharCount.size()>2)
            {
                Integer value = currentStrEachCharCount.get(chars[left]);
                value--;
                if (value==0)
                {
                    currentStrEachCharCount.remove(chars[left]);
                }
                else
                {
                    currentStrEachCharCount.put(chars[left],value);
                }
                left++;
            }
            maxLength=Math.max(maxLength,i-left+1);
        }
        return maxLength;
    }
}
