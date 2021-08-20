package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {

    @Test
    public void test()
    {
        String s="25525511135";
        List<String> list = restoreIpAddresses(s);
        System.out.println(list.toString());
    }



    public List<String> restoreIpAddresses(String s) {
        List<String>list=new ArrayList<>();
        if (s.length()<4)
        {
            return list;
        }
        char[] chars = s.toCharArray();
        StringBuffer buffer=new StringBuffer();
        String[]strings=new String[4];
        dfs(chars,strings,list,0,0,s);
        return list;
    }

    private void dfs(char[] chars, String[] strings, List<String> list, int beginIndex, int index,String originalStr) {
        if (index==3)
        {
            if (beginIndex<chars.length)
            {
                if (whetherTheStrIsLegal(originalStr.substring(beginIndex,chars.length)))
                {
                    strings[3]=originalStr.substring(beginIndex,chars.length);
                    list.add(strings[0]+"."+strings[1]+"."+strings[2]+"."+strings[3]);
                }
            }
            return;
        }
        for (int i = beginIndex; i < chars.length; i++) {
            String substring = originalStr.substring(beginIndex, i + 1);
            if (whetherTheStrIsLegal(substring))
            {
                strings[index]=substring;
                dfs(chars,strings,list,i+1,index+1,originalStr);
            }
        }
    }

    private boolean whetherTheStrIsLegal(String s)
    {
        if (s.charAt(0)=='0'&&s.length()>1)
        {
            return false;
        }
        if (s.length()>4)
        {
            return false;
        }
        Integer integer = Integer.valueOf(s);
        if (integer>=0&&integer<=255)
        {
            return true;
        }
        return false;
    }


}
