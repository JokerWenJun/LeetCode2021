package cn.spikejun.leetcode.problems;

public class SolutionOffer15 {


    public int hammingWeight(int n) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            int current=n>>i&1;
            if (current==1)
            {
                count++;
            }
        }
        return count;
    }


}
