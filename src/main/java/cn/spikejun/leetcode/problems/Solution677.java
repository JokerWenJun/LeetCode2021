package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution677 {
    @Test
    public void test()
    {
        MapSum mapSum=new MapSum();
        mapSum.insert("apple",3);
        int ap = mapSum.sum("ap");
        mapSum.insert("app",2);
        int ap1 = mapSum.sum("ap");
        System.out.println(ap+"!!!!"+ap1);
    }


    class MapSum {
        class DictTreeNode
        {
            public boolean isEnd=false;
            public DictTreeNode[]next=new DictTreeNode[26];
        }
        private Map<String,Integer>map;
        private DictTreeNode head;
        /** Initialize your data structure here. */
        public MapSum() {
            map=new HashMap<>();
            this.head=new DictTreeNode();
        }
        public void insert(String key, int val) {
            if (map.containsKey(key))
            {
                map.put(key,val);
            }
            else
            {
                map.put(key,val);
                DictTreeNode current=head;
                //向字典树中添加此单词
                char[] chars = key.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char currentChar = chars[i];
                    int index=currentChar-'a';
                    if (current.next[index]==null)
                    {
                        current.next[index]=new DictTreeNode();
                    }
                    current=current.next[index];
                }
                current.isEnd=true;
            }
        }
        public int sum(String prefix) {
            char[] chars = prefix.toCharArray();
            StringBuffer currentStr=new StringBuffer();
            List<String>list=new ArrayList<>();
            DictTreeNode current=head;
            for (int i = 0; i < chars.length; i++) {
                char currentChar = chars[i];
                int index=currentChar-'a';
                if (current.next[index]==null)
                {
                    return 0;
                }
                current=current.next[index];
            }
            currentStr.append(prefix);
            dfs(current,currentStr,list);
            int totalValue=0;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (map.containsKey(s))
                {
                    Integer integer = map.get(s);
                    totalValue+=integer;
                }
            }
            return totalValue;
        }

        private void dfs(DictTreeNode current, StringBuffer currentStr, List<String> list) {
            if (current.isEnd==true)
            {
                list.add(new String(currentStr.toString()));
            }
            for (int i = 0; i < current.next.length; i++) {
                if (current.next[i]!=null)
                {
                    currentStr.append((char) ('a'+i));
                    dfs(current.next[i],currentStr,list);
                    currentStr.deleteCharAt(currentStr.length()-1);
                }
            }
        }
    }


}
