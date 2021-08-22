package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution443 {

    @Test
    public void test()
    {
        char[]arr=new char[]{'a','b','c'};
        int compress = compress(arr);
        System.out.println(compress);
    }


    public int compress(char[] chars) {
        if (chars.length==1)
        {
            return 1;
        }
        int count=1;
        char preChar=chars[0];
        int beginIndex=1;
        int writeIndex=0;
        while (beginIndex<chars.length)
        {
            if (chars[beginIndex]!=preChar)
            {
                chars[writeIndex]=preChar;
                writeIndex++;
                //calculte the count
                if(count>1)
                {
                    String str=String.valueOf(count);
                    char[] charArray = str.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        chars[writeIndex]=charArray[i];
                        writeIndex++;
                    }
                }
                preChar=chars[beginIndex];
                count=1;
            }
            else {
                count++;
            }
            beginIndex++;
        }
        //deal the last index of array
        chars[writeIndex]=preChar;
        writeIndex++;
        if(count>1)
        {
            String str=String.valueOf(count);
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                chars[writeIndex]=charArray[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
