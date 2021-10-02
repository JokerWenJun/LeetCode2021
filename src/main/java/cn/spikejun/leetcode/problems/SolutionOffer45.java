package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionOffer45 {

    @Test
    public void test()
    {
        int[]nums=new int[]{3,30,34,5,9};
        String s = minNumber(nums);
        System.out.println(s);
    }


    public String minNumber(int[] nums) {
        String[]strings=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuffer answBuffer=new StringBuffer();
        for (String string : strings) {
            answBuffer.append(string);
        }
        return answBuffer.toString();
    }
}
