package cn.spikejun.leetcode.problems.pojo;

public class Trie {

    public Trie[]tries;
    public boolean isEnd;

    public Trie()
    {
        tries=new Trie[26];
        isEnd=false;
    }

    public void insert(String word)
    {
        Trie cur=this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (cur.tries[chars[i]-'a']==null)
            {
                cur.tries[chars[i]-'a']=new Trie();
            }
            cur=cur.tries[chars[i]-'a'];
        }
        cur.isEnd=true;
    }

    public boolean search(String word)
    {
        char[] chars = word.toCharArray();
        Trie cur=this;
        for (int i = 0; i < chars.length; i++) {
            if (cur.tries[chars[i]-'a']==null)
            {
                return false;
            }
            else
            {
                cur=cur.tries[chars[i]-'a'];
            }
        }
        return cur.isEnd;
    }
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Trie cur=this;
        for (int i = 0; i < chars.length; i++) {
            if (cur.tries[chars[i] - 'a'] == null) {
                return false;
            } else {
                cur = cur.tries[chars[i] - 'a'];
            }
        }
        return true;
    }


}
