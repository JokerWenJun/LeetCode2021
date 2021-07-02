package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1208 {

    @Test
    public void test()
    {
        String a= "abcd";
        String b="cdef";
        System.out.println(equalSubstring(a,b,3));
    }


    public int equalSubstring(String s, String t, int maxCost) {
        char[] aCharArray = s.toCharArray();;
        char[] bCharArry = t.toCharArray();
        int left=0;
        int right=0;
        int currentCost=0;
        int maxCount=0;
        while (right<aCharArray.length)
        {
            currentCost=currentCost+Math.abs(aCharArray[right]-bCharArry[right]);
            if (currentCost<=maxCost)
            {
                maxCount=Math.max(right-left+1,maxCount);
            }
            else
            {
                currentCost-=Math.abs(aCharArray[left]-bCharArry[left]);
                left++;
            }
            right++;
        }
        return maxCount;
    }


}
