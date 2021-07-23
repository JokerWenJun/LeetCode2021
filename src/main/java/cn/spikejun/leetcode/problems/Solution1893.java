package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution1893 {

    @Test
    public void test()
    {
        int[][]ranges=new int[][]{
                {1,1},
                {3,3},
        };
        System.out.println(isCovered(ranges,3,3));
    }


    public boolean isCovered(int[][] ranges, int left, int right) {
        //先将range进行升序
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Deque<int[]> stack=new ArrayDeque<>();
        for (int i = 0; i < ranges.length; i++) {
            if (stack.isEmpty())
            {
                stack.addLast(ranges[i]);
            }
            else
            {
                int[] breforeRange = stack.peekLast();
                int[] currentRange=ranges[i];
                if (currentRange[0]<=breforeRange[1]||currentRange[0]==breforeRange[1]+1)
                {
                    int[] pop = stack.pollLast();
                    currentRange[0]=Math.min(currentRange[0],breforeRange[0]);
                    currentRange[1]=Math.max(breforeRange[1],currentRange[1]);
                }
                stack.addLast(currentRange);
            }
        }
        int[][]changeArray=new int[stack.size()+1][2];
        int[][]originalArray=new int[stack.size()][2];
        int originalSize=stack.size();
        for (int i = 0; i < originalSize; i++) {
            int[] ints = stack.peekFirst();
            changeArray[i]=ints.clone();
            originalArray[i]=ints.clone();
            stack.pollFirst();
        }
        int []newRnage=new int[]{left,right};
        changeArray[changeArray.length-1]=newRnage;
        ranges=changeArray;
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        stack=new ArrayDeque<>();
        for (int i = 0; i < ranges.length; i++) {
            if (stack.isEmpty())
            {
                stack.addLast(ranges[i]);
            }
            else
            {
                int[] breforeRange = stack.peekLast();
                int[] currentRange=ranges[i];
                if (currentRange[0]<=breforeRange[1])
                {
                    int[] pop = stack.pollLast();
                    currentRange[0]=Math.min(currentRange[0],breforeRange[0]);
                    currentRange[1]=Math.max(breforeRange[1],currentRange[1]);
                }
                stack.addLast(currentRange);
            }
        }
        int changeSize = stack.size();
        int [][]newArr=new int[changeSize][2];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i]=stack.pollFirst();
        }
        if (changeSize!=originalSize)
        {
            return false;
        }
        for (int i = 0; i < newArr.length; i++) {
            if (!Arrays.equals(newArr[i],originalArray[i]))
            {
                return false;
            }
        }
        return true;
    }
}
