package cn.spikejun.leetcode.problems;

import java.util.Iterator;

public class Solution284 {

    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer>myIterator;
        private Integer next=null;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
             myIterator=iterator;
             next=iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer answ=next;
            if (myIterator.hasNext())
            {
                next=myIterator.next();
            }
            else
            {
                next=null;
            }
            return answ;
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }
    }
}
