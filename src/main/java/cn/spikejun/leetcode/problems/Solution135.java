package cn.spikejun.leetcode.problems;

import java.util.Arrays;

public class Solution135 {

    public int candy(int[] ratings) {
        int[]left=new int[ratings.length];
        int[]right=new int[ratings.length];
        int answ=0;
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < left.length; i++) {
            if (ratings[i]>ratings[i-1])
            {
                left[i]=left[i-1]+1;
            }
        }
        answ+=left[ratings.length-1];
        for (int i = right.length-2; i>=0; i--) {
            if (ratings[i]>ratings[i+1])
            {
                right[i]=right[i+1]+1;
            }
            answ=answ+Math.max(left[i],right[i]);
        }
        return answ;
    }
}
