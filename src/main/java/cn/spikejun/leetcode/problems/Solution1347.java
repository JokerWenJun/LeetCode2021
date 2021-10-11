package cn.spikejun.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution1347 {
    public int minSteps(String s, String t) {
        Map<Character,Integer>mapS=new HashMap<>();
        Map<Character,Integer>mapT=new HashMap<>();
        char[] arrayOfS = s.toCharArray();
        char[] arrayOfT=t.toCharArray();
        for (int i = 0; i < arrayOfS.length; i++) {
            mapS.put(arrayOfS[i],mapS.getOrDefault(arrayOfS[i],0)+1);
        }
        for (int i = 0; i < arrayOfT.length; i++) {
            mapT.put(arrayOfT[i],mapT.getOrDefault(arrayOfT[i],0)+1);
        }
        int answ=0;
        Set<Character> setS = mapS.keySet();
        for (Character c : setS) {
            Integer tCount = mapT.getOrDefault(c, 0);
            Integer cCount = mapS.get(c);
            if (cCount>tCount)
            {
                answ+=(cCount-tCount);
            }
        }
        return answ;
    }
}
