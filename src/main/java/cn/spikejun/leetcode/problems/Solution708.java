package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution708 {

    @Test
    public void test()
    {
        Node first=new Node(3);
//        first.next=first;
        Node current=first;
        current.next=new Node(3);
        current=current.next;
        current.next=new Node(5);
        current=current.next;
        current.next=first;
        Node insert = insert(first, 0);
        System.out.println(insert);
    }



    class Node {
        public int val;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        //先边界判断
        Node newNode=new Node(insertVal);
        //当前链表为空
        if (head==null)
        {
            newNode.next=newNode;
            return newNode;
        }
        //保存初始节点，结束的时候直接返回
        Node current=head;
        //先遍历一边判断出开始节点和结束节点
        Node firstNode=current;
        Node lastNode=current;
        //这个pre是防止当前链表全是一个数字
        Node pre=current;
        while (current.val<=current.next.val&&pre!=current.next)
        {
            current=current.next;
        }
        //此时current为最后一个节点，current.next为第一个节点
        lastNode=current;
        firstNode=current.next;
        //先切断环形
        lastNode.next=null;
        current=firstNode;
        //判断边界
        if (newNode.val<=firstNode.val)
        {
            newNode.next=firstNode;
            firstNode=newNode;
        }
        else if (newNode.val>=lastNode.val)
        {
            lastNode.next=newNode;
            lastNode=newNode;
        }
        //在中间
        else
        {
            while (newNode.val>current.next.val)
            {
                current=current.next;
            }
            //此时newNode就应该在current和current.next中间
            newNode.next=current.next;
            current.next=newNode;
        }
        lastNode.next=firstNode;
        return head;
    }
}
