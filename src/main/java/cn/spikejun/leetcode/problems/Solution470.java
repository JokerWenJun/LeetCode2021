package cn.spikejun.leetcode.problems;

import java.util.Random;

public class Solution470 {

    private int rand7()
    {
        Random random=new Random();
        return random.nextInt(7);
    }

    public int rand10() {
        while (true)
        {
            //get the number from 1 to 49
            int i = (rand7() - 1) * 7 + rand7();
            if (i<=40)
            {
                return i%10+1;
            }
            //41-49
            i=(i-40-1)*7+rand7();
            //get the number from 1-63
            if (i<=60)
            {
                return i%10+1;
            }
            //61-63
            i=(i-60-1)*7+rand7();
            //get the number from 1-21;
            if (i<=20)
            {
                return i%10+1;
            }
        }
    }
}
