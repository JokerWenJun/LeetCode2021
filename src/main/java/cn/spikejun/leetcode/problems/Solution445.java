package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution445 {

    @Test
    public void test()
    {
        ListNode listNode1=new ListNode(7);
        ListNode c1=listNode1;
        c1.next=new ListNode(2);
        c1=c1.next;
        c1.next=new ListNode(4);
        c1=c1.next;
        c1.next=new ListNode(3);
        c1=c1.next;
        ListNode listNode2=new ListNode(5);
        ListNode c2=listNode2;
        c2.next=new ListNode(6);
        c2=c2.next;
        c2.next=new ListNode(4);
        c2=c2.next;
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.val);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Map<Integer,ListNode>list1Map=new HashMap<>();
        Map<Integer,ListNode>list2Map=new HashMap<>();
        ListNode currentListOne=l1;
        ListNode currentListTwo=l2;
        int index=0;
        while (currentListOne!=null||currentListTwo!=null)
        {
            if (currentListOne!=null)
            {
                list1Map.put(index,currentListOne);
                currentListOne=currentListOne.next;
            }
            if (currentListTwo!=null)
            {
                list2Map.put(index,currentListTwo);
                currentListTwo=currentListTwo.next;
            }
            index++;
        }
        Map<Integer,ListNode>list3Map=new HashMap<>();
        int size1=list1Map.size()-1;
        int siez2=list2Map.size()-1;
        index=0;
        int flag=0;
        while (size1>=0||siez2>=0)
        {
            int num1=0;
            int num2=0;
            if (size1>=0)
            {
                num1=list1Map.get(size1).val;
                size1--;
            }
            if (siez2>=0)
            {
                num2=list2Map.get(siez2).val;
                siez2--;
            }
            int num3=num1+num2+flag;
            flag=0;
            if (num3>=10)
            {
                flag=1;
                num3=num3-10;
            }
            list3Map.put(index,new ListNode(num3));
            index++;
        }
        if (flag==1)
        {
            list3Map.put(index,new ListNode(1));
        }
        int size = list3Map.size();
        ListNode pre=new ListNode(-1);
        ListNode hehead=pre;
        for (int i = size-1; i >=0; i--) {
            pre.next=list3Map.get(i);
            pre=list3Map.get(i);
        }
        return hehead.next;
    }
}
