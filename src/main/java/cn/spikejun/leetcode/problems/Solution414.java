package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution414 {

    @Test
    public void test()
    {
        int[]nums=new int[]{1,2,-2147483648};
        int i = thirdMax(nums);
        System.out.println(i);
    }


    private long theFirstMaximum= (long) (-Math.pow(2,31)-1);
    private long theSecondMaximum=(long) (-Math.pow(2,31)-2);
    private long theThirdMaximum=(long) (-Math.pow(2,31)-3);
    public int thirdMax(int[] nums) {
        for (int num : nums) {
            if (num>=theFirstMaximum)
            {
                if (num==theFirstMaximum)
                {
                    continue;
                }
                long temp1=theFirstMaximum;
                long temp2 = this.theSecondMaximum;
                theFirstMaximum=num;
                theSecondMaximum=temp1;
                theThirdMaximum=temp2;
                continue;
            }else if (num>=theSecondMaximum)
            {
                if (num==theSecondMaximum)
                {
                    continue;
                }
                long temp2 = this.theSecondMaximum;
                this.theSecondMaximum =num;
                theThirdMaximum=temp2;
                continue;
            }else if (num>theThirdMaximum)
            {
                if (num==theThirdMaximum)
                {
                    continue;
                }
                theThirdMaximum=num;
                continue;
            }
        }
        if (theThirdMaximum<Integer.MIN_VALUE)
        {
            return (int) theFirstMaximum;
        }
        return (int) theThirdMaximum;
    }
}
