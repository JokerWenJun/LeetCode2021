package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        //先找到层数
        int floors=1;
        while (label>=Math.pow(2,floors-1)){
            floors++;
        }
        //此时floor为层数
        floors=floors-1;
        List<Integer>list=new ArrayList<>();
        backTrackOfLabel(label,floors,list);
        List<Integer>answ=new ArrayList<>();
        for (int i = list.size()-1,j=0; i>=0; i--,j++) {
            answ.add(list.get(i));
        }
        return answ;
    }

    private void backTrackOfLabel(int label, int floors, List<Integer> list) {
        while (floors>=1)
        {

            //判断当前层为奇数还是偶数
            //偶数
            if (floors%2==0)
            {
                list.add(label);
                //把lable换成奇数行的下标
                int total= (int) (Math.pow(2,floors-1)+Math.pow(2,floors)-1);
                label=total-label;
                label=label/2;
                floors--;
            }
            else
            {
                list.add(label);
                label=label/2;
                floors--;
                int total= (int) (Math.pow(2,floors-1)+Math.pow(2,floors)-1);
                label=total-label;
            }
        }
    }
}
