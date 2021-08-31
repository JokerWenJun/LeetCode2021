package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution678 {

    @Test
    public void test()
    {
        String s="(*******************************************((";
        boolean b = checkValidString1(s);
        int left=0;
        int right=0;
        int count=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(')
            {
                left++;
            }
            if (chars[i]==')')
            {
                right++;
            }
            if (chars[i]=='*')
            {
                count++;
            }
        }
        System.out.println(b);
    }

    public boolean checkValidString(String s) {
        int low=0;
        int hight=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!='(')
            {
                low--;
            }
            else
            {
                low++;
            }
            if (chars[i]!=')')
            {
                hight++;
            }
            else
            {
                hight--;
            }
            if (hight<0)
            {
                return false;
            }
            low=Math.max(0,low);
        }
        if (low==0)
        {
            return true;
        }
        return false;
    }
    public boolean checkValidString1(String s) {
        char[] chars = s.toCharArray();
        int[]countArr=new int[chars.length];
        int leftBrackets=0;
        int rightBracket=0;
        int leftBracketsBegin=-1;
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='*')
            {
                count++;
                countArr[i]=count;
            }
            if (chars[i]=='(')
            {
                countArr[i]=count;
                if (leftBrackets==0)
                {
                    leftBracketsBegin=i;
                }
                leftBrackets++;
            }
            if (chars[i]==')')
            {
                countArr[i]=count;
                if (leftBrackets>0)
                {
                    leftBrackets--;
                }
                else
                {
                    rightBracket++;
                    if (rightBracket>count)
                    {
                        return false;
                    }
                }
            }
        }
        if (leftBrackets>0)
        {
            int intervalCount=countArr[countArr.length-1]-countArr[leftBracketsBegin];
            if (leftBrackets>intervalCount)
            {
                return false;
            }
        }
        return true;
    }
}
