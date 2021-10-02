package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class SolutionOffer66 {
    @Test
    public void test()
    {
        int[]a=new int[]{1,2,3,4,5};
        int[] ints = constructArr(a);
        System.out.println(Arrays.toString(ints));
    }
    public int[] constructArr(int[] a) {
        int[]leftToRight=new int[a.length+1];
        int[]rightToLeft=new int[a.length+1];
        leftToRight[0]=1;
        rightToLeft[a.length]=1;
        int sum=1;
        for (int i = 1; i <=a.length; i++) {
            leftToRight[i]=a[i-1]*leftToRight[i-1];
        }
        for (int i =a.length-1; i>=0; i--) {
            rightToLeft[i]=rightToLeft[i+1]*a[i];
        }
        int[]answ=new int[a.length];
        for (int i = 0; i < answ.length; i++) {
            answ[i]=leftToRight[i]*rightToLeft[i+1];
        }
        return answ;
    }
}
