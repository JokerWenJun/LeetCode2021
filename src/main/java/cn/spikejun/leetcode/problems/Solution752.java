package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution752 {
    @Test
    public void test()
    {
//        char a='0';
//        char b= (char) (a-1);
//        System.out.println(b);
        String[]deads=new String[]{"8888"};
        int i = openLock(deads, "0009");
        System.out.println(i);
    }


    private Set<String>deadSet=new HashSet<>();
    public int openLock(String[] deadends, String target) {
        for (int i = 0; i < deadends.length; i++) {
            deadSet.add(deadends[i]);
        }
        if (deadSet.contains("0000"))
        {
            return -1;
        }
        if (target.equals("0000"))
        {
            return 0;
        }
        Queue<String>queue=new ArrayDeque<>();
        queue.add("0000");
        Set<String>visitedSet=new HashSet<>();
        int step=0;
        while (!queue.isEmpty())
        {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s=queue.poll();
                for (int j = 0; j < 4; j++) {
                   char[]chars= s.toCharArray();
                   char originalChar=chars[j];
                    for (int k = 0; k < 2; k++) {
                        //往前加
                        if (k==0)
                        {
                            chars[j]= (char) (chars[j]+1);
                            if (chars[j]==':')
                            {
                                chars[j]='0';
                            }
                        }
                        else
                        {
                            chars[j]= (char) (chars[j]-1);
                            if (chars[j]=='/')
                            {
                                chars[j]='9';
                            }
                        }
                        String changeStr=String.valueOf(chars);
                        if (!deadSet.contains(changeStr))
                        {
                            if (!visitedSet.contains(changeStr))
                            {
                                if (changeStr.equals(target))
                                {
                                    return step;
                                }
                                queue.add(changeStr);
                                visitedSet.add(changeStr);
                            }
                        }
                        chars[j]=originalChar;
                    }
                }
            }
        }
        return -1;
    }

}
