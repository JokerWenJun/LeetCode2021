package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution270 {


    public int closestValue(TreeNode root, double target) {
        List<Integer>treeList=new LinkedList<>();
        TreeNode current=root;
        midOrder(current,treeList);
        int answ=0;
        double minAbs=Integer.MAX_VALUE;
        for (Integer integer : treeList) {
            double abs = Math.abs(integer - target);
            if (abs<minAbs)
            {
                answ=integer;
                minAbs=abs;
            }
        }
        return answ;
    }

    private void midOrder(TreeNode current, List<Integer> treeList) {
        if (current==null)
        {
            return;
        }
        midOrder(current.left,treeList);
        treeList.add(current.val);
        midOrder(current.right,treeList);
    }
}
