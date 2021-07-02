package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution149 {

    @Test
    public void test()
    {
//        int a=-4;
//        int b=-6;
//        System.out.println(gcd(a,b));
        int[][]points=new int[][]{{1,1},{3,2}, {5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int maxPoints=1;
        int size=points.length;
        for (int i = 0; i < size; i++) {
            Map<String,Integer>countK=new HashMap<>();
            int currentMax=1;
            for (int j = i+1; j < size; j++) {
                int differenceX=points[i][0]-points[j][0];
                int differenceY=points[i][1]-points[j][1];
                int gcd;
                String k;
                if (differenceX!=0&&differenceY!=0)
                {
                    gcd = gcd(differenceX, differenceY);
                    k=differenceY/gcd+"-"+differenceX/gcd;
                }
                else if (differenceX==0)
                {
                    k="#";
                }
                else
                {
                    k="0";
                }
                countK.put(k,countK.getOrDefault(k,1)+1);
                currentMax=Math.max(currentMax,countK.get(k));
            }
            maxPoints=Math.max(maxPoints,currentMax);
        }
        return maxPoints;
    }
    public int gcd(int a,int b)
    {
        if (a%b==0)
        {
            return b;
        }
        int temp=a%b;
        return gcd(b,temp);
    }



}
