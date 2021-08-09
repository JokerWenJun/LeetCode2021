package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution767 {

    public String reorganizeString(String s) {
        StringBuffer buffer=new StringBuffer();
        char[] chars = s.toCharArray();
        Map<Character,Integer>map=new HashMap<>();
        int maxCount=0;
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
            maxCount=Math.max(map.get(chars[i]),maxCount);
        }
        //判断一下hi是否可以
        if (maxCount>(s.length()+1)/2)
        {
            return "";
        }
        //char-count
        PriorityQueue<Integer[]>priorityQueue=new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1]-o1[1];
            }
        });
        Set<Character> characters = map.keySet();
        for (Character character : characters) {

            priorityQueue.add(new Integer[]{character-'a',map.get(character)});
        }
        StringBuffer answBuffer=new StringBuffer();
        while (!priorityQueue.isEmpty())
        {
            //每次挑出两个最大的
            if (priorityQueue.size()>=2)
            {
                Integer[] firstNum = priorityQueue.poll();
                Integer[] secondNum = priorityQueue.poll();
                answBuffer.append((char) ('a'+firstNum[0]));
                firstNum[1]--;
                answBuffer.append((char) ('a'+secondNum[0]));
                secondNum[1]--;
                //判断是否回去
                if (firstNum[1]!=0)
                {
                    priorityQueue.add(firstNum);
                }
                if (secondNum[1]!=0)
                {
                    priorityQueue.add(secondNum);
                }
            }
            else
            {
                break;
            }
        }
        if (priorityQueue.size()!=0)
        {
            Integer[] peek = priorityQueue.poll();
            answBuffer.append((char)(peek[0]+'a'));
            peek[1]--;
            if (peek[1]!=0)
            {
                return "";
            }
        }
        return answBuffer.toString();
    }
}
