package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

import java.util.List;

public class Solution160 {


    @Test
    public void test()
    {
        ListNode headA=new ListNode(3);
        ListNode headB=new ListNode(2);

        ListNode curA=headA;
        ListNode curB=headB;

        curB.next=curA;


//        curA.next=new ListNode(1);
//        curA=curA.next;
//        curA.next=new ListNode(8);
//        curA=curA.next;
//
//
//        curB.next=new ListNode(5);
//        curB=curB.next;
//        curB.next=new ListNode(0);
//        curB=curB.next;
//        curB.next=new ListNode(1);
//        curB=curB.next;
//        curB.next=curA;
//        curB=curB.next;
//        curB.next=new ListNode(4);
//        curB=curB.next;
//        curB.next=new ListNode(5);
//        curB=curB.next;



        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        while (true)
        {
            //如果A，B同时为null，则当前没有交点
            if (curA==null&&curB==null)
            {
                return null;
            }
            if (curA==null)
            {
                curA=headB;
            }
            if (curB==null)
            {
                curB=headA;
            }
            if (curB==curA)
            {
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
    }


}
