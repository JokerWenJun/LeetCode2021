package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    };

    @Test
    public void test()
    {
        Node head=new Node(1);
        Node current=head;
        Node pre=null;
        current.next=new Node(2);
        pre=current;
        current=current.next;
        current.prev=pre;

        current.next=new Node(3);
        pre=current;
        current=current.next;
        current.prev=pre;

        current.child=new Node(7);
        Node child1=current.child;
        Node preChild1=null;
        child1.next=new Node(8);
        preChild1=child1;
        child1=child1.next;
        child1.prev=preChild1;
        child1.child=new Node(11);
        Node child2=child1.child;
        Node preChild2=null;
        child2.next=new Node(12);
        preChild2=child2;
        child2=child2.next;
        child2.prev=preChild2;

        child1.next=new Node(9);
        preChild1=child1;
        child1=child1.next;
        child1.prev=preChild1;
        child1.next=new Node(10);
        preChild1=child1;
        child1=child1.next;
        child1.prev=preChild1;



        current.next=new Node(4);
        pre=current;
        current=current.next;
        current.prev=pre;

        current.next=new Node(5);
        pre=current;
        current=current.next;
        current.prev=pre;

        current.next=new Node(6);
        pre=current;
        current=current.next;
        current.prev=pre;
        System.out.println("!!!");
        flatten(head);
    }


    public Node flatten(Node head) {

        Node lastNode=dfs(head);

        return head;
    }
    public Node dfs(Node head)
    {
        Node pre=null;
        Node current=head;
        while (current!=null)
        {
            if (current.child==null)
            {
                pre=current;
                current=current.next;
            }
            else
            {
                Node last = dfs(current.child);
                last.next=current.next;
                current.next=current.child;
                current.child.prev=current;
                current.child=null;
                if (last.next!=null)
                {
                    last.next.prev=last;
                }
                current=last.next;
                pre=last;
            }
        }
        return pre;
    }
}
