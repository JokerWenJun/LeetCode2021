package cn.spikejun.leetcode.problems;

public class Solution348 {

    class TicTacToe {


        private int[]rows;
        private int[]columns;
        int leftDiagonal=0;
        int rightDiagonal=0;
        int target;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            rows=new int[n];
            columns=new int[n];
            target=n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            /**
             * 玩家1移动为 +1
             * 玩家2移动为 -1
             */
            if (player==1)
            {
                rows[row]++;
                if (rows[row]==target)
                {
                    return 1;
                }
                columns[col]++;
                if (columns[col]==target)
                {
                    return 1;
                }
                //判断对角线
                if (row==col)
                {
                    leftDiagonal++;
                    if (leftDiagonal==target)
                    {
                        return 1;
                    }
                }
                if (row+col==target-1)
                {
                    rightDiagonal++;
                    if (rightDiagonal==target)
                    {
                        return 1;
                    }
                }
            }
            else if (player==2)
            {
                rows[row]--;
                if (rows[row]==-target)
                {
                    return 2;
                }
                columns[col]--;
                if (columns[col]==-target)
                {
                    return 2;
                }
                //判断对角线
                if (row==col)
                {
                    leftDiagonal--;
                    if (leftDiagonal==-target)
                    {
                        return 2;
                    }
                }
                if (row+col==target-1)
                {
                    rightDiagonal--;
                    if (rightDiagonal==-target)
                    {
                        return 2;
                    }
                }
            }
            return 0;
        }
    }
}
