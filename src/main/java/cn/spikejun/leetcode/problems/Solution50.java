package cn.spikejun.leetcode.problems;

public class Solution50 {


    public double myPow(double x, int n) {
        if (n>=0)
        {
            double answ=myCircular(x,n);
            return answ;
        }
        if (n<0)
        {
            double negativeAnsw=myCircular(x,-n);
            return 1.0/negativeAnsw;
        }
        return 0;
    }

    private double myCircular(double x, int N) {
        if (N==0)
        {
            return 1.00;
        }
        double y=myCircular(x,N/2);
        return N%2==0?y*y:y*y*x;
    }
}
