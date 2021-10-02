package cn.spikejun.leetcode.problems;

public class Solution405 {
    public String toHex1(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int u = num & 15;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }


    public String toHex(int num) {
        if (num==0)
        {
            return "0";
        }
        StringBuffer buffer=new StringBuffer();
        while (num!=0)
        {
            int eachGroup=num&15;
            char u= (char) (eachGroup+'0');
            if (eachGroup>=10)
            {
                u=(char)(eachGroup - 10 + 'a');
            }
            buffer.append(u);
            num=num>>4;
        }
        return buffer.reverse().toString();
    }
}
