package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1338 {

    @Test
    public void test()
    {
        int[]arr=new int[]{1000,1000,3,7};
        int i = minSetSize(arr);
        System.out.println(i);
    }


    public int minSetSize(int[] arr) {
        //现将数组进行排序，将重复的元素并在一起
        Arrays.sort(arr);
        //创建优先队列
        PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int count=1;
        int preNum=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (preNum!=arr[i])
            {
                queue.add(count);
                count=1;
                preNum=arr[i];
            }
            else
            {
                count++;
            }
        }
        //将最后一个元素的数量加入到优先队列里面
        queue.add(count);
        int target=arr.length/2;
        int answ=0;
        while (!queue.isEmpty())
        {
            answ++;
            int eachCount=queue.poll();
            if (target-eachCount<=0)
            {
                return answ;
            }
            else
            {
                target=target-eachCount;
            }
        }
        return answ;
    }
}
