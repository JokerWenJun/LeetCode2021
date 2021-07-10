package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

import java.util.List;

public class Solution19 {


    @Test
    public void test()
    {
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
        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println("!!!!");
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[]listNodes=new ListNode[30];
        int length=0;
        ListNode current=head;
        while (current!=null)
        {
            listNodes[length]=current;
            current=current.next;
            length++;
        }
        if (length==1)
        {
            if (n>=1)
            {
                return null;
            }
            if (n==0)
            {
                return head;
            }
        }



        if (n==1)
        {
            listNodes[length-2].next=null;
            return head;
        }
        else if (n==length)
        {
            return head.next;
        }
         else
        {
            //找到被删除的节点
            ListNode deleteNode=listNodes[length-1-(n-1)];
            //找到被删除节点的前面的节点
            ListNode beforeDeleteNode=listNodes[length-n-1];
            beforeDeleteNode.next=deleteNode.next;
            return head;
        }
    }
}
