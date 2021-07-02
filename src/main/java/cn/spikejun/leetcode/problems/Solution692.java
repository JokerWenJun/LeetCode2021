package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution692 {

    @Test
    public void test()
    {
        String[]arr=new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> strings = topKFrequent(arr, 4);
        System.out.println("pause");
        System.out.println(strings.toString());
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>data=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer value = data.getOrDefault(words[i], 0)+1;
            data.put(words[i],value);
        }
        PriorityQueue<String>queue=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int valueO1=data.get(o1);
                int valueO2=data.get(o2);
                if (valueO1==valueO2)
                {
                    return -o1.compareTo(o2);
                }
                return valueO1-valueO2;
            }
        });

        for (String s : data.keySet()) {
            queue.offer(s);
            if (queue.size()>k)
            {
                queue.poll();
            }
        }

        List<String>answ=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            answ.add(queue.poll());
        }

        Collections.reverse(answ);
        return answ;
    }
}
