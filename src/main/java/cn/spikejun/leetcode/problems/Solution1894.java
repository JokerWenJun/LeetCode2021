package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1894 {

    @Test
    public void test()
    {
        int[]arr=new int[]{5,1,5};
        int i = chalkReplacer(arr, 22);
        System.out.println(Integer.MAX_VALUE);
    }

    public int chalkReplacer(int[] chalk, int k) {
        int answIndex=-1;
        //first step we need to calculate the total sum of the chalk
        long totalSum=0;
        for (int i : chalk) {
            totalSum+=i;
        }
        //and then we use totalSum to mod k
        long leftCount = k%totalSum;
        //finally, we should traverse the array and minus each element,we find the first element which is less than the current element

        //so let's begin
        for (int i = 0; i < chalk.length; i++) {
            if (leftCount<chalk[i])
            {
                answIndex=i;
                break;
            }
            else
            {
                leftCount-=chalk[i];
            }
        }
        return answIndex;
    }
}
