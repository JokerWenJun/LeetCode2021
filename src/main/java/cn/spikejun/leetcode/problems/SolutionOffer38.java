package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOffer38 {

    @Test
    public void test()
    {
//        StringBuffer stringBuffer=new StringBuffer("123");
//        stringBuffer.deleteCharAt(stringBuffer.length()-1);
//        System.out.println(stringBuffer.toString());
//        String s=new String("dkjphedy");
//        String[] permutation = permutation(s);
//        System.out.println(Arrays.toString(permutation));
        System.out.println("00000000000000000000000010000000".length());
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[]vist=new boolean[chars.length];
        StringBuffer prefix=new StringBuffer("");
        List<String>stringList=new ArrayList<>();
        dfsMethod(chars,prefix,stringList,vist);
        String[]strs=new String[stringList.size()];
        for (int i = 0; i < strs.length; i++) {
            strs[i]=stringList.get(i);
        }
        return strs;
    }

    private void dfsMethod(char[] chars, StringBuffer prefix, List<String> stringList, boolean[] vist) {
        if (prefix.length()==chars.length)
        {
            stringList.add(prefix.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (vist[i]||i>0&&!vist[i-1]&&chars[i]==chars[i-1])
            {
                continue;
            }
            prefix.append(chars[i]);
            vist[i]=true;
            dfsMethod(chars,prefix,stringList,vist);
            prefix.deleteCharAt(prefix.length()-1);
            vist[i]=false;
        }
    }
    private List<String>answ;
    public String[] permutation1(String s) {
        answ=new ArrayList<>();
        char[] chars = s.toCharArray();
        List<Integer>route=new ArrayList<>();
        StringBuffer prefix=new StringBuffer("");
        int target=chars.length;
        dfs(chars,route,prefix,target);
        String[]strs=new String[answ.size()];
        for (int i = 0; i < strs.length; i++) {
            strs[i]=answ.get(i);
        }
        return strs;
    }

    private void dfs(char[] chars, List<Integer> route, StringBuffer prefix,int target) {
        if (prefix.length()==target)
        {
            if (answ.contains(prefix.toString()))
            {
                return;
            }
            answ.add(prefix.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (route.contains(i))
            {
                continue;
            }
            prefix.append(chars[i]);
            route.add(i);
            dfs(chars,route,prefix,target);
            prefix.deleteCharAt(prefix.length()-1);
            route.remove(route.size()-1);
        }
    }


}
