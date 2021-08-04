package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution79 {

    @Test
    public void test()
    {
        char[][]board=new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        boolean abcced = exist(board, "BFCE");
        System.out.println(abcced);
    }


    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j]==chars[0]&&searchWord(i,j,chars,board))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(int beginRow, int beginColumn, char[] chars, char[][] board) {
        //记录
        boolean[][]visited=new boolean[board.length][board[0].length];
        return  dfsSearch(beginRow,beginColumn,chars,board,visited,0);
    }

    private boolean dfsSearch(int currentRow, int currentColumn, char[] chars, char[][]board, boolean[][] visited, int currentIndex) {
        //判断边界
        if (currentIndex==chars.length)
        {
            return true;
        }
        int rows=board.length;
        int columns=board[0].length;
        if (currentRow<0||currentColumn<0||currentRow>=rows||currentColumn>=columns||visited[currentRow][currentColumn]==true||chars[currentIndex]!=board[currentRow][currentColumn])
        {
            return false;
        }
        visited[currentRow][currentColumn]=true;
        //上下左右四个方面进行dfs
        if (dfsSearch(currentRow-1,currentColumn,chars,board,visited,currentIndex+1)||dfsSearch(currentRow+1,currentColumn,chars,board,visited,currentIndex+1)||dfsSearch(currentRow,currentColumn-1,chars,board,visited,currentIndex+1)||dfsSearch(currentRow,currentColumn+1,chars,board,visited,currentIndex+1))
        {
            //回复状态
            visited[currentRow][currentColumn]=false;
            return true;
        }
        //回复状态
        visited[currentRow][currentColumn]=false;
        return false;
    }
}
