package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode>list=new ArrayList<>();
        TreeNode current=root;
        midOrder(current,list);
        TreeNode x=null;
        TreeNode y=null;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).val>list.get(i+1).val)
            {
                y=list.get(i+1);
                if (x==null)
                {
                    x=list.get(i);
                }
            }
        }
        if (x!=null&&y!=null)
        {
            int temp=x.val;
            x.val=y.val;
            y.val=temp;
        }
    }

    private void midOrder(TreeNode current, List<TreeNode> list) {
        if (current==null)
        {
            return;
        }
        midOrder(current.left,list);
        list.add(current);
        midOrder(current.right,list);
    }
}
