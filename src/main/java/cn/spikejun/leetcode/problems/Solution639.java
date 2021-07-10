package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution639 {

    @Test
    public void test()
    {
        int i = numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*");
        System.out.println(i);
    }



    public int numDecodings(String s) {
        int mod= (int) (Math.pow(10,9)+7);
        char[] charArray = s.toCharArray();
        //创建动态数组
        long []dp=new long[charArray.length+1];
        dp[0]=1;
        //判断dp[1]也就是s的第一个字符
        if (charArray[0]=='0')
        {
            return 0;
        }
        else if (charArray[0]=='*')
        {
            dp[1]=9;
        }
        //第一个字符是1-9
        else
        {
            dp[1]=1;
        }
        //开始遍历字符串每个字符
        for (int i = 1; i < charArray.length; i++) {
            //先判断是不是*
            if (charArray[i]=='*')
            {
                //先是不和前面一个字符组合
                dp[i+1]=(dp[i+1]+9*dp[i])%mod;
                //再判断与前面一个字符组合的结果其中与之有效的只有当前面一个字符为1,2,*的时候
                if (charArray[i-1]=='1')
                {
                    dp[i+1]=(dp[i+1]+9*dp[i-1])%mod;
                }
                else if (charArray[i-1]=='2')
                {
                    dp[i+1]=(dp[i+1]+6*dp[i-1])%mod;
                }
                else if (charArray[i-1]=='*')
                {
                    dp[i+1]=(dp[i+1]+15*dp[i-1])%mod;
                }
            }
            //是数字
            else
            {
                //判断当前的数字是不是0，如果是0则无法与前面的元素进行组合
                //如果不是0的话等于前面的排列
                if (charArray[i]!='0')
                {
                    dp[i+1]=(dp[i+1]+dp[i])%mod;
                }
                //判断能否与前面的字符进行组合
                if (charArray[i-1]=='*')
                {
                    if (charArray[i]<='6')
                    {
                        dp[i+1]=(dp[i+1]+dp[i-1]*2)%mod;
                    }
                    else {
                        dp[i+1]=(dp[i+1]+dp[i-1])%mod;
                    }
                }
                else if (charArray[i-1]=='1')
                {
                    dp[i+1]=(dp[i+1]+dp[i-1])%mod;
                }
                else if (charArray[i-1]=='2')
                {
                    if (charArray[i]<='6')
                    {
                        dp[i+1]=(dp[i+1]+dp[i-1])%mod;
                    }
                }
            }
        }
        return (int) dp[dp.length-1];
    }
}
