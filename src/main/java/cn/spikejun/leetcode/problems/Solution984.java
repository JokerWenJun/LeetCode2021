package cn.spikejun.leetcode.problems;

import org.junit.Test;

public class Solution984 {
    @Test
    public void test()
    {

    }

    public String strWithout3a3b(int a, int b) {
        StringBuffer buffer=new StringBuffer();
        int continuousA=0;
        int continuousB=0;
        while (a!=0||b!=0)
        {
          if (a>b)
          {
              if (continuousA==2)
              {
                  buffer.append('b');
                  continuousB++;
                  continuousA=0;
                  b--;
              }
              else
              {
                  buffer.append('a');
                  continuousA++;
                  continuousB=0;
                  a--;
              }
          }
          else
          {
              if (continuousB==2)
              {
                  buffer.append('a');
                  continuousA++;
                  continuousB=0;
                  a--;
              }
              else
              {
                  buffer.append('b');
                  continuousB++;
                  continuousA=0;
                  b--;
              }
          }
        }
        return buffer.toString();
    }
}
