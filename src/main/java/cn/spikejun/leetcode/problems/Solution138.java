package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {

    @Test
    public void test()
    {

    }




    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //旧节点--新节点
        Map<Node,Node>oldAndNewNode=new HashMap<>();
        Node current=head;
        dfs(current,oldAndNewNode);
        return  oldAndNewNode.get(head);
    }

    private void dfs(Node current,Map<Node,Node>map) {
        if (current==null)
        {
            return;
        }
        Node newNode=new Node(current.val);
        map.put(current,newNode);
        dfs(current.next,map);
        //先处理next指针
        if (current.next!=null)
        {
            Node currentNextNode = map.get(current.next);
            newNode.next=currentNextNode;
        }
        //再处理random
        if (current.random!=null)
        {
            newNode.random=map.get(current.random);
        }
    }
}
