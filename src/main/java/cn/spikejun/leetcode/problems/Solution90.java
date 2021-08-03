package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {

    @Test
    public void test()
    {
        int[]nums=new int[]{0};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println("!!!!");
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>answ=new ArrayList<>();
        //先加一个空集
        answ.add(new ArrayList<>());
        Arrays.sort(nums);
        int beginIndex=0;
        List<Integer>route=new ArrayList<>();
        boolean[]visited=new boolean[nums.length];
        dfs(beginIndex,visited,nums,route,answ);
        return answ;
    }

    private void dfs(int beginIndex, boolean[] visited, int[] nums, List<Integer> route, List<List<Integer>> answ) {
        if (beginIndex==nums.length)
        {
            return;
        }
        for (int i = beginIndex; i < nums.length; i++) {
            if (i!=0&&nums[i]==nums[i-1]&&visited[i-1]==false)
            {
                continue;
            }
            route.add(nums[i]);
            answ.add(new ArrayList(route));
            visited[i]=true;
            dfs(i+1,visited,nums,route,answ);
            route.remove(route.size()-1);
            visited[i]=false;
        }
    }
}
