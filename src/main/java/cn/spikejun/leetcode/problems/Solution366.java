package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {


    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>>answ=new ArrayList<>();
        while (root.left!=null||root.right!=null)
        {
            TreeNode currentRoot = root;
            List<Integer>eachRow=new ArrayList<>();
            dfs(currentRoot,null,0,eachRow);
            answ.add(eachRow);
        }
        List<Integer>lastRow=new ArrayList<>();
        lastRow.add(root.val);
        answ.add(lastRow);
        return answ;
    }

    /**
     *
     * @param currentRoot
     * @param preParent
     * @param direction 1：preRoot left child,2：preRoot right child
     * @param eachRow
     */
    private void dfs(TreeNode currentRoot, TreeNode preParent, int direction, List<Integer> eachRow) {
        if (currentRoot.left==null&&currentRoot.right==null)
        {
            eachRow.add(currentRoot.val);
            if (direction==1)
            {
                preParent.left=null;
            }
            else if (direction==2)
            {
                preParent.right=null;
            }
            return;
        }
        if (currentRoot.left!=null)
        {
            dfs(currentRoot.left,currentRoot,1,eachRow);
        }
        if (currentRoot.right!=null)
        {
            dfs(currentRoot.right,currentRoot,2,eachRow);
        }

    }
}
