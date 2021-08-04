package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.Relation;
import org.junit.Test;

public class Solution277 implements Relation {
    
    @Test
    public void test()
    {
        int celebrity = findCelebrity(3);
        System.out.println(celebrity);
    }
    
    
    public int findCelebrity(int n) {
        int currentRow=0;
        int currentColumn=0;
        while (currentRow<n&&currentColumn<n)
        {
            if (currentColumn==currentRow)
            {
                currentColumn++;
                continue;
            }
            else
            {
                //如果不认识
                if (!knows(currentRow,currentColumn))
                {
                    //往右移动
                    currentColumn++;
                }
                //认识
                else {
                    //往下移动到当前列的行
                    currentRow=currentColumn;
                }
            }
        }
        //判断此时当前行
        for (int i = 0; i < currentRow; i++) {
            if (knows(currentRow,i))
            {
                return -1;
            }
        }
        //判断当前列
        for (int i = 0; i <n ; i++) {
            if (!knows(i,currentRow))
            {
                return -1;
            }
        }
        return currentRow;
    }
    @Override
    public boolean knows(int a, int b) {
        int[][]arr=new int[][]{
                {1,1,0},
                {0,1,0},
                {1,1,1}
        };
        if (arr[a][b]==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
