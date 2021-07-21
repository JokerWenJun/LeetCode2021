package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

public class SolutionOffer52 {


    @Test
    public void test()
    {
        ListNode headA=new ListNode(4);
        ListNode headB=new ListNode(5);

        ListNode curA=headA;
        ListNode curB=headB;

//        curB.next=curA;


        curA.next=new ListNode(1);
        curA=curA.next;
        curA.next=new ListNode(8);
        curA=curA.next;


        curB.next=new ListNode(5);
        curB=curB.next;
        curB.next=new ListNode(0);
        curB=curB.next;
        curB.next=new ListNode(1);
        curB=curB.next;
        curB.next=curA;
        curB=curB.next;
        curB.next=new ListNode(4);
        curB=curB.next;
        curB.next=new ListNode(5);
        curB=curB.next;



        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA=headA;
        ListNode currentB=headB;
        ListNode answ=null;
        if (headA==null||headB==null)
        {
            return null;
        }
        while (currentA!=null||currentB!=null)
        {
            if (currentA==null)
            {
                currentA=headB;
            }
            if (currentB==null)
            {
                currentB=headA;
            }
            if (currentA==currentB)
            {
                answ=currentA;
                break;
            }
            else
            {
                currentA=currentA.next;
                currentB=currentB.next;
            }
        }
        return answ;
    }
}
