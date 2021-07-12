package cn.spikejun.leetcode.problems;

public class Solution275 {

    public int hIndex(int[] citations) {
     int max=0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i]>=citations.length-i)
            {
                return citations.length-i;
            }
            else
            {
                max=Math.max(max,citations[i]);
            }
        }
        return max;
    }

}
