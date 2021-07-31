package cn.spikejun.leetcode.problems;

public class Solution426 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    private Node firstNode=null;
    private Node lastNode=null;
    public Node treeToDoublyList(Node root) {
        if (root==null)
        {
            return null;
        }
        //开始对root进行中序遍历
        inOrder(root);
        firstNode.left=lastNode;
        lastNode.right=firstNode;
        return firstNode;
    }

    private void inOrder(Node currentNode) {
        if (currentNode!=null)
        {
            inOrder(currentNode.left);
            if (firstNode==null)
            {
                firstNode=currentNode;
            }
            if (lastNode==null)
            {
                lastNode=currentNode;
            }
            else
            {
                lastNode.right=currentNode;
                currentNode.left=lastNode;
            }
            lastNode=currentNode;
            inOrder(currentNode.right);
        }
    }


}
