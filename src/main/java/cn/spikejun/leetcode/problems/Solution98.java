package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        TreeNode current=root;
        midOrder(current,list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)<=list.get(i-1))
            {
                return false;
            }
        }
        return true;
    }

    private void midOrder(TreeNode current, List<Integer> list) {
        if (current==null)
        {
            return;
        }
        midOrder(current.left,list);
        list.add(current.val);
        midOrder(current.right,list);

    }
}
