package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution929 {

    @Test
    public void test()
    {
        String s="111+222";
        String[] split = s.split("\\+");
        System.out.println(Arrays.toString(split));
    }

    public int numUniqueEmails(String[] emails) {
        Map<String, Set<String>>map=new HashMap<>();
        for (int i = 0; i < emails.length; i++) {
            String[] split = emails[i].split("@");
            if (map.containsKey(split[1]))
            {
                String localName = split[0];
                String[] localNameStrs= localName.split("\\+");
                String localNameV1=localNameStrs[0];
                StringBuffer localNameV2=new StringBuffer();
                for (int j = 0; j < localNameV1.length(); j++) {
                    if (localNameV1.charAt(j)!='.')
                    {
                        localNameV2.append(localNameV1.charAt(j));
                    }
                }
                map.get(split[1]).add(localNameV2.toString());
            }
            else
            {
                String localName = split[0];
                String[] localNameStrs= localName.split("\\+");
                String localNameV1=localNameStrs[0];
                StringBuffer localNameV2=new StringBuffer();
                for (int j = 0; j < localNameV1.length(); j++) {
                    if (localNameV1.charAt(j)!='.')
                    {
                        localNameV2.append(localNameV1.charAt(j));
                    }
                }
                Set<String>set=new HashSet<>();
                set.add(localNameV2.toString());
                map.put(split[1],set);
            }
        }
        int answ=0;
        Set<String> set = map.keySet();
        for (String key : set) {
            int size = map.get(key).size();
            answ+=size;
        }
        return answ;
    }
}
