package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution1220 {

    @Test
    public void test()
    {
        int i = countVowelPermutation(144);
        System.out.println(i);
    }

    public int countVowelPermutation(int n) {
        int mod= (int) (Math.pow(10,9)+7);
        int count=0;
        long aNumber=1;
        long eNumber=1;
        long iNumber=1;
        long oNumber=1;
        long uNumber=1;
        for (int i = 2; i <= n; i++) {
            long newANumber=0;
            long newENumber=0;
            long newINumber=0;
            long newONumber=0;
            long newUNumber=0;
            newANumber=(eNumber%mod+iNumber%mod+uNumber%mod);
            newENumber=(aNumber%mod+iNumber%mod);
            newINumber=(eNumber%mod+oNumber%mod);
            newONumber=(iNumber%mod);
            newUNumber=(iNumber%mod+oNumber%mod);
            aNumber=newANumber%mod;
            eNumber=newENumber%mod;
            iNumber=newINumber%mod;
            oNumber=newONumber%mod;
            uNumber=newUNumber%mod;
        }
        long answ=aNumber%mod+eNumber%mod+iNumber%mod+oNumber%mod+uNumber%mod;
        return (int) (answ%mod);
    }


}
