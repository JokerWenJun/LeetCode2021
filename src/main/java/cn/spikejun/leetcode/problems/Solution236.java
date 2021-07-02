package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution236 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        TreeNode p=root.left;
        root.right=new TreeNode(1);
        TreeNode c=root;
        c=c.left;
        c.left=new TreeNode(6);
        c.right=new TreeNode(2);
        c=c.right;
        c.left=new TreeNode(7);
        c.right=new TreeNode(4);
        c=root;
        c=c.right;
        c.left=new TreeNode(0);
        TreeNode q=c.left;
        c.right=new TreeNode(8);
        lowestCommonAncestor(root,p,q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pRoute=new LinkedList<>();
        List<TreeNode>qRoute=new LinkedList<>();

        TreeNode current=root;
        boolean checkP=seekTreeNode(current,p,pRoute);
        current=root;
        boolean checkQ = seekTreeNode(current, q, qRoute);


        for (int i = 0; i < pRoute.size(); i++) {
            TreeNode currentP = pRoute.get(i);
            for (int j = 0; j < qRoute.size(); j++) {
                if (currentP==qRoute.get(j))
                {
                    return currentP;
                }
            }
        }
        return null;
    }

    private boolean seekTreeNode(TreeNode current, TreeNode target, List<TreeNode> pRoute) {
        if (current==null)
        {
            return false;
        }
        if (current==target)
        {
            pRoute.add(current);
            return true;
        }
        if (seekTreeNode(current.left,target,pRoute)||seekTreeNode(current.right,target,pRoute))
        {
            pRoute.add(current);
            return true;
        }
        return false;
    }



}
