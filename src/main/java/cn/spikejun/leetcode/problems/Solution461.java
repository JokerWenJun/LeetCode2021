package cn.spikejun.leetcode.problems;

public class Solution461 {

    public int maxInt=30;
    public int hammingDistance(int x, int y) {

        int answ=0;
        for (int i = 0; i < maxInt; i++) {
            if ((x>>i&1)!=(y>>i&1))
            {
                answ++;
            }
        }
        return answ;
    }

}
