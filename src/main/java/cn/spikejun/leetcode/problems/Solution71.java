package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution71 {

    @Test
    public void test()
    {
        String s="/a//b////c/d//././/..";
        String s1 = simplifyPath(s);
        System.out.println(s1);
    }


    public String simplifyPath(String path) {
        path=path+"/";
        char[] chars = path.toCharArray();
        Deque<String>deque=new ArrayDeque<>();
        deque.addLast("/");
        StringBuffer currentStr=new StringBuffer();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]!='/')
            {
                currentStr=currentStr.append(chars[i]);
            }
            else
            {
                //如果是连续的/就直接continue
                if (currentStr.toString().equals(""))
                {
                    currentStr=new StringBuffer();
                    continue;
                }
                //如果是./的话那就直接continue
                else if (currentStr.toString().equals("."))
                {
                    currentStr=new StringBuffer();
                    continue;
                }
                //如果是两个点的话那就要将栈顶元素pop掉
                else if (currentStr.toString().equals(".."))
                {
                    if (deque.size()==1)
                    {
                        currentStr=new StringBuffer();
                        continue;
                    }
                    else {
                        String pollLast = deque.pollLast();
                        currentStr=new StringBuffer();
                    }
                }
                //不是特殊的字符
                else
                {
                    currentStr.append("/");
                    deque.addLast(currentStr.toString());
                    currentStr=new StringBuffer();
                }
            }
        }
        StringBuffer buffer=new StringBuffer();
        while (!deque.isEmpty())
        {
            buffer.append(deque.pollFirst());
        }
        if (buffer.charAt(buffer.length()-1)=='/'&&buffer.length()>1)
        {
            buffer.deleteCharAt(buffer.length()-1);
        }
        return buffer.toString();
    }
}
