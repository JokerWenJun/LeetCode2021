package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

public class Solution1367 {

    @Test
    public void test()
    {
        TreeNode cur;
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(4);
        cur=root.left;
        cur.right=new TreeNode(2);
        cur=cur.right;
        cur.left=new TreeNode(1);
        cur=root;
        cur.right=new TreeNode(4);
        cur=cur.right;
        cur.left=new TreeNode(2);
        cur=cur.left;
        cur.left=new TreeNode(6);
        cur.right=new TreeNode(8);
        cur=cur.right;
        cur.left=new TreeNode(1);
        cur.right=new TreeNode(3);


        ListNode head=new ListNode(1);
        ListNode curN=head;
        curN.next=new ListNode(4);
        curN=curN.next;
        curN.next=new ListNode(2);
        curN=curN.next;
        curN.next=new ListNode(6);
        curN=curN.next;
        curN.next=new ListNode(8);
        isSubPath(head,root);
        System.out.println(isSubPath(head,root));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean answ=treeDFS(root,head);
        return answ;
    }


    public ListNode headNode;
    public TreeNode rooNode;


    public boolean treeDFS(TreeNode rooNode,ListNode headNode)
    {
        if (rooNode==null)
        {
            return false;
        }
        boolean dfsAnsw = dfs(headNode, rooNode, true);
        if (dfsAnsw)
        {
            return true;
        }
        boolean leftAnsw = treeDFS(rooNode.left, headNode);
        if (leftAnsw)
        {
            return true;
        }
        boolean rightAnsw = treeDFS(rooNode.right, headNode);
        if (rightAnsw)
        {
            return true;
        }
        return false;
    }

    private boolean dfs(ListNode curretListNode, TreeNode currentTreeNode,boolean isStart) {
        if (curretListNode==null)
        {
            return true;
        }
        if (currentTreeNode==null)
        {
            return false;
        }
        /**
         * ????????????????????????:
         * 1:??????currentNode???????????????TreeNode?????????
         *   a.????????????treeNode???????????????????????????????????????????????????
         *   b.????????????treeNode????????????????????????????????????false
         * 2:??????currentNode????????????TreeNode??????????????????????????????dfs??????????????????????????????
         */
        if (curretListNode.val!=currentTreeNode.val)
        {
            if (isStart)
            {
                boolean leftDfsAnsw = dfs(curretListNode, currentTreeNode.left, isStart);
                if (leftDfsAnsw)
                {
                    return true;
                }
                boolean rightDfsAnsw = dfs(curretListNode, currentTreeNode.right, isStart);
                if (rightDfsAnsw)
                {
                    return true;
                }
                return false;
            }
            else
            {
                return false;
            }
        }
        else
        {
            boolean leftDfsAnsw=dfs(curretListNode.next, currentTreeNode.left, false);
            if (leftDfsAnsw)
            {
                return true;
            }
            boolean rightDfsAnsw=dfs(curretListNode.next,currentTreeNode.right,false);
            if (rightDfsAnsw)
            {
                return true;
            }
            return false;
        }
    }


}
