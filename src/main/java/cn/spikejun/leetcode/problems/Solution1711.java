package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution1711 {

    @Test
    public void test()
    {
        int[]deliciousness=new int[]{1,1,1,3,3,3,7};
        int i = countPairs(deliciousness);
        System.out.println(i);
    }


    public int countPairs(int[] deliciousness) {
        int answ=0;
        int maxValue=Integer.MIN_VALUE;
        int mod= (int) (Math.pow(10,9)+7);
        Map<Integer,Integer>countMap=new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            maxValue=Math.max(maxValue,deliciousness[i]);
            for (int j = 1; j <= maxValue*2; j=j<<1) {
                int target=j-deliciousness[i];
                answ=(answ+countMap.getOrDefault(target,0))%mod;
            }
            countMap.put(deliciousness[i],countMap.getOrDefault(deliciousness[i],0)+1);
        }
        return answ;
    }
}
