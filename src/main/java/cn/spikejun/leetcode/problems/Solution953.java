package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution953 {
    @Test
    public void test()
    {
        String[]words=new String[]{"apple","app"};
        String order="worldabcefghijkmnpqstuvxyz";
        boolean alienSorted = isAlienSorted(words, order);
        System.out.println(alienSorted);
    }


    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> newCharacterOrderValueMap=new HashMap<>();
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            newCharacterOrderValueMap.put(chars[i],i+1);
        }
        for (int i = 1; i < words.length; i++) {
            boolean judge=compareTwoString(words[i-1],words[i],newCharacterOrderValueMap);
            if (!judge)
            {
                return false;
            }
        }
        return true;
    }

    private boolean compareTwoString(String word1, String word2, Map<Character,Integer> map) {
        //判断word2是否大于word1
        char[] charArray2 = word2.toCharArray();
        char[] charArray1 = word1.toCharArray();
        boolean same=true;
        for (int i = 0; i < charArray2.length; i++) {
            if (i>=charArray1.length)
            {
                break;
            }
            if (map.get(charArray2[i])<map.get(charArray1[i]))
            {
                return false;
            }
            else if (map.get(charArray2[i])>map.get(charArray1[i]))
            {
                return true;
            }
        }
        if (same)
        {
            if (charArray2.length>=charArray1.length)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
