package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

public class Solution92 {

    @Test
    public void test()
    {
        ListNode head=new ListNode(3);
        ListNode current=head;
        current.next=new ListNode(5);
        current=current.next;
//        current.next=new ListNode(3);
//        current=current.next;
//        current.next=new ListNode(4);
//        current=current.next;
//        current.next=new ListNode(5);
//        current=current.next;
        ListNode listNode = reverseBetween(head, 1, 2);
        System.out.println("!!!");
    }



    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right)
        {
            return head;
        }
        ListNode preNode=new ListNode(1111111);
        preNode.next=head;
        ListNode firstfirstNode=preNode;
        ListNode current=head;
        int count=1;
        while (count!=left)
        {
            preNode=current;
            current=current.next;
            count++;
        }
        ListNode leftNode=current;
        ListNode firstNode=current;
        current=current.next;
        count++;
        while (count!=right)
        {
            ListNode moveNode=current;
            current=current.next;
            moveNode.next=firstNode;
            firstNode=moveNode;
            count++;
        }
        ListNode rightNode=current;
        ListNode endNode=rightNode.next;
        rightNode.next=firstNode;
        firstNode=rightNode;
        preNode.next=rightNode;
        leftNode.next=endNode;
        return firstfirstNode.next;
    }
}
