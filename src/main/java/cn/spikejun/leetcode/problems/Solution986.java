package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution986 {


    @Test
    public void test()
    {
//        int[][]first=new int[][]{{0,2},{5,10},{13,23},{24,25}};
//        int[][]second=new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][]first=new int[][]{{1,3},{5,9}};
        int[][]second=new int[][]{};
        int[][] ints = intervalIntersection(first, second);
        System.out.println("!!!!");
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int[][]mergeList=new int[firstList.length+secondList.length][2];
        for (int i = 0; i < firstList.length; i++) {
            mergeList[i]=firstList[i];
        }
        for (int i = 0; i < secondList.length; i++) {
            mergeList[firstList.length+i]=secondList[i];
        }
        Arrays.sort(mergeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]>answ=new ArrayList<>();
        Deque<int[]>deque=new ArrayDeque<>();
        for (int i = 0; i < mergeList.length; i++) {
            if (deque.isEmpty())
            {
                deque.addLast(mergeList[i]);
            }
            else {
                int[] poll = deque.pollLast();
                int[] currentArray = mergeList[i];
                if (poll[1]<currentArray[0])
                {
                    deque.addLast(currentArray);
                }
                else
                {
                    int[]newArr=new int[2];
                    newArr[0]=currentArray[0];
                    if (currentArray[1]>poll[1])
                    {
                        newArr[1]=poll[1];
                    }
                    else
                    {
                        newArr[1]=currentArray[1];
                    }
                    answ.add(newArr);
                    int[]arr=new int[2];
                    arr[0]=Math.min(poll[0],currentArray[0]);
                    arr[1]=Math.max(poll[1],currentArray[1]);
                    deque.addLast(arr);
                }
            }
        }
        int[][]ar=new int[answ.size()][2];
        for (int i = 0; i < answ.size(); i++) {
            ar[i]=answ.get(i);
        }
        return ar;
    }
}
