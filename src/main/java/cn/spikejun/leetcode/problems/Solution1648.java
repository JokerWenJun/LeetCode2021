package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1648 {

    @Test
    public void test()
    {
        int[]arr=new int[]{2,5};

        int i = maxProfit(arr,4);
        System.out.println(i);
    }


    private int MOD= (int) (Math.pow(10,9)+7);

    public int maxProfit(int[] inventory, int orders) {
        long profit=0;
        int j=0;
        Integer[] num = Arrays.stream(inventory).boxed().toArray(Integer[]::new);
        Arrays.sort(num,Collections.reverseOrder());
        while (orders>0)
        {
            while (j<num.length&&num[j]>=num[0])
            {
                j++;
            }
            int next=0;
            if (j<num.length)
            {
                next=num[j];
            }
            long eachNumDifferent=num[0]-next;
            long eachAmount=eachNumDifferent*j;
            if (eachAmount>orders)
            {
                long a = orders / j;
                long b = orders % j;
                if (a!=0)
                {
                    long first=num[0];
                    long last=num[0]-a+1;
                    long each=((first+last)*(first-last+1))/2;
                    profit+=each*j;
                }
                profit+=b*(num[0]-a);
            }else
            {
                long first=num[0];
                long last=next+1;
                long each=((first+last)*(first-last+1))/2;
                profit+=each*j;
            }
            num[0]=next;
            orders-=eachAmount;
            profit%=MOD;
        }
        return (int)profit;
    }
}
