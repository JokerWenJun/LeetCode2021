package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution273 {

    @Test
    public void test()
    {
//        StringBuffer stringBuffer=new StringBuffer("000");
//        String s = changeThreeDigitsToString(stringBuffer);
//        System.out.println(s);
        String s1 = numberToWords(1000000);
        System.out.println(s1);
    }
    public String numberToWords(int num) {
       if (num==0)
       {
           return "Zero";
       }
        String s = String.valueOf(num);
        //在前面补0
        if (s.length()%3!=0)
        {
            if (3-s.length()%3==1)
            {
                s="0"+s;
            }
            if (3-s.length()%3==2)
            {
                s="00"+s;
            }
        }
        //补完0后从后往前每三位开始转化为英文
        String[]digitsName=new String[]{"Thousand","Million","Billion"};
        String answ="";
        char[] chars = s.toCharArray();
        int begin=0;
        for (int i = chars.length-1; i>=0; i-=3,begin++) {
            StringBuffer stringBuffer=new StringBuffer();
            stringBuffer.append(chars[i]);
            stringBuffer.append(chars[i-1]);
            stringBuffer.append(chars[i-2]);
            stringBuffer = stringBuffer.reverse();
            //将三位数字转为为英文
            String str=changeThreeDigitsToString(stringBuffer);
            //代表不是000
            if (!str.equals(""))
            {
                if (begin==0)
                {
                    answ=str;
                }
                else
                {
                    str=str+" "+digitsName[begin-1];
                    answ=str+" "+answ;
                }
            }
        }
        return answ.trim();
    }

    private String changeThreeDigitsToString(StringBuffer stringBuffer) {
        String[]digitOne=new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[]digitTwo=new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};
        String[]digitTwoOfTwo=new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String s = stringBuffer.toString();
        char[] chars = s.toCharArray();
        StringBuffer answ=new StringBuffer();
        if (chars[0]!='0')
        {
            answ.append(digitOne[(chars[0]-'0')]);
            answ.append(" ");
            answ.append("Hundred");
        }
        //判断char[0]和char【1】组成的数数字
        Integer number=(chars[1]-'0')*10+(chars[2]-'0');
        //根据numhber判断
        if (number!=0)
        {
            answ.append(" ");
            if (number>=1&&number<=9)
            {
                answ.append(digitOne[number]);
            }
            else if (number>=10&&number<=20)
            {
                answ.append(digitTwo[number-10]);
            }
            else if (number>20)
            {
                String twoDigits="";
                int firstDigit=number/10;
                int secondDigit=number-firstDigit*10;
                twoDigits=twoDigits+digitTwoOfTwo[firstDigit-2];
                if (secondDigit!=0)
                {
                    twoDigits+=" ";
                    twoDigits=twoDigits+digitOne[secondDigit];
                }
                answ.append(twoDigits);
            }
        }
        return answ.toString().trim();
    }


}
