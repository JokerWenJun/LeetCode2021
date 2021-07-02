package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.Trie;
import org.junit.Test;

public class Solution208 {

    @Test
    public void test()
    {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");// 返回 True
        boolean app = trie.search("app");// 返回 False
        boolean app1 = trie.startsWith("app");// 返回 True
        trie.insert("app");
        boolean app2 = trie.search("app");// 返回 True
        System.out.println("pause");
    }

}
