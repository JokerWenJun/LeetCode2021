package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;

import java.util.HashMap;
import java.util.Map;

public class SolutionOffer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Map<Integer,ListNode> map=new HashMap<>();
        int index=1;
        ListNode current=head;
        while (current!=null)
        {
            map.put(index,current);
            index++;
            current=current.next;
        }
        return map.get(index-k);
    }
}
