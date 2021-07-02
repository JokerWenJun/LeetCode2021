package cn.spikejun.leetcode.problems;


import org.junit.Test;

import java.util.*;

public class Solution909 {

    @Test
    public void test() {
        int[][] board = new int[][]{{-1,-1,-1,46,47,-1,-1,-1},{51,-1,-1,63,-1,31,21,-1},{-1,-1,26,-1,-1,38,-1,-1},{-1,-1,11,-1,14,23,56,57},{11,-1,-1,-1,49,36,-1,48},{-1,-1,-1,33,56,-1,57,21},{-1,-1,-1,-1,-1,-1,2,-1},{-1,-1,-1,8,3,-1,6,56}};
//        int[][] board = new int[][]{
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 35, -1, -1, 13, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 15, -1, -1, -1, -1}
//        };
//        int[][]board=new int[][]{
//                {-1,-1},
//                {-1,3}
//        };
        int i = snakesAndLadders(board);
        System.out.println(i);
//        N=5;
//        int[] ints = changePositionToArray(1);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(1/10);

    }


    private int N;

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new ArrayDeque<>();
        int step = 0;
        queue.add(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int end = board.length * board.length;
        this.N = board.length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer peek = queue.poll();
                //判断当前位置上面有没有蛇或者梯子
                //0=纵坐标
                //1=横坐标
                int[] positionArry = changePositionToArray(peek);
                int value = board[positionArry[0]][positionArry[1]];

                //分别进行1~6的步数
                for (int j = 1; j <= 6; j++) {
                    if (peek + j > end) {
                        continue;
                    } else if (peek + j == end) {
                        return step + 1;
                    } else {
                        if (!visited.contains(peek + j)) {
                            int[] nextStep = changePositionToArray(peek + j);
                            int nextValue = board[nextStep[0]][nextStep[1]];
                            if (nextValue != -1) {
                                if (nextValue == end) {
                                    return step + 1;
                                }
                                if (!visited.contains(nextValue)) {
//                                    visited.add(nextValue);
                                    queue.add(nextValue);
                                }
                            } else {
                                queue.add(peek + j);
                            }
                            visited.add(peek + j);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int[] changePositionToArray(Integer peek) {
        int count = 0;
        int current = peek;
        count = current / N;
        int y;
        int x;
        if (count % 2 == 0) {
            if (current % N == 0) {
                x = 0;
                y = N - count;
            } else {
                y = N - count - 1;
                x = peek - (count * N) - 1;
            }
        } else {
            if (current % N == 0) {
                y = N - (count - 1) - 1;
                x = N - 1;
            } else {
                y = N - count - 1;
                x = (count + 1) * N - peek;
            }
        }
        return new int[]{y, x};
    }


}
