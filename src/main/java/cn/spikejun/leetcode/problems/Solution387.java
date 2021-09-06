package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution387 {


    @Test
    public void test()
    {
        String s="loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    public int firstUniqChar(String s) {
        List<Character> list=new ArrayList<>();
        char[]chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<chars.length;i++)
        {
            if(map.containsKey(chars[i]))
            {
                Character c=chars[i];
                boolean remove = list.remove(c);
            }
            else{
                map.put(chars[i],i);
                list.add(chars[i]);
            }
        }
        if(list.size()==0)
        {
            return -1;
        }
        return map.get(list.get(0));
    }

}
