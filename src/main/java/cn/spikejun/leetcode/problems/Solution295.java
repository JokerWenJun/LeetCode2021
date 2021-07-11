package cn.spikejun.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution295 {

    class MedianFinder {

        private PriorityQueue<Integer>minQueue;
        private PriorityQueue<Integer>maxQueue;
        private int count=0;

        /** initialize your data structure here. */
        public MedianFinder() {
            minQueue=new PriorityQueue<>();
            maxQueue=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }

        public void addNum(int num) {
            //当前两个堆保持数量上的相等
            if (count%2==0)
            {
                maxQueue.add(num);
                Integer currentMax = maxQueue.poll();
                minQueue.add(currentMax);
                Integer poll = minQueue.poll();
                maxQueue.add(poll);
            }
            //为奇数
            else
            {
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }
            count++;
        }

        public double findMedian() {
            if (count%2!=0)
            {
                Integer peek = maxQueue.peek();
                return peek;
            }
            else {
                Integer peek1 = maxQueue.peek();
                Integer peek2 = minQueue.peek();
                double mid=(peek1+peek2)/2.0;
                return mid;
            }
        }
    }


}
