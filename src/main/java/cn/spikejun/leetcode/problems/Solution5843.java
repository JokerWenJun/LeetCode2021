package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5843 {
//["nmksysm","gwjt","vjwxinx","wj","yspxxcv","tpeud","sv","sztjxnrb","smsv","vj","pj","tsmsvj","e","svj","w","vj","awofrm","rshgiiyi","v"]
//        "ygwjtsmsvj"
    @Test
    public void test() {
//        String a = "abd";
//        String b = "abc";
//        boolean subStr = isSubStr(a, b);
//        System.out.println(subStr);
        String[] pattern = new String[]{"nmksysm","gwjt","vjwxinx","wj","yspxxcv","tpeud","sv","sztjxnrb","smsv","vj","pj","tsmsvj","e","svj","w","vj","awofrm","rshgiiyi","v"};
        String word = "ygwjtsmsvj";
        int i = numOfStrings(pattern, word);
    }


    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for (int i = 0; i < patterns.length; i++) {
            if (isSubStr(patterns[i],word))
            {
                count++;
            }
        }
        return count;
    }

    //a是否是b字串
    private boolean isSubStr(String a,String b)
    {
        if (a.length()>b.length())
        {
            return false;
        }
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        for (int i = 0; i < charsB.length; i++) {
            if (charsB[i]==charsA[0])
            {
                boolean flag=true;
                for (int j = 0; j < charsA.length; j++) {
                    if (j+i>charsB.length-1)
                    {
                        flag=false;
                        break;
                    }
                    if (charsA[j]!=charsB[j+i])
                    {
                        flag=false;
                        break;
                    }
                }
                if (flag)
                {
                    return true;
                }
            }
        }
        return false;
    }

}
