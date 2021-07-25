package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5823 {

    @Test
    public void test()
    {
        String s="zbax";
        int lucky = getLucky(s, 2);
        System.out.println(lucky);
    }


    public int getLucky(String s, int k) {
        int[]nums=new int[s.length()];
        char[] chars = s.toCharArray();
        String changeArray = new String();
        for (int i = 0; i < chars.length; i++) {
            nums[i]=chars[i]-'a'+1;
            changeArray=changeArray+nums[i]+"";
        }
        for (int i = 0; i < k; i++) {
            int current=0;
            char[] array = changeArray.toCharArray();
            for (int j = 0; j < array.length; j++) {
                current+=array[j]-'0';
            }
            changeArray=String.valueOf(current);
        }
        return Integer.valueOf(changeArray);
    }
}
