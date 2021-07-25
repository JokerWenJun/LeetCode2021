package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution1743 {

    @Test
    public void test()
    {
        int[][] adjacentPairs=new int[][]{
                {4,-2},
                {1,4},
                {-3,1}
        };
        int[] ints = restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(ints));
    }


    public int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs.length==1)
        {
            return adjacentPairs[0];
        }
        Map<Integer, List<Integer>>map=new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int[] currentArray = adjacentPairs[i];
            int num1=currentArray[0];
            int num2 = currentArray[1];
            List<Integer> num1List = map.getOrDefault(num1, new LinkedList<>());
            num1List.add(num2);
            map.put(num1,num1List);
            List<Integer> num2List = map.getOrDefault(num2, new LinkedList<>());
            num2List.add(num1);
            map.put(num2,num2List);
        }
        //判断两个端点
        List<Integer>edgePoints=new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            if (map.get(integer).size()==1)
            {
                edgePoints.add(integer);
            }
        }
        int leftPoint=edgePoints.get(0);
        int rightPoint=edgePoints.get(1);
        //创建原数组
        int[]nums=new int[adjacentPairs.length+1];
        int left=0;
        int right=nums.length-1;
        int preLeftPoint=0;
        int preRightPoint=0;
        int currentLeftPoint=leftPoint;
        int currentRighPoint=rightPoint;
        while (left<=right)
        {
            nums[left]=currentLeftPoint;
            nums[right]=currentRighPoint;
            if (left==0&&right==nums.length-1)
            {
                preLeftPoint=currentLeftPoint;
                preRightPoint=currentRighPoint;
                List<Integer> leftList = map.get(currentLeftPoint);
                List<Integer> rightList = map.get(currentRighPoint);
                currentLeftPoint=leftList.get(0);
                currentRighPoint=rightList.get(0);
            }
            else
            {
                List<Integer> leftList = map.get(currentLeftPoint);
                List<Integer> rightList = map.get(currentRighPoint);
                int nextLeftPoint =leftList.get(1-leftList.indexOf(preLeftPoint));
                int nextRightPoint =rightList.get(1-rightList.indexOf(preRightPoint));
                preLeftPoint=currentLeftPoint;
                preRightPoint=currentRighPoint;
                currentLeftPoint=nextLeftPoint;
                currentRighPoint=nextRightPoint;
            }
            left++;
            right--;
        }
        return nums;
    }

}
