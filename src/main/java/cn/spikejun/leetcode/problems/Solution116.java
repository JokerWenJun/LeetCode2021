package cn.spikejun.leetcode.problems;

public class Solution116 {

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

    public Node connect(Node root) {
        Node current=root;
        if (root==null)
        {
            return null;
        }
        while (current.left!=null)
        {
            Node currentRow=current;
            while (currentRow!=null)
            {
                currentRow.left.next=currentRow.right;
                if (currentRow.next!=null)
                {
                    currentRow.right.next=currentRow.next.left;
                }
                currentRow=currentRow.next;
            }
            current=current.left;
        }
        return root;
    }
}
