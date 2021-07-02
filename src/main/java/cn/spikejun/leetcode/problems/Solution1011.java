package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1011 {

    @Test
    public void test()
    {
        int[]weights=new int[]{10,50,100,100,50,100,100,100};
        int i = shipWithinDays(weights, 5);
        System.out.println(i);
    }


    public int shipWithinDays(int[] weights, int D) {
        int min=weights[0];
        int max=0;
        //创建左边界，右边界
        for (int i = 0; i < weights.length; i++) {
            max+=weights[i];
            min=Math.max(min,weights[i]);
        }
        int left=min;
        int right=max;
        while (left<=right)
        {
            //当前运载能力
            int mid=left+(right-left)/2;
            //根据运载能力算出天数
            int days = getDays(weights, mid);
            if (days==D)
            {
                return mid;
            }
            else if (days<D)
            {
                right=mid-1;
            }
            //days>D
            else
            {
                left=mid+1;
            }
        }
        return left;
    }

    private int getDays(int[]weights,int boat)
    {
        int need = 1, cur = 0;
        for (int weight: weights) {
            if (cur + weight > boat) {
                ++need;
                cur = 0;
            }
            cur += weight;
        }
        return need;
    }

}
