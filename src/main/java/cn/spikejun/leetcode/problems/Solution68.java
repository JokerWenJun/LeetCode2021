package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution68 {

    /**
     * ["What","must","be","acknowledgment","shall","be"]
     * 16
     */

    @Test
    public void test()
    {
        String[]words=new String[]{"What","must","be","acknowledgment","shall","be"};

//        int[]arr=new int[]{1,3,5,2,11};
//        Arrays.sort(arr);
//        System.out.println(arr);

//
        List<String> list = fullJustify(words, 16);
        System.out.println("!!!");
    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>answ=new ArrayList<>();
        int left=0;
        int right=0;
        int n=words.length;
        while (true)
        {
            left=right;
            //each row stringbuffer
            StringBuffer eachRowStrBffer=new StringBuffer();
            //each row length
            int currentRowCharSize=0;
            //calculate each row should have the number of words
            while (right<n&&currentRowCharSize+words[right].length()+right-left<=maxWidth)
            {
                currentRowCharSize+=words[right].length();
                right++;
            }
            //whether is the last row

            if (right==n)
            {
                String connect=connectEachWord(words,left,n," ");
                String currentRow=addSpaceIntoEachRowStr(connect,maxWidth);
                answ.add(currentRow);
                break;
            }
            //if is not the last row
            //we think that it will be two condition
            //first is that it is only have one words, then we only need to add maxwidth-current word.length space
            //second is that it is not only word, we will have a calculaion

            //create a variable
            int wordsNum=right-left;

            //condition 1
            if (wordsNum==1)
            {
                String s = addSpaceIntoEachRowStr(words[left], maxWidth);
                answ.add(s);
                continue;
            }
            else //condition 2
            {
                int totalSpaceNum=maxWidth-currentRowCharSize;
                int eachIntervalNum=totalSpaceNum/(wordsNum-1);
                int extraWord=totalSpaceNum%(wordsNum-1);
                eachRowStrBffer.append(words[left]);
                for (int i = left+1; i < right; i++) {
                    //first add common space
                    for (int j = 0; j < eachIntervalNum; j++) {
                        eachRowStrBffer.append(" ");
                    }
                    //for the first extrWord to 1 space
                    if (i<=left+extraWord)
                    {
                        eachRowStrBffer.append(" ");
                    }
                    //finally we add each word
                    eachRowStrBffer.append(words[i]);
                }
                answ.add(eachRowStrBffer.toString());
            }
        }

        return answ;
    }

    private String addSpaceIntoEachRowStr(String connect, int maxWidth) {
        int length = maxWidth - connect.length();
        for (int i=0;i<length;i++)
        {
            connect=connect+" ";
        }
        return connect;
    }

    private String connectEachWord(String[] words, int left, int right, String space) {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(words[left]);
        for (int i = left+1; i < right; i++) {
            stringBuffer.append(space);
            stringBuffer.append(words[i]);
        }
        return stringBuffer.toString();
    }
}
