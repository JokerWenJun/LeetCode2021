package cn.spikejun.leetcode.problems;

import javax.management.Query;
import java.util.*;

public class Solution133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }



    public Node cloneGraph(Node node) {
        if (node==null)
        {
            return null;
        }


        Map<Node,Node>cloneMap=new HashMap<>();
        Queue<Node>queue=new ArrayDeque<>();
        queue.offer(node);
        cloneMap.put(node,new Node(node.val));
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                Node clonePoll = cloneMap.get(poll);
                List<Node> neighbors = poll.neighbors;
                for (Node neighbor : neighbors) {
                    if (!cloneMap.containsKey(neighbor))
                    {
                        queue.offer(neighbor);
                        cloneMap.put(neighbor,new Node(neighbor.val));
                    }
                    clonePoll.neighbors.add(cloneMap.get(neighbor));
                }
            }
        }
        return cloneMap.get(node);
    }






}
