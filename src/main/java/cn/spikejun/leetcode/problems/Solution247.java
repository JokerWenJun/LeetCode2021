package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution247 {

    @Test
    public void test()
    {
        List<String> strobogrammatic = findStrobogrammatic(2);
        System.out.println("!!");
    }

    public List<String> findStrobogrammatic(int n) {
        char[]chars=new char[]{'0','1','6','8','9'};
        char[]route=new char[n];
        List<String>answ=new ArrayList<>();
        dfs(chars,route,answ,n,0);
        return answ;
    }

    private void dfs(char[] chars, char[] route, List<String> answ, int n,int beginIndex) {
        //判断边界
        if (n%2==0)
        {
            if (beginIndex==n/2)
            {
                String s = String.valueOf(route);
                answ.add(s);
                return;
            }
        }
        else
        {
            if (beginIndex==n/2+1)
            {
                String s = String.valueOf(route);
                answ.add(s);
                return;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (beginIndex==0&&i==0&&n!=1)
            {
                continue;
            }
            if (n%2!=0&&beginIndex==n/2&&(chars[i]=='6'||chars[i]=='9'))
            {
                continue;
            }
            route[beginIndex]=chars[i];
            if (!(n%2!=0&&beginIndex==n/2))
            {
                if (chars[i]!='6'&&chars[i]!='9')
                {
                    route[n-1-beginIndex]=chars[i];
                }
                if (chars[i]=='6')
                {
                    route[n-1-beginIndex]='9';
                }
                if (chars[i]=='9')
                {
                    route[n-1-beginIndex]='6';
                }
            }
            //进行dfs
            dfs(chars,route,answ,n,beginIndex+1);
        }
    }
}
