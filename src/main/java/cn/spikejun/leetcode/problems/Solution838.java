package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution838 {

    @Test
    public void test()
    {
        String s=".L.R...LR..L..";
        String s1 = pushDominoes(s);

        System.out.println(s1);
    }


    public String pushDominoes(String dominoes) {
        if (dominoes.length()<2)
        {
            return dominoes;
        }
        //在前端和后端添加L和R
        dominoes="L"+dominoes+"R";
        char[] chars = dominoes.toCharArray();
        char currentChar=chars[0];
        int currentLocation=0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]!='.')
            {
                change(chars,currentLocation,i,currentChar,chars[i]);
                currentLocation=i;
                currentChar=chars[i];
            }
        }
        char[] chars1 = Arrays.copyOfRange(chars, 1, chars.length - 1);
        return String.valueOf(chars1);
    }

    private void change(char[] chars, int preCharLocation, int currentCharLocation, char preChar, char currentChar) {
        //判断4种情况
        //L....R
        if (preChar=='L'&&currentChar=='R')
        {
            return;
        }
        //L.....L
        if (preChar=='L'&&currentChar=='L')
        {
            for (int i = preCharLocation; i <=currentCharLocation; i++) {
                chars[i]='L';
            }
            return;
        }
        //R.....R
        if (preChar=='R'&&currentChar=='R')
        {
            for (int i = preCharLocation; i <=currentCharLocation; i++) {
                chars[i]='R';
            }
            return;
        }
        //R....L
        if (preChar=='R'&&currentChar=='L')
        {
            int left=preCharLocation;
            int right=currentCharLocation;
            while (left<right)
            {
                chars[left]='R';
                chars[right]='L';
                left++;
                right--;
            }
            return;
        }
    }
}
