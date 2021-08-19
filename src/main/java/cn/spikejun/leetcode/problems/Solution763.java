package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution763 {


    @Test
    public void test()
    {
        String s="ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list.toString());
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer[]>map=new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i]))
            {
                Integer[] integers = map.get(chars[i]);
                integers[1]=i;
            }
            else
            {
                Integer[]integers=new Integer[]{i,i};
                map.put(chars[i],integers);
            }
        }
        Integer[][]arr=new Integer[map.size()][2];
        Set<Character> characters = map.keySet();
        int i=0;
        for (Character character : characters) {
            arr[i]=map.get(character);
            i++;
        }
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]-o2[0];
            }
        });
        Stack<Integer[]>stack=new Stack<>();
        for (Integer[] integers : arr) {
            if (stack.isEmpty())
            {
                stack.add(integers);
            }
            else
            {
                Integer[] peek = stack.peek();
                if (integers[1]<peek[1])
                {
                    continue;
                }
                else if (integers[0]<peek[1])
                {
                    Integer[] pop = stack.pop();
                    pop[1]=integers[1];
                    stack.add(pop);
                }
                else {
                    stack.add(integers);
                }
            }
        }
        List<Integer>answ=new ArrayList<>();
        while (!stack.isEmpty())
        {
            Integer[] pop = stack.pop();
            answ.add(pop[1]-pop[0]+1);
        }
        Collections.reverse(answ);
        return answ;
    }
}
