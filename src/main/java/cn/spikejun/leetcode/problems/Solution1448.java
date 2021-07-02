package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

public class Solution1448 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        TreeNode current=root;
        current=current.left;
        current.left=new TreeNode(3);
        current=root;
        current=current.right;
        current.left=new TreeNode(1);
        current.right=new TreeNode(5);
        int i = goodNodes(root);
        System.out.println(i);
    }

    private int answ=0;
    public int goodNodes(TreeNode root) {
        TreeNode current=root;
        int currentMax= root.val;
        preOrder(current,currentMax);
        return answ;
    }

    private void preOrder(TreeNode current, int currentMax) {
        if (current==null)
        {
            return;
        }
        if (current.val>=currentMax)
        {
            answ++;
            currentMax=Math.max(current.val,currentMax);
        }
        preOrder(current.left,currentMax);
        preOrder(current.right,currentMax);
    }
}
