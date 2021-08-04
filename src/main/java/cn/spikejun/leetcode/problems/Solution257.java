package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {


    @Test
    public void test()
    {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        TreeNode current=root;
        current=root.left;
        current.right=new TreeNode(5);
        List<String> stringList = binaryTreePaths(root);
        System.out.println("!!!!");
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String>answ=new ArrayList<>();
        if (root==null)
        {
            return answ;
        }
        StringBuffer buffer=new StringBuffer().append(root.val);
        dfs(root,buffer,answ);
        return answ;
    }

    private void dfs(TreeNode currentRoot, StringBuffer buffer, List<String> answ) {
        if (currentRoot.left==null&&currentRoot.right==null)
        {
            answ.add(new String(buffer.toString()));
            return;
        }
        if (currentRoot.left!=null)
        {
            StringBuffer newBuff=new StringBuffer(buffer);
            newBuff.append("->").append(currentRoot.left.val);
            dfs(currentRoot.left,newBuff,answ);
        }
        if (currentRoot.right!=null)
        {
            StringBuffer newBuff=new StringBuffer(buffer);
            newBuff.append("->").append(currentRoot.right.val);
            dfs(currentRoot.right,newBuff,answ);
        }
    }

}
