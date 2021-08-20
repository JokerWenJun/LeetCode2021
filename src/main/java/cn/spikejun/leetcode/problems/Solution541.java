package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution541 {

    @Test
    public void test()
    {
        String s="abcd";
        String s1 = reverseStr(s, 2);
        System.out.println(s1);
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i=0;
        while (i<chars.length)
        {
            if (i+2*k-1<chars.length)
            {
                int left=i;
                int right=i+k-1;
                reverseArray(left,right,chars);
                i=i+2*k;
            }
            else
            {
                int leaveStrNum=chars.length-i;
                if (leaveStrNum<k)
                {
                    reverseArray(i,chars.length-1,chars);
                }
                else
                {
                    reverseArray(i,i+k-1,chars);
                }
                i=chars.length;
            }
        }
        return String.valueOf(chars);
    }

    private void reverseArray(int left, int right, char[] chars) {
        while (left<right)
        {
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
    }


}
