package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution147 {

    @Test
    public void test()
    {
        ListNode root=new ListNode(-1);
        root.next=new ListNode(5);
        ListNode current=root;
        current=current.next;
        current.next=new ListNode(3);
        current=current.next;
        current.next=new ListNode(4);
        current=current.next;
        current.next=new ListNode(0);
        ListNode listNode = insertionSortList(root);
        System.out.println("!!!!!!");
    }


    public ListNode insertionSortList(ListNode head) {
        ListNode current=head;
        ListNode flag=new ListNode(1);
        flag.next=head;
        ListNode pre=null;
        while (current!=null)
        {
            if (current==head)
            {
                pre=current;
                current=current.next;
                continue;
            }
            ListNode headNode=flag.next;
            ListNode preNode=null;
            ListNode nextNode=current.next;
            while (headNode.val<current.val)
            {
               preNode=headNode;
                headNode=headNode.next;
            }
            //判断边界
            if (preNode==null)
            {
                pre.next=current.next;
                current.next=headNode;
                flag.next=current;
                current=pre.next;
            }
            else if (headNode!=current)
            {
                pre.next=current.next;
                preNode.next=current;
                current.next=headNode;
                current=pre.next;
            }
            else
            {
                pre=current;
                current=current.next;
            }
        }
        return flag.next;
    }
}
