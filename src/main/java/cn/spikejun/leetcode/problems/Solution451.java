package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution451 {

    @Test
    public void test()
    {
//        PriorityQueue<singleElement>queue=new PriorityQueue<>(new Comparator<singleElement>() {
//            @Override
//            public int compare(singleElement o1, singleElement o2) {
//                return o1.count-o2.count;
//            }
//        });
//        queue.add(new singleElement(0,1));
//        queue.add(new singleElement(1,2));
//        queue.add(new singleElement(2,1));
//        System.out.println(queue.poll().position);
//        System.out.println(queue.poll().position);
        String s="Aabb";
        String s1 = frequencySort(s);
        System.out.println(s1);
    }



    class singleElement
    {
        public  char currentChar;
        public  int count;

        public singleElement() {
        }

        public singleElement(char currentChar, int count) {
            this.currentChar = currentChar;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character,Integer>alphabet=new HashMap<>();
        char[] chars = s.toCharArray();
        //统计出每个字符的count
        for (int i = 0; i < chars.length; i++) {
            alphabet.put(chars[i],alphabet.getOrDefault(chars[i],0)+1);
        }

        PriorityQueue<singleElement>queue=new PriorityQueue<>(new Comparator<singleElement>() {
            @Override
            public int compare(singleElement o1, singleElement o2) {
                return o2.count-o1.count;
            }
        });
        //加入到优先队列中进行排队
        Set<Character> characters = alphabet.keySet();
        for (Character character : characters) {
            queue.add(new singleElement(character,alphabet.get(character)));
        }
        //打印
        StringBuffer answBuffer=new StringBuffer();
        while (!queue.isEmpty())
        {
            singleElement peek = queue.poll();
            for (int i = 0; i < peek.count; i++) {
                answBuffer.append(peek.currentChar);
            }
        }
        String answ=answBuffer.toString();
        return answ;
    }
}
