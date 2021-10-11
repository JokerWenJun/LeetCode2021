package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution616 {

    @Test
    public void test()
    {
        String[]word=new String[]{"aaa","aab","bc"};
        String s="aaabbcc";
        String s1 = addBoldTag(s, word);
        System.out.println(s1);
    }



    public String addBoldTag(String s, String[] words) {
        char[] chars = s.toCharArray();
        List<int[]>intervals=new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < words.length; j++) {
                int currentWordLength = words[j].length();
                if (i+currentWordLength-1<=chars.length-1&&words[j].startsWith(s.substring(i,i+currentWordLength)))
                {
                    intervals.add(new int[]{i,i+currentWordLength-1});
                }
            }
        }
        //then we need to combine the intervals
        Deque<int[]>deque=new ArrayDeque<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (deque.isEmpty())
            {
                deque.add(intervals.get(i));
                continue;
            }
            int[] peek = deque.peekLast();
            int[] currentIntervals = intervals.get(i);
            if (currentIntervals[0]>peek[1]+1)
            {
                deque.addLast(currentIntervals);
            }
            else
            {
                int[] pollLast = deque.pollLast();
                int newRight=Math.max(pollLast[1],currentIntervals[1]);
                pollLast[1]=newRight;
                deque.addLast(pollLast);
            }
        }
        int size = deque.size();
        StringBuffer buffer=new StringBuffer();
        int left=0;
        for (int i = 0; i < size; i++) {
            int[] ints = deque.pollFirst();
            int leftSide=ints[0];
            int rightSide=ints[1];
            String substring1 = s.substring(left, leftSide);
            buffer.append(substring1);
            buffer.append("<b>");
            buffer.append(s.substring(leftSide,rightSide+1));
            buffer.append("</b>");
            left=rightSide+1;
        }
        if (left<=s.length()-1)
        {
            buffer.append(s.substring(left,s.length()));
        }
        return buffer.toString();
    }
}
