package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

public class Solution114 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        TreeNode current=root.left;
        current.left=new TreeNode(3);
        current.right=new TreeNode(4);
        current=root;
        current.right=new TreeNode(5);
        current=current.right;
        current.right=new TreeNode(6);
        flatten(root);
        System.out.println("!!!");
    }


    public void flatten(TreeNode root) {
        TreeNode current=root;
        while (current!=null)
        {
            if (current.left==null)
            {
                current=current.right;
            }
            else
            {
                TreeNode rightTree = current.right;
                current.right=current.left;
                current.left=null;
                TreeNode lastNode=current.right;
                TreeNode preNode=current;
                while (lastNode!=null)
                {
                    preNode=lastNode;
                    lastNode=lastNode.right;
                }
                preNode.right=rightTree;
                current=current.right;
            }
        }
    }

}
