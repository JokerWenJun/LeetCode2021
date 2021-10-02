package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution600 {

    @Test
    public void test()
    {
        int integers = findIntegers(5);
        System.out.println(integers);
    }


    public int findIntegers(int n) {
        //first we need to create a template which means that we need to create a two-dimensional array
        //such likes num[x,y], x means that current number length and y means that current number of highest bit
        //and we know that the requirement of n less than the ten to the ninth power
        //so the max of x is 32 and y is 2
        int[][]template=new int[32][2];

        //when the max length the array is one, we know that whether the max bit is one or zero, the arr value is 1
        template[1][0]=1;
        template[1][1]=1;

        for (int i = 2; i < 32; i++) {
            template[i][0]=template[i-1][0]+template[i-1][1];
            template[i][1]=template[i-1][0];
        }

        int answ=0;
        int pre=0;

        //we need to change n to binary expression
        List<Integer>binaryExpression=new ArrayList<>();
        int current=n;
        while (current!=0)
        {
            binaryExpression.add(current&1);
            current=current>>1;
        }
        for (int i = binaryExpression.size()-1; i>=0; i--) {
            Integer currentBit = binaryExpression.get(i);
            for (int j = 0; j < currentBit; j++) {
                answ+=template[i+1][j];
            }
            if (currentBit==1&&pre==1)
            {
                break;
            }
            pre=currentBit;
            if (i==0)
            {
                answ++;
            }
        }
        return answ;
    }
}
