package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

public class Solution148 {

    @Test
    public void test()
    {
        ListNode root=new ListNode(4);
        root.next=new ListNode(19);
        ListNode current=root;
        current=current.next;
        current.next=new ListNode(14);
        current=current.next;
        current.next=new ListNode(5);
        current=current.next;
        current.next=new ListNode(-3);
        current=current.next;
        current.next=new ListNode(1);
        current=current.next;
        current.next=new ListNode(8);
        current=current.next;
        current.next=new ListNode(5);
        current=current.next;
        current.next=new ListNode(11);
        current=current.next;
        current.next=new ListNode(15);
        current=current.next;
        ListNode listNode = sortList(root);
        System.out.println("!!!!!!");
    }



    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null)
        {
            return head;
        }
        ListNode slowNode=head;
        ListNode firstNode=head.next;
        while (firstNode!=null&&firstNode.next!=null)
        {
            slowNode=slowNode.next;
            firstNode=firstNode.next.next;
        }
        ListNode nextHead = slowNode.next;
        slowNode.next=null;
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(nextHead);
        //进行合并
        ListNode newHead=mergeTwoList(leftHead,rightHead);
        return newHead;
    }

    private ListNode mergeTwoList(ListNode leftHead, ListNode rightHead) {
        if (leftHead==null)
        {
            return rightHead;
        }
        if (rightHead==null)
        {
            return leftHead;
        }
        ListNode newHead=new ListNode(1);
        ListNode current=newHead;
        ListNode currentLeftNode=leftHead;
        ListNode currentRightNode=rightHead;
        while (currentLeftNode!=null&&currentRightNode!=null)
        {
            if (currentLeftNode.val==currentRightNode.val)
            {
                current.next=currentLeftNode;
                currentLeftNode=currentLeftNode.next;
                current=current.next;
                current.next=currentRightNode;
                currentRightNode=currentRightNode.next;
                current=current.next;
            }
            else if (currentLeftNode.val>currentRightNode.val)
            {
                current.next=currentRightNode;
                current=current.next;
                currentRightNode=currentRightNode.next;
            }
            else if (currentLeftNode.val<currentRightNode.val)
            {
                current.next=currentLeftNode;
                current=current.next;
                currentLeftNode=currentLeftNode.next;
            }
        }
        if (currentLeftNode!=null)
        {
            current.next=currentLeftNode;
        }
        else if (currentRightNode!=null)
        {
            current.next=currentRightNode;
        }
        return newHead.next;
    }

}
