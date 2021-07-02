package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionOffer68 {


    public Map<TreeNode,TreeNode>parentsMap=new HashMap<>();
    public Set<TreeNode>pParentRoute=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parentsMap.put(root,null);
        dfs(root);
        TreeNode cur=p;
        pParentRoute.add(p);
        while (cur!=null)
        {
            TreeNode curParentTree = parentsMap.get(cur);
            if (curParentTree!=null)
            {
                pParentRoute.add(curParentTree);
            }
            cur=curParentTree;
        }
        cur=q;
        if (pParentRoute.contains(cur))
        {
            return cur;
        }
        while (cur!=null)
        {
            TreeNode curParentTree = parentsMap.get(cur);
            if (curParentTree!=null)
            {
                if (pParentRoute.contains(curParentTree))
                {
                    return curParentTree;
                }
            }
            cur=curParentTree;
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root==null)
        {
            return;
        }
        if (root.left!=null)
        {
            parentsMap.put(root.left,root);
        }
        if (root.right!=null)
        {
            parentsMap.put(root.right,root);
        }
        dfs(root.left);
        dfs(root.right);
    }


}
