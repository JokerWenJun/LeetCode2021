package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {

    @Test
    public void test()
    {
        String s="barfoofoobarthefoobarman";
        String[]words=new String[]{"bar","foo","the"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring.toString());
    }


    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer>countWordsList=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            countWordsList.put(words[i],countWordsList.getOrDefault(words[i],0)+1);
        }
        //单一word的长度
        Integer singleWordLength=words[0].length();
        //答案
        List<Integer>answ=new ArrayList<>();
        //总长度
        int totalLength=words.length*singleWordLength;
        for (int i = 0; i <= s.length()-totalLength; i++) {
            Map<String,Integer>currentMap=new HashMap<>();
            int begin=i;
            for (int j = 1; j <= words.length; j++) {
                String word = s.substring(begin, begin +singleWordLength);
                currentMap.put(word,currentMap.getOrDefault(word,0)+1);
                begin=begin+singleWordLength;
            }
            if (currentMap.equals(countWordsList))
            {
                answ.add(i);
            }
        }
        return answ;
    }

}
