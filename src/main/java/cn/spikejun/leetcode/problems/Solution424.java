package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution424 {

    @Test
    public void test()
    {
        String s=new String("AABABBA");
        int i = characterReplacement(s, 1);
        System.out.println(i);
    }


    public int characterReplacement(String s, int k) {
        //转化为char数组
        char[] chars = s.toCharArray();
        int left=0;
        int right=0;
        int maxCount=0;
        int[]arr=new int[26];
        while (right<chars.length)
        {
            arr[chars[right]-'A']++;
            maxCount=Math.max(maxCount,arr[chars[right]-'A']);
            if (right-left+1-maxCount>k)
            {
                arr[chars[left]-'A']--;
                left++;
            }
            right++;
        }
        return right-left;
    }


}
