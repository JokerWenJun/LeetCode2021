package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution781 {

    @Test
    public void test()
    {
        int[]arr=new int[]{10,10,10};
        int i = numRabbits(arr);
        System.out.println(i);
    }


    public int numRabbits(int[] answers) {
        //answ-count record the cout of  same answ
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        int answ=0;
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            int num=integer+1;
            Integer count = map.get(integer);
            int i = (count / num) * num;
            if (count-i>0)
            {
                i+=num;
            }
            answ+=i;
        }
        return answ;
    }
}
