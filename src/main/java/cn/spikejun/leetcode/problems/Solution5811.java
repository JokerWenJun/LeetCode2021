package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution5811 {

    @Test
    public void test()
    {
//        System.out.println(2%2);
        int i = colorTheGrid(2, 37);
        System.out.println(i);

    }



    //下列方法已经超时。。。。。。
    long answ=0;
    int mod= (int) (Math.pow(10,9)+7);
    public int colorTheGrid(int m, int n) {
        int [][]arr=new int[m][n];
        //白色为0，红色为1,绿色2,蓝色3
        //初始化
        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i],0);
        }
        int begin=0;
        //开始dfs
        dfs(arr,begin,m,n);
        return (int) answ;
    }

    private void dfs(int[][] arr, int begin, int m, int n) {
        if (begin==m*n)
        {
            answ=answ+1;
            answ%=mod;
            return;
        }
        for (int i = 1; i <=3; i++) {
            //转化当前的坐标
            //横坐标
            int x=begin/n;
            //纵坐标
            int y=begin%n;
            //判断当前涂这种颜色
            if (isCanPrint(arr,x,y,i))
            {
                arr[x][y]=i;
                dfs(arr,begin+1,m,n);
                //状态回溯
                arr[x][y]=0;
            }
            else
            {
                continue;
            }
        }
    }

    private boolean isCanPrint(int[][] arr, int x, int y, int currentColor) {
        //判断左上两个个方向是否符合
        //左
        if (y!=0)
        {
            int leftColor=arr[x][y-1];
            if (leftColor==currentColor)
            {
                return  false;
            }
        }
        //上
        if (x!=0)
        {
            int upColor=arr[x-1][y];
            if (upColor==currentColor)
            {
                return false;
            }
        }
        return true;
    }
}
