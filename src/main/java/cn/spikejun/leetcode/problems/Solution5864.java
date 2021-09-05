package cn.spikejun.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Solution5864 {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                {
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        });
        int count=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < properties.length; i++) {
            int[] property = properties[i];
            int attack=property[0];
            int denfend=property[1];
            if (denfend<max)
            {
                count++;
            }
            if (denfend>max)
            {
                max=denfend;
            }
        }
        return count;
    }
}
