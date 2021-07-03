package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution524 {

    @Test
    public void test()
    {
//        String s1="abc";
//        String s2="abe";
//        int i = s1.compareTo(s2);
//        System.out.println(i);

        String s="aaa";
        String[]dict=new String[]{"abe","abc"};
        List<String>dic=new ArrayList<>();
        dic.add("aaa");
        dic.add("aa");
        dic.add("a");
//        dic.add("monkey");
//        dic.add("plea");
        String longestWord = findLongestWord(s, dic);
        System.out.println(longestWord);
    }

    public String findLongestWord(String s, List<String> dictionary) {
        char[] originalArray = s.toCharArray();
        int maxCount=0;
        int maxPosition=-1;
        String maxStr="";
        for (int i = 0; i < dictionary.size(); i++) {
            String currentNewString=dictionary.get(i);
            char[] newCharArray = currentNewString.toCharArray();
            int newArrayArrow=0;
            int originalArrayArrow=0;
            boolean flag=true;
            while (newArrayArrow<newCharArray.length)
            {
                if (originalArrayArrow>originalArray.length-1)
                {
                    flag=false;
                    break;
                }
                if (newCharArray[newArrayArrow]!=originalArray[originalArrayArrow])
                {
                    originalArrayArrow++;
                }
                else
                {
                    newArrayArrow++;
                    originalArrayArrow++;
                }
            }
            //该字符串可以转换
            if (flag)
            {
                if (currentNewString.length()>maxCount)
                {
                    maxCount=currentNewString.length();
                    maxPosition=i;
                }
                if (currentNewString.length()==maxCount)
                {
                    if (currentNewString.compareTo(dictionary.get(maxPosition))<0)
                    {
                        maxPosition=i;
                    }
                }
            }
        }
        if (maxPosition==-1)
        {
            return "";
        }
        return dictionary.get(maxPosition);
    }
}
