package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        //走一步
        ListNode slow=head;
        //走两步
        ListNode first=head;
        //
        ListNode common=null;
        while (slow!=null&&first!=null)
        {
            first=first.next;
            if (first==null)
            {
                return null;
            }
            first=first.next;
            if (first==null)
            {
                return null;
            }
            slow=slow.next;
            if (slow==null)
            {
                return null;
            }
            if (first==slow)
            {
                common=slow;
                break;
            }
        }
        ListNode begin=head;
        while (begin!=slow)
        {
            begin=begin.next;
            slow=slow.next;
        }
        return slow;
    }
}
