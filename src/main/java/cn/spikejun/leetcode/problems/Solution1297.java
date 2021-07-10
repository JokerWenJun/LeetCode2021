package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1297 {

    @Test
    public void test()
    {
        String s="eddcdfcfbbbdedbcddebbfbbdddacfecddacabdbddabfffdecebcabfbdeadecffbcdccecdebbaaaeebefbabeaefbebecdfcd";
        int i = maxFreq(s, 1, 5 , 24);
        System.out.println(i);
    }



    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int answ=0;
//        if (maxLetters>minSize)
//        {
//            return 0;
//        }
        Map<String,Integer>existString=new HashMap<>();
        Map<Character,Integer> existChar=new HashMap<>();
        int i=0;
        while (i<minSize)
        {
            existChar.put(s.charAt(i),existChar.getOrDefault(s.charAt(i),0)+1);
            i++;
        }
        if (existChar.size()<=maxLetters)
        {
            existString.put(s.substring(0,minSize),1);
            answ=1;
        }
        int length = s.length();
        for (i = minSize; i < length; i++) {
            Integer count = existChar.get(s.charAt(i - minSize));
            count--;
            if (count<=0)
            {
                existChar.remove(s.charAt(i-minSize));
            }
            else {
                existChar.put(s.charAt(i-minSize),count);
            }
            existChar.put(s.charAt(i),existChar.getOrDefault(s.charAt(i),0)+1);
            if (existChar.size()>maxLetters)
            {
                continue;
            }
            //表示合格了
            int begin=i-minSize+1;
            String substr=s.substring(begin,i+1);
            Integer integer = existString.get(substr);
            if (integer==null)
            {
                existString.put(substr,1);
                answ=Math.max(answ,1);
            }
            else
            {
                existString.put(substr,integer+1);
                answ=Math.max(answ,existString.get(substr));
            }
        }
        return answ;
    }


}
