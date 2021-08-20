package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution6 {

    @Test
    public void test()
    {
        String s="123456";
        String convert = convert(s, 2);
        System.out.println(convert);

    }


    public String convert(String s, int numRows) {
       if (numRows==1)
       {
           return s;
       }
        //单次循环2n-2
        int circularCount=2*numRows-2;
        //计算出s的长度
        int length = s.length();
        //判断出有多少次循环
        int count=length/circularCount;
        //判断余数多少
        int remainNumber=length%circularCount;
        //判断长度
        int arrLength=count*(numRows-1);
        if (remainNumber<=numRows)
        {
            arrLength+=1;
        }
        else
        {
            arrLength=arrLength+1+(remainNumber-numRows);
        }
        //创建字符数组来存储z型
        char[][]chars=new char[numRows][arrLength];
        //将数组中的每一个空位填充
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(chars[i],'#');
        }
        //将s转换为|/
        char[] charArray = s.toCharArray();
        int begin=0;
        int row=0;
        int column=0;
        while (begin<charArray.length)
        {
            chars[row][column]=charArray[begin];
            row++;
            begin++;
            //代表走到最底下
            if (row==chars.length)
            {
                row=chars.length-2;
                column++;
               while (begin<charArray.length)
               {
                   if (row==0)
                   {
                       break;
                   }
                   chars[row][column]=charArray[begin];
                   row--;
                   column++;
                   begin++;
               }
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j]=='#')
                {
                    continue;
                }
                else
                {
                    stringBuffer.append(chars[i][j]);
                }
            }
        }
        return stringBuffer.toString();
    }
}

