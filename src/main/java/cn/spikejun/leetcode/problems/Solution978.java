package cn.spikejun.leetcode.problems;

public class Solution978 {


    public int maxTurbulenceSize(int[] arr) {
      int[]up=new int[arr.length];
      int[]down=new int[arr.length];
      up[0]=1;
      down[0]=1;
      int answ=1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>arr[i-1])
            {
                up[i]=1+down[i-1];
                down[i]=1;
            }
            else if (arr[i]<arr[i-1])
            {
                down[i]=up[i-1]+1;
                up[i]=1;
            }
            else
            {
                up[i]=1;
                down[i]=1;
            }
            answ=Math.max(answ,Math.max(up[i],down[i]));
        }
        return answ;
    }

}
