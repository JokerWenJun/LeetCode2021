package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution244 {

    @Test
    public void test()
    {
        System.out.println(Integer.MIN_VALUE);
    }


    class WordDistance {


        private Map<String, List<Integer>>map;

        public WordDistance(String[] wordsDict) {
            map=new HashMap<>();

            for (int i = 0; i < wordsDict.length; i++) {
                if (map.containsKey(wordsDict[i]))
                {
                    map.get(wordsDict[i]).add(i);
                }
                else
                {
                    List<Integer>list=new ArrayList<>();
                    list.add(i);
                    map.put(wordsDict[i],list);
                }
            }
        }

        public int shortest(String word1, String word2) {
            int minDistance=Integer.MAX_VALUE;
            List<Integer> listWord1 = map.get(word1);
            List<Integer> listword2 = map.get(word2);
            int i=0;
            int j=0;
            while (i<listWord1.size()&&j<listword2.size())
            {
                minDistance=Math.min(minDistance,Math.abs(listWord1.get(i)-listword2.get(j)));
                if (minDistance==0)
                {
                    return 0;
                }
                int distanceA=listWord1.get(i);
                int distanceB=listword2.get(j);
                if (distanceA<distanceB)
                {
                    i++;
                }
                else if (distanceA>distanceB)
                {
                    j++;
                }
            }
            return minDistance;
        }
    }
}
