package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    @Test
    public void test()
    {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
//        System.out.println(lruCache.get(1));
        lruCache.put(2,3);
//        System.out.println(lruCache.get(2));
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(4));
    }





    class LRUCache {
        class TwoDirectionNode
        {
            public int key;
            public int value;
            public TwoDirectionNode nextNode;
            public TwoDirectionNode preNode;
            public TwoDirectionNode() {
            }
            public TwoDirectionNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        public int count;
        public int cap;
        public Map<Integer,TwoDirectionNode> map;
        public TwoDirectionNode head;
        public TwoDirectionNode end;
        public LRUCache(int capacity) {
            this.cap=capacity;
            count=0;
            map=new HashMap<>();
            head=new TwoDirectionNode();
            end=new TwoDirectionNode();
            head.nextNode=end;
            end.preNode=head;
        }

        public int get(int key) {
            TwoDirectionNode node = map.get(key);
            if (node==null)
            {
                return -1;
            }
            else {
                TwoDirectionNode preNode = node.preNode;
                TwoDirectionNode nextNode = node.nextNode;
                preNode.nextNode=nextNode;
                nextNode.preNode=preNode;
                TwoDirectionNode firstNode = head.nextNode;
                head.nextNode=node;
                node.preNode=head;
                node.nextNode=firstNode;
                firstNode.preNode=node;
                return node.value;
            }
        }

        public void put(int key, int value) {
            TwoDirectionNode node = map.get(key);
            if (node!=null)
            {
                node.value=value;
                TwoDirectionNode nextNode = node.nextNode;
                TwoDirectionNode preNode = node.preNode;
                preNode.nextNode=nextNode;
                nextNode.preNode=preNode;
                TwoDirectionNode firstNode = head.nextNode;
                node.nextNode=firstNode;
                node.preNode=head;
                head.nextNode=node;
                firstNode.preNode=node;
                map.put(key,node);
            }
            else
            {
                if (count<cap)
                {
                    count++;
                    TwoDirectionNode newNode=new TwoDirectionNode(key,value);
                    map.put(key,newNode);
                    TwoDirectionNode firstNode = head.nextNode;
                    newNode.nextNode=firstNode;
                    newNode.preNode=head;
                    head.nextNode=newNode;
                    firstNode.preNode=newNode;
                }
                else {
                    TwoDirectionNode newNode=new TwoDirectionNode(key,value);
                    map.put(key,newNode);
                    TwoDirectionNode lastNode = end.preNode;
                    int oldKey = lastNode.key;
                    TwoDirectionNode oldNode = map.get(oldKey);
                    map.remove(oldKey);
                    //先将最后一个节点移除
                    oldNode.preNode.nextNode=end;
                    end.preNode=oldNode.preNode;
                    //再添加第一个节点
                    TwoDirectionNode firstNode = head.nextNode;
                    newNode.nextNode=firstNode;
                    newNode.preNode=head;
                    head.nextNode=newNode;
                    firstNode.preNode=newNode;
                }
            }
        }
    }
}
