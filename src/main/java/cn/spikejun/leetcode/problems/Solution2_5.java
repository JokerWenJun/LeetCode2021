package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

public class Solution2_5 {


    @Test
    public void test()
    {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1=l1;
        ListNode head2=l2;
        ListNode answHead=null;
        while (l1!=null&&l2!=null)
        {
            int sum=l1.val+l2.val;
            l1.val=sum;
            l2.val=sum;
            l1=l1.next;
            l2=l2.next;
        }
        if (l1==null)
        {
            answHead=head2;
        }
        else {
            answHead=head1;
        }
        ListNode head=answHead;
        while (answHead!=null)
        {
            int val = answHead.val;
            int addNext = val / 10;
            int currentVal = val % 10;
            answHead.val=currentVal;
            if (addNext==0)
            {
                answHead=answHead.next;
                continue;
            }
            if (answHead.next==null)
            {
                answHead.next=new ListNode(addNext);
            }
            else
            {
                ListNode next = answHead.next;
                Integer newNextValue=next.val+addNext;
                next.val=newNextValue;
            }
            answHead=answHead.next;
        }
        return head;
    }
}
