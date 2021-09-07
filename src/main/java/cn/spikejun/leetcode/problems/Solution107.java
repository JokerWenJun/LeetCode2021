package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.*;

public class Solution107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>>answ=new ArrayList<>();
        Deque<TreeNode>deque=new ArrayDeque<>();
        if (root==null)
        {
            return answ;
        }
        deque.addFirst(root);
        while (!deque.isEmpty())
        {
            List<Integer>current=new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                current.add(treeNode.val);
                if (treeNode.left!=null)
                {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right!=null)
                {
                    deque.addLast(treeNode.right);
                }
            }
            answ.add(current);
        }
        Collections.reverse(answ);
        return answ;
    }
    
}
