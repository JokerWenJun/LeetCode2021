package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        TreeNode current=root;
        current=root.left;
        current.left=new TreeNode(11);
        current=current.left;
        current.left=new TreeNode(7);
        current.right=new TreeNode(2);
        current=root;
        current=current.right;
        current.left=new TreeNode(13);
        current.right=new TreeNode(4);
        current=current.right;
        current.left=new TreeNode(5);
        current.right=new TreeNode(1);
        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println("!!!!!");
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>answ=new ArrayList<>();
        if (root==null)
        {
            return answ;
        }
        int count=root.val;
        TreeNode current=root;
        List<Integer>route=new ArrayList<>();
        route.add(root.val);
        dfs(current,count,targetSum,route,answ);
        return answ;
    }

    private void dfs(TreeNode current, int count,int target, List<Integer> route, List<List<Integer>> answ) {
        //递归结束条件
        if (current.left==null&&current.right==null)
        {
            if (count==target)
            {
                answ.add(new ArrayList<>(route));
            }
            return;
        }
        if (current.left!=null)
        {
            route.add(current.left.val);
            dfs(current.left,count+current.left.val,target,route,answ);
            route.remove(route.size()-1);
        }
        if (current.right!=null)
        {
            route.add(current.right.val);
            dfs(current.right,count+current.right.val,target,route,answ);
            route.remove(route.size()-1);
        }
    }
}
