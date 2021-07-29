package cn.spikejun.leetcode.problems;

import java.util.*;

public class Solution380 {
    class RandomizedSet {
        //value-index
        private Map<Integer,Integer> map;
        private List<Integer>list;
        private Random random;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map=new HashMap<>();
            list=new ArrayList<>();
            random=new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val))
            {
                return false;
            }
            else
            {
                list.add(val);
                map.put(val,list.size()-1);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val))
            {
                return false;
            }
            else {
                int removeValueIndex=map.get(val);
                int lastValue=list.get(list.size()-1);
                map.put(val,list.size()-1);
                map.put(lastValue,removeValueIndex);
                map.remove(val);
                list.set(removeValueIndex,lastValue);
                list.set(list.size()-1,val);
                list.remove(list.size()-1);
            }
                return true;
            }
            /** Get a random element from the set. */
            public int getRandom() {
                int size = list.size();
                int i = random.nextInt(size);
                return list.get(i);
            }
        }

}
