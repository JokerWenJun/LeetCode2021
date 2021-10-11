package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution1048 {
    @Test
    public void test()
    {
        String[]word=new String[]{"abcd","dbqca"};
        int i = longestStrChain(word);
        System.out.println(i);
    }
    public int longestStrChain(String[] words) {
        Map<Integer,Map<String,Integer>>map=new HashMap<>();
        int minWordLength=Integer.MAX_VALUE;
        int maxWordLength=Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            minWordLength=Math.min(currentWord.length(),minWordLength);
            maxWordLength=Math.max(currentWord.length(),maxWordLength);
            if (map.containsKey(currentWord.length()))
            {
                Map<String, Integer> stringIntegerMap = map.get(currentWord.length());
                stringIntegerMap.put(currentWord,1);
            }
            else
            {
                Map<String,Integer>newMap=new HashMap<>();
                newMap.put(currentWord,1);
                map.put(currentWord.length(),newMap);
            }
        }
        int answ=1;
        for (int i = minWordLength+1; i <=maxWordLength; i++) {
            if (!map.containsKey(i))
            {
                continue;
            }
            if (!map.containsKey(i-1))
            {
                continue;
            }
            Map<String, Integer> current = map.get(i);
            Map<String, Integer> currentPre = map.get(i - 1);
            Set<String> set = current.keySet();
            for (String s : set) {
                Integer currentStrChainLength = current.get(s);
                for (int j = 0; j < s.length(); j++) {
                    String substring1 = s.substring(0, j);
                    String substring2= s.substring(j + 1);
                    StringBuffer buffer=new StringBuffer();
                    buffer.append(substring1).append(substring2);
                    Integer integer = currentPre.get(buffer.toString());
                    if (integer!=null)
                    {
                        currentStrChainLength=Math.max(currentStrChainLength,integer+1);
                    }
                }
                answ=Math.max(answ,currentStrChainLength);
                current.put(s,currentStrChainLength);
            }
        }
        return answ;
    }
}
