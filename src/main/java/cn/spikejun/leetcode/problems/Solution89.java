package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {

    @Test
    public void test()
    {
        List<Integer> integers = grayCode(2);
        System.out.println(integers.toString());
    }


    public List<Integer> grayCode(int n) {
        List<Integer>answ=new ArrayList<>();
        if (n==0)
        {
            return answ;
        }
        answ.add(0);
        answ.add(1);
        for (int i = 2; i <=n; i++) {
            for (int j = answ.size()-1; j >= 0; j--) {
                int current= (int) (answ.get(j)+Math.pow(2,i-1));
                answ.add(current);
            }
        }
        return answ;
    }



}
