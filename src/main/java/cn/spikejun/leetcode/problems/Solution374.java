package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution374 {

    private int target=6;

    private int guess(int n)
    {
        if (n==target)
        {
            return 0;
        }
        if (target<n)
        {
            return 1;
        }
        if (n<target)
        {
            return -1;
        }
        return -10086;
    }


    @Test
    public void test()
    {
        int i = guessNumber(10);
        System.out.println(i);
    }

    public int guessNumber(int n) {
        int left=1;
        int right=n;
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            int guess = guess(mid);
            if (guess==0)
            {
                return mid;
            }
            else if (guess>0)
            {
                right=mid-1;
            }
            else if (guess<0)
            {
                left=mid+1;
            }
        }
        return left;
    }
}
