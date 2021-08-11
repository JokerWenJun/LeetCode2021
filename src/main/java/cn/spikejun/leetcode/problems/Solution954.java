package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution954 {

    @Test
    public void test()
    {
        int[]arr=new int[]{-6,-3};
        canReorderDoubled(arr);

    }


    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer>map=new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        //此时map中的key进行了排序了
        Set<Integer> set = map.keySet();
        //判断0
        if (map.containsKey(0))
        {
            if (map.get(0)%2!=0)
            {
                return false;
            }
        }
        for (Integer eachKey : set) {
            if (map.get(eachKey)==0)
            {
                continue;
            }
            int nextNum=eachKey>0?eachKey*2:eachKey/2;

            if (eachKey<0&&eachKey%2!=0||map.get(eachKey)>map.getOrDefault(nextNum,0))
            {
                return false;
            }
            map.put(nextNum,map.get(nextNum)-map.get(eachKey));
        }
        return true;
    }
}
