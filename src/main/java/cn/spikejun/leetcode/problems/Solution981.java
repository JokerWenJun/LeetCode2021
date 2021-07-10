package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.sql.Time;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution981 {

    @Test
    public void test()
    {
        TimeMap timeMap=new TimeMap();
        timeMap.set("foo","bar",1);
        String foo = timeMap.get("foo", 1);
        String foo1 = timeMap.get("foo", 3);
        timeMap.set("foo","bar2",4);
        String foo2 = timeMap.get("foo", 4);
        String foo3 = timeMap.get("foo", 5);
        System.out.println("!!!!!");

    }



    class TimeMap {

        class TimestampCompare
        {
            public String value;
            public int timestamp;

            public TimestampCompare(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }

            public TimestampCompare() {
            }
        }


        private Map<String, TreeSet<TimestampCompare>>map;

        /** Initialize your data structure here. */
        public TimeMap() {
            this.map=new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeSet<TimestampCompare> timestampCompares = this.map.get(key);
            if (timestampCompares==null)
            {
                timestampCompares=new TreeSet<TimestampCompare>(new Comparator<TimestampCompare>() {
                    @Override
                    public int compare(TimestampCompare o1, TimestampCompare o2) {
                        return o1.timestamp-o2.timestamp;
                    }
                });
                timestampCompares.add(new TimestampCompare(value,timestamp));
                this.map.put(key,timestampCompares);
            }
            else
            {
                timestampCompares.add(new TimestampCompare(value,timestamp));
            }
        }

        public String get(String key, int timestamp) {
            TreeSet<TimestampCompare> timestampCompares = this.map.get(key);
            if (timestampCompares==null)
            {
                return "";
            }
            else
            {
                TimestampCompare floor = timestampCompares.floor(new TimestampCompare("", timestamp));
                if (floor==null)
                {
                    return "";
                }
                else
                {
                    return floor.value;
                }
            }
        }
    }



}
