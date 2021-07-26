package cn.spikejun.leetcode.problems;

import java.util.Random;

public class Solution528 {
    private int[]preFix;
    private Random random;
    public Solution528(int[] w) {
        random=new Random();
        int sum=0;
        preFix=new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum+=w[i];
            preFix[i]=sum;
        }
    }

    public int pickIndex() {
        int total=preFix[preFix.length-1];
        int anInt = random.nextInt(total);
        //
        int left=0;
        int right=preFix.length-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (preFix[mid]>anInt)
            {
                right=mid;
            }
            else
            {
                left=left+1;
            }
        }
        return left;
    }

}
