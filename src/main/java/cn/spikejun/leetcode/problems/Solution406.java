package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution406 {

    @Test
    public void test()
    {
//        LinkedList<Integer>linkedList=new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(1);
//        linkedList.add(1);
//        linkedList.add(1,2);
//        int[][]people=new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
//        int[][] ints = reconstructQueue(people);

        int a=2^5^1^6;
        System.out.println(a);

    }
    public int[][] reconstructQueue(int[][] people) {
        int size=people.length;
        /**
         * 二维数组排序:
         * 其中o1[],o2[]代表二维数组上下两个一维数组
         * 当o1[0]==o2[0]表示当竖向第一列相同的时候应该按照第二列进行升序排列
         * 当o1[0]!=o2[0]表时当竖向第一列不相同的时候应该按照第一列进行降序排列
         */
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                {
                    return o1[1]-o2[1];
                }
                else
                {
                    return o2[0]-o1[0];
                }
            }
        });
        LinkedList<int[]>sortList=new LinkedList<>();
        for (int i = 0; i < size; i++) {
            int count=people[i][1];
            if (count>=sortList.size())
            {
                sortList.add(people[i]);
            }
            else {
                sortList.add(count,people[i]);
            }
        }
        int [][]answ=new int[size][2];
        for (int i = 0; i < size; i++) {
            answ[i]=sortList.get(i);
        }
        return answ;
    }
}
