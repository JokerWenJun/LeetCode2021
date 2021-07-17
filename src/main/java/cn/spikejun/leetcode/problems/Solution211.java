package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution211 {

    @Test
    public void test()
    {
        WordDictionary wordDictionary=new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        boolean aac = wordDictionary.search("an");
        System.out.println(aac);
        System.out.println("!!!");
    }



    class WordDictionary {
        class DictionTree
        {
            public DictionTree[]currentChar=new DictionTree[26];
            public boolean isEnd=false;
            public DictionTree() {
                currentChar=new DictionTree[26];
            }
        }


        public DictionTree root;
        public int maxlength=0;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root=new DictionTree();
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            DictionTree current=root;
            maxlength=Math.max(maxlength,word.length());
            for (int i = 0; i < chars.length; i++) {
                if (current.currentChar[chars[i]-'a']==null)
                {
                    current.currentChar[chars[i]-'a']=new DictionTree();
                }
                current=current.currentChar[chars[i]-'a'];
            }
            current.isEnd=true;
        }

        public boolean search(String word) {
            if (word.length()>maxlength)
            {
                return false;
            }
            char[] chars = word.toCharArray();
            DictionTree current=root;
            boolean judge= dfsSearch(chars,0,current);
            return judge;
        }

        private boolean dfsSearch(char[] chars, int i, DictionTree current) {
            if (i==chars.length)
            {
                if (current.isEnd)
                {
                    return true;
                }
                return false;
            }
            if (chars[i]!='.')
            {
                if (current.currentChar[chars[i]-'a']==null)
                {
                    return false;
                }
                else
                {
                    return dfsSearch(chars,i+1,current.currentChar[chars[i]-'a']);
                }
            }
            else {
                for (int j = 0; j < current.currentChar.length; j++) {
                    if (current.currentChar[j]!=null)
                    {
                        if (dfsSearch(chars,i+1,current.currentChar[j]))
                        {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }


}
