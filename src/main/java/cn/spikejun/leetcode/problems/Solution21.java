package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

import java.util.List;

public class Solution21 {

    @Test
    public void test()
    {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(1);
        ListNode c1=listNode1;
        ListNode c2=listNode2;

        c1.next=new ListNode(2);
        c1=c1.next;
        c1.next=new ListNode(4);
        c1=c1.next;

        c2.next=new ListNode(3);
        c2=c2.next;
        c2.next=new ListNode(4);
        c2=c2.next;

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println("1");

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode begin;
        if (l1==null&&l2==null)
        {
            return null;
        }
        if (l1==null)
        {
            return l2;
        }
        if (l2==null)
        {
            return l1;
        }
        if (l1.val>=l2.val)
        {
            begin=l2;
            l2=l2.next;
        }
        else
        {
            begin=l1;
            l1=l1.next;
        }
        ListNode current=begin;
        while (l1!=null||l2!=null)
        {
            if (l1==null)
            {
                current.next=l2;
                break;
            }
            if (l2==null)
            {
                current.next=l1;
                break;
            }

            if (l1.val>= l2.val)
            {
                current.next=l2;
                l2=l2.next;
                current=current.next;
            }
            else
            {
                current.next=l1;
                l1=l1.next;
                current=current.next;
            }
        }
        return begin;
    }
}
