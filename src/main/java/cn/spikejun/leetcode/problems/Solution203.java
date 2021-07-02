package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

import java.util.List;

public class Solution203 {

    @Test
    public void test()
    {
        ListNode head=new ListNode(1);
        ListNode start=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        head=head.next;
        head.next=new ListNode(6);
        head=head.next;

        ListNode listNode = removeElements(start, 1);
        System.out.println(listNode.val);
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
        {
            return head;
        }
        ListNode curNode=head;
        ListNode preNode=null;
        while (curNode!=null)
        {
            if (curNode.val==val)
            {
                if (preNode==null)
                {
                    curNode=curNode.next;
                    head=curNode;
                }
                else
                {
                    preNode.next=curNode.next;
                    curNode=curNode.next;
                }
            }
            else
            {
                preNode=curNode;
                curNode=curNode.next;
            }
        }
        return head;
    }

}
