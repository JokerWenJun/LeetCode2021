package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

public class Solution82 {

    @Test
    public void test()
    {
        ListNode head=new ListNode(1);
        ListNode current=head;
        current.next=new ListNode(1);
        current=current.next;
        current.next=new ListNode(1);
        current=current.next;
        current.next=new ListNode(2);
        current=current.next;
        current.next=new ListNode(2);
        current=current.next;
//        current.next=new ListNode(4);
//        current=current.next;
//        current.next=new ListNode(5);
//        current=current.next;
        ListNode listNode = deleteDuplicates(head);
        System.out.println("!!!!");
    }


    public ListNode deleteDuplicates(ListNode head) {

        if (head==null)
        {
            return null;
        }


        ListNode hehead=new ListNode(101);
        hehead.next=head;
        ListNode current=head;
        ListNode pre=hehead;
        int count=1;
        while (current.next!=null)
        {
            if (current.val==current.next.val)
            {
                current.next=current.next.next;
                count++;
            }
            else if (current.val!=current.next.val)
            {
                if (count>1)
                {
                    pre.next=current.next;
                    current=pre.next;
                    count=1;
                }
                else
                {
                    pre=current;
                    current=current.next;
                }
            }
        }
        //judge the last element of the node
        if (count>1)
        {
            pre.next=null;
        }
        return hehead.next;
    }


}
