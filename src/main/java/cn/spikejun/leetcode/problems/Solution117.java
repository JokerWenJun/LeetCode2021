package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    @Test
    public void test()
    {
        Node root=new Node(0);
        root.left=new Node(2);
        root.right=new Node(4);
        Node current=root;
        current=current.left;
        current.left=new Node(1);
        current=current.left;
        current.left=new Node(5);
        current.right=new Node(1);
        current=root;
        current=current.right;
        current.left=new Node(3);
        current=current.left;
        current.right=new Node(6);
        current=root.right;
        current.right=new Node(-1);
        current=current.right;
        current.right=new Node(8);
        Node connect = connect(root);
        System.out.println("!!!!");
    }
    public Node connect(Node root) {

        Node current=root;
        handleEachRow(current);
        return root;
    }

    private void handleEachRow(Node head) {
        if (head==null)
        {
            return;
        }
        Node nextFirstNode=null;
        Node pre=null;
        while (head!=null)
        {
            if (head.left==null&&head.right==null)
            {
                head=head.next;
                continue;
            }
            if (head.left!=null&&head.right!=null)
            {
                if (nextFirstNode==null)
                {
                    nextFirstNode=head.left;
                    head.left.next=head.right;
                    pre=head.right;
                }
                else
                {
                    pre.next=head.left;
                    head.left.next=head.right;
                    pre=head.right;
                }
            }
            else if (head.left!=null&&head.right==null)
            {
                if (nextFirstNode==null)
                {
                    nextFirstNode=head.left;
                    pre=head.left;
                }
                else
                {
                    pre.next=head.left;
                    pre=head.left;
                }
            }else if (head.left==null&&head.right!=null)
            {
                if (nextFirstNode==null)
                {
                    nextFirstNode=head.right;
                    pre=head.right;
                }
                else
                {
                    pre.next=head.right;
                    pre=head.right;
                }
            }
            head=head.next;
        }
        handleEachRow(nextFirstNode);
    }
}
