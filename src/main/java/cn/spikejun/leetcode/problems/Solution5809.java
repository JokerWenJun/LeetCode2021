package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution5809 {

    @Test
    public void test()
    {
        String s="adc";
        int i = countPalindromicSubsequence(s);
        System.out.println(i);
    }


    public int countPalindromicSubsequence(String s) {
        Set<String>answ=new HashSet<>();
        char[] chars = s.toCharArray();
        //数组中第一个元素为最早出现，第二个为最晚出现
        Map<Character,Integer[]>logFirstAppearLocation=new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (i<=1)
            {
                Integer[] logNumberArr = logFirstAppearLocation.get(chars[i]);
                if (logNumberArr==null)
                {
                    logNumberArr=new Integer[]{i,i};
                    logFirstAppearLocation.put(chars[i],logNumberArr);
                }
                else
                {
                    logNumberArr[1]=i;
                }
            }
            //开始寻找回文
            else {
                Integer[] currentCharLogArr = logFirstAppearLocation.get(chars[i]);
                if (currentCharLogArr==null)
                {
                    currentCharLogArr=new Integer[]{i,i};
                    logFirstAppearLocation.put(chars[i],currentCharLogArr);
                }
                else
                {
                    int firstBegin=currentCharLogArr[0];
                    //遍历map
                    Set<Character> characters = logFirstAppearLocation.keySet();
                    for (Character character : characters) {
                        Integer[] otherCharacterArrayLog = logFirstAppearLocation.get(character);
                        int lastAppearPosition=otherCharacterArrayLog[1];
                        if (lastAppearPosition!=firstBegin&&lastAppearPosition>firstBegin)
                        {
                            String huiwen=chars[i]+""+character+chars[i];
                            answ.add(huiwen);
                        }
                    }
                    currentCharLogArr[1]=i;
                }
            }
        }
        return answ.size();
    }

}
