package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SolutionOffer48 {

    @Test
    public void test()
    {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer>countMap=new HashMap<>();
        int left=0;
        int right=0;
        int maxLength=0;
        while (right<chars.length)
        {
            Integer count = countMap.getOrDefault(chars[right], 0);
            if (count==0)
            {
                countMap.put(chars[right],1);
                maxLength=Math.max(maxLength,right-left+1);
            }
            else {
                countMap.put(chars[right],2);
                while (left<right)
                {
                    Integer currentLeftCount = countMap.get(chars[left]);
                    if (currentLeftCount==1)
                    {
                        countMap.put(chars[left],0);
                        left++;
                    }
                    if (currentLeftCount==2)
                    {
                        countMap.put(chars[left],1);
                        left++;
                        break;
                    }
                }
                maxLength=Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}
