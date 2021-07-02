package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution1720 {

    @Test
    public void test()
    {
        int[]encode=new int[]{6,2,7,3};
        int[] decode = decode(encode, 4);
        System.out.println(Arrays.toString(decode));
    }


    public int[] decode(int[] encoded, int first) {
        int[]decodeArr=new int[encoded.length+1];
        decodeArr[0]=first;
        for (int i = 1; i < decodeArr.length; i++) {
            decodeArr[i]=decodeArr[i-1]^encoded[i-1];
        }
        return decodeArr;
    }



}
