package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution340 {

    @Test
    public void test()
    {
        String s="eceba";
        int i = lengthOfLongestSubstringKDistinct(s, 2);
        System.out.println(i);
    }


    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k==0)
        {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength=0;
        Map<Character,Integer>countEach=new HashMap<>();
        int left=0;
        int right=0;
        while (right<s.length())
        {
            char currentChar = chars[right];
            int size=countEach.size();
            if (!countEach.containsKey(currentChar))
            {
                size++;
                countEach.put(currentChar,1);
            }
            else
            {
                countEach.put(currentChar,countEach.get(currentChar)+1);
            }
            while (size>k)
            {
                Integer integer = countEach.get(chars[left]);
                integer--;
                if (integer==0)
                {
                    countEach.remove(chars[left]);
                    size--;
                }
                else
                {
                    countEach.put(chars[left],integer);
                }
                left++;
            }
            maxLength=Math.max(right-left+1,maxLength);
            right++;
        }
        return maxLength;
    }
}
