package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution791 {


    @Test
    public void test()
    {
        String order="kqep";
        String str="pekeq";
        String s = customSortString(order, str);
        System.out.println(s);
    }


    public String customSortString(String order, String str) {

        //创建新的字符表
        Map<Character,Integer>newAlphabet=new HashMap<>();
        //创建存在过新字母表的set
        Set<Character>existChar=new HashSet<>();
        char[] orderArray = order.toCharArray();
        char[] strArray = str.toCharArray();
        //初始化新的字母表
        for (int i = 0; i < orderArray.length; i++) {
            existChar.add(orderArray[i]);
            newAlphabet.put(orderArray[i],i+1);
        }
        StringBuffer notOrderString =new StringBuffer();
        StringBuffer orderString=new StringBuffer();
        for (int i = 0; i < strArray.length; i++) {
            if (existChar.contains(strArray[i]))
            {
                notOrderString.append(strArray[i]);
            }
            else
            {
                orderString.append(strArray[i]);
            }
        }
        //notOrder的String需要进行排序
        char[] notOrderStringArray = notOrderString.toString().toCharArray();
        quicklySort(notOrderStringArray,0,notOrderStringArray.length-1,newAlphabet);

        StringBuffer stringBuffer=new StringBuffer(new String(notOrderStringArray));
        stringBuffer.append(orderString);
        String answ=stringBuffer.toString();
        return answ;
    }

    /**
     * 根据newAlphabet进行排序
     * @param notOrderStringArray
     * @param left
     * @param right
     * @param newAlphabet
     */
    private void quicklySort(char[] notOrderStringArray, int left, int right, Map<Character, Integer> newAlphabet) {
        if (left>=right)
        {
            return;
        }
        char flag=notOrderStringArray[left];
        int flagValue=newAlphabet.get(notOrderStringArray[left]);
        int currentLeft=left;
        int currentRight=right;
        while (currentLeft<currentRight)
        {
            while (currentLeft<currentRight&&newAlphabet.get(notOrderStringArray[currentRight])>=flagValue)
            {
                currentRight--;
            }
            notOrderStringArray[currentLeft]=notOrderStringArray[currentRight];
            while (currentLeft<currentRight&&newAlphabet.get(notOrderStringArray[currentLeft])<flagValue)
            {
                currentLeft++;
            }
            notOrderStringArray[currentRight]=notOrderStringArray[currentLeft];
        }
        notOrderStringArray[currentLeft]=flag;
        quicklySort(notOrderStringArray,left,currentLeft-1,newAlphabet);
        quicklySort(notOrderStringArray,currentLeft+1,right,newAlphabet);
    }
}
