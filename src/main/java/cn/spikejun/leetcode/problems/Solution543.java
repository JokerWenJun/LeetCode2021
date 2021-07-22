package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution543 {

    @Test
    public void test()
    {
//        TreeNode treeNode=new TreeNode(1);
//        TreeNode current=treeNode;
//        current.left=new TreeNode(2);
//        current.right=new TreeNode(3);
//        current=current.left;
//        current.left=new TreeNode(4);
//        current.right=new TreeNode(5);
//        int i = diameterOfBinaryTree(treeNode);
//        System.out.println(i);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        int max=0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                max=Math.max(diameterOfBinaryTree1(poll),max);
                if (poll.left!=null)
                {
                    queue.add(poll.left);
                }
                if (poll.right!=null)
                {
                    queue.add(poll.right);
                }
            }
        }
        return max;
    }
    public int diameterOfBinaryTree1(TreeNode root) {
        int leftTreeDeep=0;
        int rightTreeDeep=0;
        if (root.left!=null)
        {
            leftTreeDeep=getTreeDeep(root.left);
        }
        if (root.right!=null)
        {
            rightTreeDeep=getTreeDeep(root.right);
        }
        int leftSide=leftTreeDeep+1-1;
        int rightSide=rightTreeDeep+1-1;
        return leftSide+rightSide;
    }

    private int getTreeDeep(TreeNode root) {
        int depth=0;
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null)
                {
                    queue.add(poll.left);
                }
                if (poll.right!=null)
                {
                    queue.add(poll.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
