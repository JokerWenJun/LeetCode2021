package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution5824 {

    @Test
    public void test()
    {
        String num="132";
        int[]change=new int[]{9,8,5,0,3,6,4,2,6,8};
        String s = maximumNumber(num, change);
        System.out.println(s);
    }



    public String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        //开始判断第一个大于原本的数字的位置
        int beginPosition=-1;
        for (int i = 0; i < chars.length; i++) {
            int originalNum=chars[i]-'0';
            int changeNum=change[originalNum];
            if (changeNum>originalNum)
            {
                beginPosition=i;
                break;
            }
        }
        if (beginPosition==-1)
        {
            return num;
        }
        int endPosition=beginPosition;
        for (int i = beginPosition; i < chars.length; i++) {
            int originalNum=chars[i]-'0';
            int changeNum=change[originalNum];
            if (changeNum<originalNum)
            {
               break;
            }
            else {
                endPosition++;
            }
        }
        if (beginPosition==endPosition)
        {
            int originalNum=chars[beginPosition]-'0';
            int changeNum=change[originalNum];
            chars[beginPosition]= (char) (changeNum+'0');
        }
        else {
            for (int i = beginPosition; i < endPosition; i++) {
                int originalNum=chars[i]-'0';
                int changeNum=change[originalNum];
                chars[i]= (char) (changeNum+'0');
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append(chars[i]);
        }
        return stringBuffer.toString();
    }
}
