package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;

public class Solution260 {
    private ListNode reverseHead=null;
    public ListNode reverseList(ListNode head) {
        dfs(head,null);
        return  reverseHead;
    }

    private void dfs(ListNode current, ListNode parent) {
        if (current.next!=null)
        {
            dfs(current.next,current);
        }
        else
        {
            reverseHead=current;
        }
        current.next=parent;
    }

}
