package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Condition;

public class Solution782 {


    public int movesToChessboard(int[][] board) {
        int N = board.length;
        //first we need to calculate the number one count of each rows;
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num=0;
            for (int j = 0; j < board[i].length; j++) {
                num=num*2+board[i][j];
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //then we need to calculate the map is valid
        int rowsHandleNum=analyseMapIsVaild(map,N);
        if (rowsHandleNum==-1)
        {
            return -1;
        }
        map=new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num=0;
            for (int j = 0; j < N; j++) {
                num=num*2+board[j][i];
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int colHandleNum=analyseMapIsVaild(map,N);
        if (colHandleNum==-1)
        {
            return -1;
        }
        return rowsHandleNum+colHandleNum;
    }

    private int analyseMapIsVaild(Map<Integer, Integer> map, int N) {
        //if the board do not have two different rows, the question don't have answer.
        if (map.size()!=2)
        {
            return -1;
        }
        //we need to verify two different rows number
        Set<Integer> keys = map.keySet();
        ArrayList<Integer> integers = new ArrayList<>(keys);
        int key1=integers.get(0);
        int key2=integers.get(1);
        if (!(map.get(key1)==N/2&&map.get(key2)==(N+1)/2)&&!(map.get(key1)==(N+1)/2&&map.get(key2)==N/2))
        {
            return -1;
        }
        //we also need to verify the number1 count of different condition rows
        if ((key1^key2)!=(1<<N)-1)
        {
            return -1;
        }
        int satisfiedRow=(1<<N)-1;
        int answ=Integer.MAX_VALUE;
        //last we need to compare two different change condition the first is number one at first position the second is nunber zero at the first position
        int ones=Integer.bitCount(key1&satisfiedRow);
        if (N%2==0||ones*2<N)
        {
            answ=Math.min(answ,Integer.bitCount(key1^0xAAAAAAAA&satisfiedRow)/2);
        }
        if (N%2==0||ones*2>N)
        {
            answ=Math.min(answ,Integer.bitCount(key1^0x55555555&satisfiedRow)/2);
        }
        return answ;
    }

}
