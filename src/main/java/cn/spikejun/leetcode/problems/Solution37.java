package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution37 {


    @Test
    public void test()
    {
        System.out.println("9".compareTo("91n "));
    }


    private boolean[][]row=new boolean[9][9];
    private boolean[][]col=new boolean[9][9];
    private boolean[][][]blocks=new boolean[3][3][9];
    private List<int[]>emptyBlock=new ArrayList<>();
    private boolean flag=false;
    public void solveSudoku(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j]!='.')
                {
                    int num=board[i][j]-'0'-1;
                    row[i][num]=true;
                    col[j][num]=true;
                    blocks[i/3][j/3][num]=true;
                }
                else
                {
                    emptyBlock.add(new int[]{i,j});
                }
            }
        }
        dfs(board,0);

    }

    private void dfs(char[][] board, int index) {
        if (index==emptyBlock.size())
        {
            flag=true;
            return;
        }
        int[] currentBlock = emptyBlock.get(index);
        int currentRow = currentBlock[0];
        int currentColumn = currentBlock[1];
        //current block can fill 1 to 9
        for (int i=1;i<=9&&!flag;i++)
        {
            if (!row[currentRow][i-1]&&!col[currentColumn][i-1]&&!blocks[currentRow/3][currentColumn/3][i-1])
            {
                board[currentRow][currentColumn]= (char) (i+'0');
                row[currentRow][i-1]=col[currentColumn][i-1]=blocks[currentRow/3][currentColumn/3][i-1]=true;
                dfs(board,index+1);
                row[currentRow][i-1]=col[currentColumn][i-1]=blocks[currentRow/3][currentColumn/3][i-1]=false;
            }
        }
    }
}
