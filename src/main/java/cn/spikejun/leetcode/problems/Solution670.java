package cn.spikejun.leetcode.problems;

import java.util.Arrays;

public class Solution670 {



    public int maximumSwap(int num) {
        String str=String.valueOf(num);
        char[] chars = str.toCharArray();
        int[]lastIndex=new int[9];
        Arrays.fill(lastIndex,-1);
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i]-'0']=i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j >chars[i]-'0'; j--) {
                //要判断当前的比他大的数字是前面还是后面，也必须是后面
                if (lastIndex[j]>i)
                {
                    //开始进行交换
                    char temp=chars[i];
                    chars[i]=(char) (j+'0');
                    chars[lastIndex[j]]=temp;
                    return Integer.valueOf(String.valueOf(chars));
                }
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }
}
