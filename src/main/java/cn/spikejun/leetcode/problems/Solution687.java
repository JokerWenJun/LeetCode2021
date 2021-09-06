package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution687 {

    private int maxEdges=1;

    public int longestUnivaluePath(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
        {
            return 0;
        }
        int length=getTheSameValueAsCurrentRoot(root);
        return maxEdges-1;
    }


    private int getTheSameValueAsCurrentRoot(TreeNode root)
    {
        int totalSamePoint=1;
        int left=0;
        int right=0;

        if(root.left!=null)
        {
            int leftSamePoint=getTheSameValueAsCurrentRoot(root.left);
            if(root.val==root.left.val)
            {
                left=leftSamePoint;
                totalSamePoint+=leftSamePoint;
            }
        }
        if(root.right!=null)
        {
            int rightSamePoint=getTheSameValueAsCurrentRoot(root.right);
            if(root.val==root.right.val)
            {
                right=rightSamePoint;
                totalSamePoint+=rightSamePoint;
            }
        }
        maxEdges=Math.max(maxEdges,totalSamePoint);
        return Math.max(1+left,1+right);
    }

}
