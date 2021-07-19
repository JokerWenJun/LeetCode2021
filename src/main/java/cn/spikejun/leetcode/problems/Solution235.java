package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution235 {

    @Test
    public void test() {
        TreeNode p;
        TreeNode q;
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(2);
        TreeNode current = treeNode;
        p=current.left;
        current = current.left;
        current.left = new TreeNode(0);
        current.right=new TreeNode(4);
        current=current.right;
        q=current;
        current.left=new TreeNode(3);
        current.right=new TreeNode(5);
        current=treeNode;
        current.right=new TreeNode(8);
        current=current.right;
        current.left=new TreeNode(7);
        current.right=new TreeNode(9);
        lowestCommonAncestor(treeNode,p,q);
    }


    private Set<TreeNode> pRoutes;
    private TreeNode answ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pRoutes=new HashSet<>();
        answ=root;
        TreeNode current=root;
        searchPAndCreateRoute(current,p);
        if (pRoutes.contains(q))
        {
            return q;
        }
        searchQAndFindAnsw(current,q);
        return answ;
    }

    private boolean searchQAndFindAnsw(TreeNode current, TreeNode q) {
        if (current==null)
        {
            return false;
        }
        if (current==q)
        {
            return true;
        }
        if (searchQAndFindAnsw(current.left,q)||searchQAndFindAnsw(current.right,q))
        {
            if (pRoutes.contains(current))
            {
                answ=current;
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean searchPAndCreateRoute(TreeNode current, TreeNode p) {
        if (current==null)
        {
            return false;
        }
        if (current==p)
        {
            pRoutes.add(current);
            return true;
        }
        if (searchPAndCreateRoute(current.left,p)||searchPAndCreateRoute(current.right,p))
        {
            pRoutes.add(current);
            return true;
        }
        return false;
    }
}
