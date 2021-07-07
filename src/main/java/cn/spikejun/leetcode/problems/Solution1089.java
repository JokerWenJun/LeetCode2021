package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1089 {

    @Test
    public void test()
    {
        int[]arr=new int[]{0,0,0,0,0,0,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    //使用二分法
    public void duplicateZeros(int[] arr) {
        int length=arr.length;
        int hidZero=0;
        int flag=length-1;
        for (int i = 0; i < arr.length; i++) {
            if (i+hidZero==length-1)
            {
                flag=i;
                break;
            }
            if (arr[i]==0)
            {
                if (i+hidZero+1==length-1)
                {
                    flag=i;
                    break;
                }
                hidZero++;
            }
        }
        int j=length-1;
        for (int i = flag; i >= 0; i--) {
            arr[j]=arr[i];
            j--;
            if (arr[i]==0)
            {
                if (i==flag&&(hidZero+flag)==(length-1))
                {
                    continue;
                }
//                if (i!=flag)
//                {
                    arr[j]=0;
                    j--;
//                }
            }
        }
    }
}
