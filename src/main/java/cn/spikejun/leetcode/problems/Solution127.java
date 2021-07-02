package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution127 {

    @Test
    public void test()
    {
        String beginWord="hog";
        String endWord="cog";
        String[]s=new String[]{"cog"};
        List<String> stringList = Arrays.asList(s);
        int i = ladderLength(beginWord, endWord, stringList);
        System.out.println(i);
    }
    private Set<String>words=new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size()==0)
        {
            return 0;
        }
        Queue<String>beginQueue=new ArrayDeque<>();
        Queue<String>endQueue=new ArrayDeque<>();
        Set<String>visitedBegin=new HashSet<>();
        Set<String>visitedEnd=new HashSet<>();
        int step=0;
        for (int i = 0; i < wordList.size(); i++) {
            words.add(wordList.get(i));
        }
        if (!wordList.contains(endWord))
        {
            return 0;
        }
        beginQueue.add(beginWord);
        endQueue.add(endWord);
        visitedBegin.add(beginWord);
        visitedEnd.add(endWord);
        while (!beginQueue.isEmpty()&&!endQueue.isEmpty())
        {
            step++;
            int beginQueueSize = beginQueue.size();
            int endQueueSize = endQueue.size();
            if (beginQueueSize<=endQueueSize)
            {
                //正方向进行DFS
                for (int i = 0; i < beginQueueSize; i++) {
                    String currentStr=beginQueue.poll();
                    boolean upResult = update(currentStr, beginQueue, visitedBegin, visitedEnd);
                    if (upResult)
                    {
                        return step+1;
                    }
                }
            }
            else
            {
                //逆向DFS
                for (int i = 0; i < endQueueSize; i++) {
                    String currentStr=endQueue.poll();
                    boolean upResult = update(currentStr, endQueue, visitedEnd, visitedBegin);
                    if (upResult)
                    {
                        return step+1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean update(String currentStr,Queue<String> currentQueue, Set<String>currentSet, Set<String> otherSet) {
        char[] chars = currentStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar=chars[i];
            for (int j = 0; j < 26; j++) {
                if (originalChar=='a'+j)
                {
                    continue;
                }
                chars[i]=(char) ('a'+j);
                String changeStr=String.valueOf(chars);
                if (words.contains(changeStr))
                {
                    if (currentSet.contains(changeStr))
                    {
                        chars[i]=originalChar;
                        continue;
                    }
                    else
                    {
                        if (otherSet.contains(changeStr))
                        {
                            return true;
                        }
                        currentSet.add(changeStr);
                        currentQueue.add(changeStr);
                    }
                }
                chars[i]=originalChar;
            }
        }
        return false;
    }


    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
        {
            return 0;
        }
        //储存DFS的队列
        Queue<String>queue=new ArrayDeque<>();
        //判断是否已经遍历过
        Set<String>visited=new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        //步数
        int step=0;
        //一个字符串的长度
        int strlength = beginWord.length();
        while (!queue.isEmpty())
        {
            step++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String poll = queue.poll();
                for (int j = 0; j < strlength; j++) {
                    char originalChar=poll.charAt(j);
                    char[] charArray = poll.toCharArray();
                    for (int k = 0; k < 26; k++) {
                        if (originalChar=='a'+k)
                        {
                            continue;
                        }
                        charArray[j]= (char) (k+'a');
                        String changeStr = String.valueOf(charArray);
                        if (wordList.contains(changeStr))
                        {
                            if (endWord.equals(changeStr))
                            {
                                return step+1;
                            }
                            if (visited.contains(changeStr))
                            {
                                continue;
                            }
                            visited.add(changeStr);
                            queue.add(changeStr);
                        }
                        charArray[j]=originalChar;
                    }
                }
            }
        }
        return 0;
    }



}
