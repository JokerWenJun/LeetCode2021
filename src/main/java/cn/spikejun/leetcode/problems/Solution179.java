package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {

    @Test
    public void test()
    {
        int[]nums=new int[]{0,0};
        String s = largestNumber(nums);
        System.out.println(s);
    }


    public String largestNumber(int[] nums) {
        String[]strings=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i]=String.valueOf(nums[i]);
        }
        //sort
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+""+o2;
                String s2=o2+""+o1;
                return s2.compareTo(s1);
            }
        });
        StringBuffer buffer=new StringBuffer();
        boolean first=true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("0")&&first)
            {
                continue;
            }
            if (!strings[i].equals("0"))
            {
                first=false;
            }
            buffer.append(strings[i]);
        }
        if (buffer.toString().equals(""))
        {
            return "0";
        }
        return buffer.toString();
    }
}
