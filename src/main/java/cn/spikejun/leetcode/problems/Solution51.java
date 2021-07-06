package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {


    @Test
    public void test()
    {
        List<List<String>> lists = solveNQueens(1);

    }

    private List<List<int[]>>map=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<int[]>queensPositon=new ArrayList<>();
        int currentRow=0;
        dfs(queensPositon,currentRow,n);
        List<List<String>>answ=new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            List<int[]> eachMap = map.get(i);
            List<String>eachRow=new ArrayList<>();
            for (int j = 0; j < eachMap.size(); j++) {
                int[] queenPosition = eachMap.get(j);
                String eachRowStr="";
                for (int k = 0; k < n; k++) {
                    if (k==queenPosition[1])
                    {
                        eachRowStr+="Q";
                    }
                    else
                    {
                        eachRowStr+=".";
                    }
                }
                eachRow.add(eachRowStr);
            }
            answ.add(eachRow);
        }
        return answ;
    }

    private void dfs(List<int[]> queensPositon, int currentRow, int n) {
        //终止条件
        if (currentRow==n)
        {
            map.add(new ArrayList<>(queensPositon));
            return;
        }
        for (int i = 0; i < n; i++) {
            int[]nextPosition=new int[]{currentRow,i};
            //判断当前的皇后是否符合条件
            if (!isVaildQueenPosition(nextPosition,queensPositon))
            {
                continue;
            }
            //代表放置皇后成功
            queensPositon.add(nextPosition);
            //进行DFS
            dfs(queensPositon,currentRow+1,n);
            //撤销放置的皇后
            queensPositon.remove(queensPositon.size()-1);
        }
    }


    //判断当前的皇后是否符合规格
    private boolean isVaildQueenPosition(int[] nextPosition, List<int[]> queensPositon) {
        for (int i = 0; i < queensPositon.size(); i++) {
            int[] queenPosition = queensPositon.get(i);
            //判断是否在下方
            if (queenPosition[1]==nextPosition[1])
            {
                return false;
            }
            //判断是否在在斜对角
            if (Math.abs(nextPosition[0]-queenPosition[0])==Math.abs(nextPosition[1]-queenPosition[1]))
            {
                return false;
            }
        }
        return true;
    }

}
