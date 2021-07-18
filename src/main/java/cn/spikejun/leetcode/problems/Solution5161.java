package cn.spikejun.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution5161 {


    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        char[] chars = brokenLetters.toCharArray();
        boolean[]isWrong=new boolean[26];
        Arrays.fill(isWrong,true);
        for (char aChar : chars) {
            isWrong[aChar-'a']=false;
        }
        int count=0;
        for (String word : words) {
            char[] eachWord = word.toCharArray();
            boolean okWord=true;
            for (char c : eachWord) {
                if (isWrong[c-'a']==false)
                {
                    okWord=false;
                    break;
                }
            }
            if (okWord)
            {
                count++;
            }
        }
        return count;
    }
}
