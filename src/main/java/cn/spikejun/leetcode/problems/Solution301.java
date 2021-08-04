package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution301 {

    private Set<String>set=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        //先测出当前应该删除多少左括号，多少右括号
        char[] chars = s.toCharArray();
        int leftMove=0;
        int rightMove=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(')
            {
                leftMove++;
            }
            else if (chars[i]==')')
            {
                if (leftMove==0)
                {
                    rightMove++;
                }
                else
                {
                    leftMove--;
                }
            }
        }
        StringBuffer path=new StringBuffer();
        int index=0;
        //当前左括号数量
        int leftCount=0;
        //当前右括号数量
        int rightCount=0;
        //开始进行dfs遍历
        dfs(chars,index,leftCount,rightCount,leftMove,rightMove,path);
        List<String>answ=new ArrayList<>();
        for (String s1 : set) {
            answ.add(s1);
        }
        return answ;
    }

    private void dfs(char[] chars, int index, int leftCount, int rightCount, int leftMove, int rightMove, StringBuffer path) {
        //判断递归结束的条件
        if (index==chars.length)
        {
            //判断是否该删除的左括号和右括号是否完全删除干净
            if (leftMove==0&&rightMove==0)
            {
                set.add(new String(path.toString()));
            }
            return;
        }
        //碰到下一个字符其实就两种选择，一种是留下一种是不留下，首先判断是否可以不留下
        //如果不留下
        char currentChar = chars[index];
        if (currentChar=='('&&leftMove>0)
        {
            dfs(chars,index+1,leftCount,rightCount,leftMove-1,rightMove,path);
        }
        if (currentChar==')'&&rightMove>0)
        {
            dfs(chars,index+1,leftCount,rightCount,leftMove,rightMove-1,path);
        }
        //如果留下
        path.append(currentChar);
        //如果不是括号,直接跳过
        if (currentChar!='('&&currentChar!=')')
        {
            dfs(chars,index+1,leftCount,rightCount,leftMove,rightMove,path);
        }
        if (currentChar=='(')
        {
            dfs(chars,index+1,leftCount+1,rightCount,leftMove,rightMove,path);
        }
        else if (leftCount>rightCount)
        {
            dfs(chars,index+1,leftCount,rightCount+1,leftMove,rightMove,path);
        }
        path.deleteCharAt(path.length()-1);
    }
}
