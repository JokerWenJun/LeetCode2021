package cn.spikejun.leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node>queue=new ArrayDeque<>();
        List<List<Integer>>answ=new ArrayList<>();
        if (root==null)
        {
            return answ;
        }
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                List<Node> children = poll.children;
                for (Node child : children) {
                    queue.add(child);
                }
            }
            answ.add(list);
        }
        return answ;
    }
}
