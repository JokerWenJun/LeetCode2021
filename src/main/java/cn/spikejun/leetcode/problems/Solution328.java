package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;

import java.util.List;

public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null)
        {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = oddHead.next;
        ListNode preOdd=oddHead;
        ListNode preEven=evenHead;
        int index=3;
        ListNode current=evenHead.next;
        while (current!=null)
        {
            if (index%2==0)
            {
                preEven.next=current;
                preEven=preEven.next;
            }
            else
            {
                preOdd.next=current;
                preOdd=preOdd.next;
            }
            current=current.next;
            index++;
        }
        preOdd.next=evenHead;
        preEven.next=null;
        return head;
    }

}
