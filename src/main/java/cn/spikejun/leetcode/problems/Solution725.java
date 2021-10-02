package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;

import java.util.List;

public class Solution725 {


    public ListNode[] splitListToParts(ListNode head, int k) {
        //first we need to traverse the list to get the length
        int length=0;
        ListNode current=head;
        while (current!=null)
        {
            length++;
            current=current.next;
        }
        ListNode[]answ=new ListNode[k];
        //second we need to compare the k and length
        //if the k is more than length,we know that we need to add null interval to last 
        if (k>=length)
        {
            current=head;
            for (int i = 0; i < k; i++) {
                if (current!=null)
                {
                    answ[i]=current;
                    current=current.next;
                    answ[i].next=null;
                }
            }
        }
        //if k is strictly less than the length,first we need to use length divided by k , we get the each interval basic length
        //then we need to use length percent length, we get the result which is the more num of the basic num
        else
        {
            int basicNum = length / k;
            int addedNum = length % k;
            current=head;
            ListNode pre=null;
            for (int i = 0; i < k; i++) {
                answ[i]=current;
                for (int j = 0; j < basicNum; j++) {
                    pre=current;
                    current=current.next;
                }
                if (addedNum!=0)
                {
                    pre=current;
                    current=current.next;
                    addedNum--;
                }
                pre.next=null;
            }
        }
        return answ;
    }
}
