package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution993 {

    private TreeNode xNode;
    private TreeNode xNodeParent;
    private boolean xFind;
    private int xDepth;

    private TreeNode yNode;
    private TreeNode yNodeParent;
    private boolean yFind;
    private int yDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode>nodeQueue=new LinkedList<>();
        Deque<Integer>depthQueue=new LinkedList<>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        while (!nodeQueue.isEmpty())
        {
            TreeNode peekNode = nodeQueue.poll();
            Integer peekNodeDepth = depthQueue.poll();

            if (peekNode.left!=null)
            {
                nodeQueue.addLast(peekNode.left);
                depthQueue.addLast(peekNodeDepth+1);
                check(peekNode.left,peekNode,x,y,peekNodeDepth+1);
            }

            if (peekNode.right!=null)
            {
                nodeQueue.addLast(peekNode.right);
                depthQueue.addLast(peekNodeDepth+1);
                check(peekNode.right,peekNode,x,y,peekNodeDepth+1);
            }

            if (xFind&&yFind)
            {
                break;
            }

        }
        if (xFind&&yFind&&xNodeParent!=yNodeParent&&xDepth==yDepth)
        {
            return true;
        }
        return false;
    }
    public void check(TreeNode node,TreeNode parent,int x,int y,int depth)
    {
        if (node.val==x)
        {
            this.xNode=node;
            this.xNodeParent=parent;
            this.xFind=true;
            this.xDepth=depth;
        }
        else if (node.val==y)
        {
            this.yNode=node;
            this.yNodeParent=parent;
            this.yFind=true;
            this.yDepth=depth;
        }
    }


}
