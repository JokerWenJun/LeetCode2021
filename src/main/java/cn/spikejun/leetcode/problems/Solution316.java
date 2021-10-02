package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution316 {

    @Test
    public void test()
    {
        String s="bcabc";
        String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
    }


    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[]eachCharCounts=new int[26];
        boolean[]existed=new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            eachCharCounts[chars[i]-'a']++;
        }
        Deque<Character>deque=new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            eachCharCounts[currentChar-'a']--;
            if (existed[currentChar-'a'])
            {
                continue;
            }
            while (!deque.isEmpty()&&currentChar<deque.peekLast())
            {
                if (eachCharCounts[deque.peekLast()-'a']==0)
                {
                    break;
                }
                Character pollLast = deque.pollLast();
                existed[pollLast-'a']=false;
            }
            deque.addLast(currentChar);
            existed[currentChar-'a']=true;
        }
        StringBuffer buffer=new StringBuffer();
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            buffer.append(deque.pollFirst());
        }
        return buffer.toString();
    }

}
