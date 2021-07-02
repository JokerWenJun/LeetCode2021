package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution264 {


    @Test
    public void test()
    {
        System.out.println(nthUglyNumber(7));
    }


    public int nthUglyNumber(int n)
    {
        if (n==1)
        {
            return 1;
        }
        int []nums=new int[n];
        nums[0]=1;
        int indexNumber2=0;
        int indexNumber3=0;
        int indexNumber5=0;

        for (int i = 1; i < nums.length; i++) {
            int currentIndexNumber2=nums[indexNumber2]*2;
            int currentIndexNumber3=nums[indexNumber3]*3;
            int currentIndexNumber5=nums[indexNumber5]*5;
            int answ=Math.min(currentIndexNumber2,Math.min(currentIndexNumber3,currentIndexNumber5));
            nums[i]=answ;
            if (answ==currentIndexNumber2)
            {
                indexNumber2++;
            }
            if (answ==currentIndexNumber3)
            {
                indexNumber3++;
            }
            if (answ==currentIndexNumber5)
            {
                indexNumber5++;
            }
        }

        return nums[n-1];
    }

    public int nthUglyNumber1(int n) {
        if (n==1)
        {
            return 1;
        }
        int i=1;
        int count=1;
        Set<Integer> urglyNumber=new HashSet();
        urglyNumber.add(1);
        while (count!=n)
        {
            i++;
            if (i%2==0)
            {
                if (urglyNumber.contains(i/2))
                {
                    urglyNumber.add(i);
                    count++;
                }
            }
            else if (i%3==0)
            {
                if (urglyNumber.contains(i/3))
                {
                    urglyNumber.add(i);
                    count++;
                }
            }
            else if (i%5==0)
            {
                if (urglyNumber.contains(i/5))
                {
                    urglyNumber.add(i);
                    count++;
                }
            }

        }
        return i;

    }
}
