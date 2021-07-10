package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution8 {



    @Test
    public void test()
    {
        int i = myAtoi("9223372036854775808");
        System.out.println(i);
    }
    public int maxValue = Integer.MAX_VALUE;
    public int minValue = Integer.MIN_VALUE;
    public int myAtoi(String s) {

        //去除空隔
        s = s.trim();
        long answ=0l;
        //正负
        int flag=1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i==0)
            {
                if (chars[i]!='-'&&chars[i]!='+'&&!(chars[i]>='0'&&chars[i]<='9'))
                {
                    return 0;
                }
                else
                {
                    if(chars[i]=='-')
                    {
                        flag=-1;
                    }
                    else if(chars[i]=='+')
                    {
                        flag=1;
                    }
                    //为数字
                    else
                    {
                        answ=answ*10+chars[i]-'0';
                    }
                }
            }
            else
            {
                if (chars[i]>='0'&&chars[i]<='9')
                {
                    answ=answ*10+chars[i]-'0';
                    //这里就应该判断的
                    if (!judge(answ,flag))
                    {
                        if (flag==1)
                        {
                            return maxValue;
                        }
                        else
                        {
                            return minValue;
                        }
                    }
                }
                else
                {
                    break;
                }
            }
        }
        return (int) (flag*answ);
    }

    boolean judge(long answ,int flag)
    {
        if (flag==1)
        {
            if (answ>maxValue)
            {
                return false;
            }
            return true;
        }
        else
        {
            if (answ-maxValue>+1)
            {
                return false;
            }
            return true;
        }
    }

}
