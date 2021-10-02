package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution437 {


    Map<TreeNode,Map<Integer,Integer>>map=new HashMap<>();
    int answ=0;
    public int pathSum(TreeNode root, int targetSum) {
        //first we need to post order
        TreeNode current=root;
        postOrder(current,targetSum);
        return answ;
    }

    private void postOrder(TreeNode current, int targetSum) {
        if (current==null)
        {
            return;
        }
        postOrder(current.left,targetSum);
        postOrder(current.right,targetSum);
        Map<Integer,Integer>currentTreeNode=new HashMap<>();
        currentTreeNode.put(current.val,1);
        if (current.left!=null)
        {
            Map<Integer, Integer> leftMap = this.map.get(current.left);
            Set<Integer> leftKeys = leftMap.keySet();
            for (Integer leftKey : leftKeys) {
                currentTreeNode.put(leftKey+current.val,currentTreeNode.getOrDefault(leftKey+current.val,0)+leftMap.get(leftKey));
            }
        }
        if (current.right!=null)
        {
            Map<Integer, Integer> rightMap = this.map.get(current.right);
            Set<Integer> rightKeys = rightMap.keySet();
            for (Integer rightKey : rightKeys) {
                currentTreeNode.put(rightKey+current.val,currentTreeNode.getOrDefault(rightKey+current.val,0)+rightMap.get(rightKey));
            }
        }
        Integer value = currentTreeNode.getOrDefault(targetSum, 0);
        answ+=value;
        map.put(current,currentTreeNode);
    }
}
