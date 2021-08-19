package cn.spikejun.leetcode.problems;

public class Solution551 {

    public boolean checkRecord(String s) {
        int Lcount=0;
        int Acount=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='P')
            {
                Lcount=0;
                continue;
            }
            if (chars[i]=='A')
            {
                Lcount=0;
                Acount++;
                if (Acount>=2)
                {
                    return false;
                }
            }
           if (chars[i]=='L')
           {
               Lcount++;
               if (Lcount>=3)
               {
                   return false;
               }
           }
        }
        return true;
    }

}
