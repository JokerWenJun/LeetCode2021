package cn.spikejun.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Solution36 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Integer>[]rows=new HashMap[9];
        Map<Integer,Integer>[]columns=new HashMap[9];
        Map<Integer,Integer>[]eachMap=new HashMap[9];
        for (int i=0;i<9;i++)
        {
            rows[i]=new HashMap<>();
            columns[i]=new HashMap<>();
            eachMap[i]=new HashMap<>();
        }
        int rowLength = board.length;
        int columnsLength = board[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                if (board[i][j]!='.')
                {
                    int num=board[i][j]-'0';
                    if (rows[i].containsKey(num))
                    {
                        return false;
                    }
                    else {
                        rows[i].put(num,1);
                    }
                    if (columns[j].containsKey(num))
                    {
                        return false;
                    }
                    else {
                        columns[j].put(num,1);
                    }
                    //get the number of the square
                    int boxindex=(i / 3 ) * 3 + j / 3;
                    if (eachMap[boxindex].containsKey(num))
                    {
                        return false;
                    }
                    else
                    {
                        eachMap[boxindex].put(num,1);
                    }
                }
            }
        }
        return true;
    }
}
