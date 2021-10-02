package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution848 {

    @Test
    public void test()
    {
        String s="gr";
        int[]arr=new int[]{5,7};
        String s1 = shiftingLetters(s, arr);
        System.out.println(s1);
    }

    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        char[]answ=new char[s.length()];

        //create a variable that the length of s
        int n=s.length();

        //first we need to solve the last element
        char lastElement=chars[chars.length-1];
        int lastMove=shifts[n-1];
        int lastIndex=(lastElement-'a'+lastMove)%26;
        char newLastChar= (char) ('a'+lastIndex);

        answ[n-1]=newLastChar;

        for (int i = n-2; i>=0; i--) {
            char currentChar=chars[i];
            char currentPreChar=chars[i+1];
            int length=currentChar-currentPreChar;
            int newLength=(length+shifts[i])%26;
            if (newLength<0)
            {
                newLength=26+newLength;
            }
            int newCharIndex=(answ[i+1]-'a'+newLength)%26;
            char newChar= (char) (newCharIndex+'a');
            answ[i]=newChar;
        }
        return String.valueOf(answ);
    }

}
