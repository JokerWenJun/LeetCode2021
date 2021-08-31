package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

public class Solution24 {

    @Test
    public void test()
    {
        ListNode head=new ListNode(1);
        ListNode current=head;
        current.next=new ListNode(2);
        current=current.next;
        current.next=new ListNode(3);
        current=current.next;
        current.next=new ListNode(4);
        current=current.next;
        current.next=new ListNode(5);
        current=current.next;
        ListNode listNode = swapPairs(head);
        System.out.println("!!!");
    }


    public ListNode swapPairs(ListNode head) {
        if (head==null)
        {
            return null;
        }
        int count=0;
        ListNode preHead=new ListNode(1);
        preHead.next=head;
        ListNode before=preHead;
        ListNode after=null;
        ListNode current=head;
        ListNode pre=preHead;
        while (current!=null)
        {
            count++;
            if (count==2)
            {
                count=0;
                before.next=current;
                pre.next=current.next;
                current.next=pre;
                before=pre;
                current=pre.next;
            }
            else if (count==1)
            {
                pre=current;
                current=current.next;
            }
        }
        return preHead.next;
    }
}
