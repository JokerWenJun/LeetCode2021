package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution522 {

    @Test
    public void test()
    {
        String[]strs=new String[]{"aba","cdc","eae"};
        int luSlength = findLUSlength(strs);
        System.out.println(luSlength);
    }


     public boolean judge(String a,String b)
     {
         int j=0;
         for (int i = 0; i < b.length(); i++) {
            if (a.charAt(j)==b.charAt(i))
            {
                j++;
            }
            if (j==a.length())
            {
                return false;
            }
         }
         if (j==a.length())
         {
             return false;
         }
         return true;
     }


    public int findLUSlength(String[] strs) {
        int max=-1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag=true;
            for (int j = 0; j < strs.length; j++) {
                if (i==j)
                {
                    continue;
                }
                if (!judge(strs[i],strs[j]))
                {
                    flag=false;
                    break;
                }
            }
            if (flag)
            {
                max=Math.max(max,strs[i].length());
            }
        }
        return max;
    }
}
