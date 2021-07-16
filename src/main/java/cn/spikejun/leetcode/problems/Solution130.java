package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution130 {

    @Test
    public void test()
    {
        char[][]board=new char[][]{
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
        };
        solve(board);
        System.out.println("!!!");
    }


    public void solve(char[][] board) {
        //从边界出发判断
        int rosw=board.length;
        int columns=board[0].length;
        //从两个边界出发
        for (int i = 0; i < rosw; i++) {
            dfs(i,0,board,rosw,columns);
            dfs(i,columns-1,board,rosw,columns);
        }
        for (int i = 1; i < columns-1; i++) {
            dfs(0,i,board,rosw,columns);
            dfs( rosw-1,i,board,rosw,columns);
        }
        for (int i = 0; i < rosw; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                else if (board[i][j]=='A')
                {
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board,int rows,int columns) {
        if (i<0||j<0||i>rows-1||j>columns-1||board[i][j]!='O')
        {
            return;
        }
        board[i][j]='A';
        dfs(i+1,j,board,rows,columns);
        dfs(i-1,j,board,rows,columns);
        dfs(i,j+1,board,rows,columns);
        dfs(i,j-1,board,rows,columns);
    }
}
