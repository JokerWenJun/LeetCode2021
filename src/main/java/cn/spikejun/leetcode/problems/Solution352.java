package cn.spikejun.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Solution352 {

    class SummaryRanges {
        private List<int[]>lists=new ArrayList<>();
        private int[]heads=new int[]{-100,-100};
        private int[]tails=new int[]{100000,100000};
        public SummaryRanges() {
            lists.add(heads);
            lists.add(tails);
        }

        public void addNum(int val) {
            //first we need to binary search
            int size = lists.size();
            int left=0;
            int right=size-1;
            while (left<right)
            {
                int mid=left+(right-left)/2+1;
                if (val>=lists.get(mid)[0])
                {
                    left=mid;
                }
                else
                {
                    right=mid-1;
                }
            }
            int[] firstInterval = lists.get(left);
            int[] secondInterval = lists.get(left + 1);
            if ((val>=firstInterval[0]&&val<=firstInterval[1])||(val>=secondInterval[0]&&val<=secondInterval[1]))
            {

            }else if (val==firstInterval[1]+1&&val==secondInterval[0]-1)
            {
                firstInterval[1]=secondInterval[1];
                lists.remove(secondInterval);
            }else if (val==firstInterval[1]+1&&val!=secondInterval[0]-1)
            {
                firstInterval[1]=firstInterval[1]+1;
            }else if (val!=firstInterval[1]+1&&val==secondInterval[0]-1)
            {
                secondInterval[0]=secondInterval[0]-1;
            }else
            {
                lists.add(left+1,new int[]{val,val});
            }
        }

        public int[][] getIntervals() {
            int size = lists.size();
            int[][]answ=new int[size-2][2];
            for (int i = 1; i < size-1; i++) {
                answ[i-1]=lists.get(i);
            }
            return answ;
        }
    }


}
