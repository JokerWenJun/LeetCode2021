package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution218 {

    @Test
    public void test()
    {
        int[][]buildings=new int[][]{{0,2,3},{2,5,3}};
        List<List<Integer>> skyline = getSkyline(buildings);
        System.out.println("!!!!");
    }


    public List<List<Integer>> getSkyline(int[][] buildings) {

        int buildingLength = buildings.length;
        //储存每个点
        List<Integer>point=new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            //加入每个建筑的边缘点
            point.add(buildings[i][0]);
            point.add(buildings[i][1]);
        }
        //排序
        Collections.sort(point);
        //创建优先队列->0:建筑的右边点 1:建筑的高度
        PriorityQueue<int[]>queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        List<List<Integer>>answ=new ArrayList<>();
        //建筑循环的下标
        int index=0;
        //循环point
        for (int i = 0; i < point.size(); i++) {
            while (index<buildingLength&&buildings[index][0]<=point.get(i))
            {
                queue.add(new int[]{buildings[index][1],buildings[index][2]});
                index++;
            }
            while (!queue.isEmpty()&&point.get(i)>=queue.peek()[0])
            {
                queue.poll();
            }
            int height=0;
            if (!queue.isEmpty())
            {
                height=queue.peek()[1];
            }
            //判断该点是否与之前是否相同
            if (answ.size()==0||answ.get(answ.size()-1).get(1)!=height)
            {
                List<Integer>list=new ArrayList<>();
                list.add(point.get(i));
                list.add(height);
                answ.add(list);
            }
        }
        return answ;
    }


}
