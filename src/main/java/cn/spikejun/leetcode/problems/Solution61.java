package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution61 {

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
        ListNode listNode = rotateRight(head, 2);
        System.out.println("!!!");
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)
        {
            return null;
        }
        Map<Integer,ListNode>indexMap=new HashMap<>();
        ListNode current=head;
        int index=0;
        while (current!=null)
        {
            indexMap.put(index,current);
            current=current.next;
            index++;
        }
        int length=indexMap.size();
        int removePosition = k%length;
        if (removePosition==0)
        {
            return head;
        }
        ListNode currentNode=indexMap.get(length-1);
        currentNode.next=head;
        ListNode lastNode=indexMap.get(length-1-removePosition);
        ListNode firstNode=lastNode.next;
        lastNode.next=null;
        return firstNode;
    }
}
