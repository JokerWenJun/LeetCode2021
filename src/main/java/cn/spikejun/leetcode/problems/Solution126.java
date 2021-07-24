package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution126 {

    @Test
    public void test()
    {
        String beginWord="hit";
        String endWord="cog";
        List<String>list=new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        List<List<String>> ladders = findLadders(beginWord, endWord, list);
        System.out.println("!!!");
    }


    public Set<String>words;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>>answ=new ArrayList<>();
        words=new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            words.add(wordList.get(i));
        }
        if (!words.contains(endWord))
        {
            return answ;
        }
        Set<String>vistited=new HashSet<>();
        //每一个node下面能得到的子节点
        Map<String,List<String>>map=new HashMap<>();
        //每一个node第一次遍历出现的depth
        Map<String,Integer>distance=new HashMap<>();
        bfs(beginWord,endWord,map,distance);
        List<String>route=new ArrayList<>();
        route.add(beginWord);
        //开始dfs
        dfs(beginWord,endWord,map,distance,route,answ);
        return answ;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> map, Map<String, Integer> distance, List<String> route, List<List<String>> answ) {
        if (beginWord.equals(endWord))
        {
            answ.add(new ArrayList<>(route));
            return;
        }
        List<String> orDefault = map.getOrDefault(beginWord, new ArrayList<>());
        for (int i = 0; i < orDefault.size(); i++) {
            String nextStr = orDefault.get(i);
            //判断距离
            if (distance.get(beginWord)+1==distance.get(nextStr))
            {
                route.add(nextStr);
                dfs(nextStr,endWord,map,distance,route,answ);
                route.remove(route.size()-1);
            }
        }
    }

    private void bfs(String beginWord, String endWord, Map<String, List<String>> map, Map<String, Integer> distance) {
        Queue<String>queue=new ArrayDeque<>();
        int depth=0;
        distance.put(beginWord,depth);
        queue.add(beginWord);
        boolean isEnd=false;
        while (!queue.isEmpty())
        {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                //得到所有变换的字符串
                List<String>changeList=changeWordsToNewWord(poll);
                map.put(poll,changeList);
                for (int j = 0; j < changeList.size(); j++) {
                    String changeWord = changeList.get(j);
                    if (!distance.containsKey(changeWord))
                    {
                        distance.put(changeWord,depth);
                        queue.add(changeWord);
                    }
                    //判断是否已经遍历到终点
                    if (changeWord.equals(endWord))
                    {
                        isEnd=true;
                    }
                }
                //如果下一层已经到达end那么就退出bfs
                if (isEnd)
                {
                    break;
                }
            }
        }
    }
    //将一个字符串进行改变而得到
    private List<String> changeWordsToNewWord(String poll) {
        char[] chars = poll.toCharArray();
        List<String>answ=new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (int j = 0; j < 26; j++) {
                if ('a'+j==originalChar)
                {
                    continue;
                }
                else
                {
                    chars[i]= (char) ('a'+j);
                    String s = String.valueOf(chars);
                    if (words.contains(s))
                    {
                        answ.add(s);
                    }
                }
                chars[i]=originalChar;
            }
        }
        return answ;
    }


}
