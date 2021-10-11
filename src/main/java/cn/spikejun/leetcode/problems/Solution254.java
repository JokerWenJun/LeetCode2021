package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Solution254 {

    List<List<Integer>>answ=new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        if (n<2)
        {
            return answ;
        }
        List<List<Integer>> dfs = dfs(2, n);
        return dfs;
    }

    private List<List<Integer>> dfs(int start, int n) {

        List<List<Integer>>current=new ArrayList<>();
        for (int i = start; i*i<=n; i++) {
            if (n%i==0)
            {
                List<Integer>currentRow=new ArrayList<>();
                currentRow.add(i);
                currentRow.add(n/i);
                current.add(currentRow);
                List<List<Integer>> dfs = dfs(i, n / i);
                for (List<Integer> df : dfs) {
                    List<Integer>newList=new ArrayList<>(df);
                    newList.add(i);
                    current.add(newList);
                }
            }
        }
        return current;
    }
}
