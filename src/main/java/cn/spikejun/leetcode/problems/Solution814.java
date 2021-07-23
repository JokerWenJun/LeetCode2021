package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

public class Solution814 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(1);
        TreeNode c=root;
        c.right=new TreeNode(0);
        c=c.right;
        c.left=new TreeNode(0);
        c.right=new TreeNode(1);
        c=root;
        c.left=new TreeNode(0);
        c=c.left;
        c.left=new TreeNode(0);
        c.right=new TreeNode(0);
        TreeNode treeNode = pruneTree(root);
        System.out.println("!!!!");

    }



    public TreeNode pruneTree(TreeNode root) {
        if (root==null)
        {
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if (root.val==0&&root.left==null&&root.right==null)
        {
            return null;
        }
        return root;
    }


}
//[0,1,0,0,1,1,1,null,0,1,0,1,1,1,null,1,1,1,0,0,1,null,0,0,0,1,1,null,1,null,null,null,1,1,null,1,null,null,null,null,1,1,1,null,1,1]