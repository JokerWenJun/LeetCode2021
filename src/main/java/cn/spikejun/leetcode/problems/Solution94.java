package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>answ=new LinkedList<>();
        TreeNode current=root;
        midOrder(current,answ);
        return answ;
    }

    private void midOrder(TreeNode current, List<Integer> answ) {
        if (current==null)
        {
            return;
        }
        midOrder(current.left,answ);
        answ.add(current.val);
        midOrder(current.right,answ);
    }
}
