package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution975 {

    @Test
    public void test()
    {
        int[]arr=new int[]{2,3,1,1,4};
        int i = oddEvenJumps(arr);
        System.out.println(i);
    }

    public int oddEvenJumps(int[] arr) {
        int length = arr.length;
        int[]oddNext=new int[length];
        int[]evenNext=new int[length];
        int[][]copyArr=new int[length][2];
        //index-value
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i][0]=i;
            copyArr[i][1]=arr[i];
        }
        //先从小到大排序
        Arrays.sort(copyArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1])
                {
                    return o1[0]-o2[0];
                }
                else
                {
                    return o1[1]-o2[1];
                }
            }
        });
        //填充odd数组
        fillTheEachNumberOfNext(oddNext,copyArr);
        //index-value
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i][0]=i;
            copyArr[i][1]=arr[i];
        }
        //先从大到小排序
        Arrays.sort(copyArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1])
                {
                    return o1[0]-o2[0];
                }
                else
                {
                    return o2[1]-o1[1];
                }
            }
        });
        fillTheEachNumberOfNext(evenNext,copyArr);
        boolean[]odds=new boolean[length];
        boolean[]evens=new boolean[length];
        //最后一位无论是奇数还是偶数都可以
        odds[length-1]=true;
        evens[length-1]=true;
        for (int i = length-2; i>=0; i--) {
            if (oddNext[i]!=-1)
            {
                odds[i]=evens[oddNext[i]];
            }
            if (evenNext[i]!=-1)
            {
                evens[i]=odds[evenNext[i]];
            }
        }
        int answ=0;
        for (int i = 0; i < odds.length; i++) {
            if (odds[i])
            {
                answ++;
            }
        }
        return answ;
    }

    private void fillTheEachNumberOfNext(int[] oddNext, int[][] copyArr) {
        //最开始初始化,代表每一个数字后续都没有
        Arrays.fill(oddNext,-1);
        //stack储存的是index
        Stack<Integer>stack=new Stack<>();
        for (int i = 0; i < oddNext.length; i++) {
            while (!stack.isEmpty()&&stack.peek()<copyArr[i][0])
            {
                oddNext[stack.pop()]=copyArr[i][0];
            }
            stack.add(copyArr[i][0]);
        }
    }
}
