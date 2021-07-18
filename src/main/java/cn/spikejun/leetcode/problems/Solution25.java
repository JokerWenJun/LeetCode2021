package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

import java.util.List;

public class Solution25 {

    @Test
    public void test(){
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
        ListNode listNode = reverseKGroup(head, 2);
        System.out.println("!!!");
    }


    private ListNode preListNode;
    private ListNode fixListNode;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1)
        {
            return head;
        }
        int length=0;
        ListNode current=head;
        while (current!=null)
        {
            length++;
            current=current.next;
        }
        ListNode currentHead=head;
        ListNode firstFirstNode=new ListNode(1);
        firstFirstNode.next=head;
        preListNode=firstFirstNode;
        current=firstFirstNode;
        int count=length/k;
        int i=1;
       while(i<=count) {
            current=current.next;
            dfs(preListNode,current,1,k);
            preListNode=current;
            i++;
        }
        return firstFirstNode.next;
    }

    private void dfs(ListNode preNode,ListNode current, int i, int k) {
        if (i==k)
        {
            fixListNode=current.next;
            current.next=preNode;
            preListNode.next=current;
            return;
        }
        ListNode nextNode=current.next;
        dfs(current,nextNode,i+1,k);
        if (i==1)
        {
            current.next=fixListNode;
        }
        else
        {
            current.next=preNode;
        }
    }
}
