package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.BinaryMatrix;

import java.util.List;

public class Solution1428 {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> arrayLengthAndWidth = binaryMatrix.dimensions();
        int rows=arrayLengthAndWidth.get(0);
        int columns=arrayLengthAndWidth.get(1);
        int minIndex=-1;
        for (int i = 0; i < rows; i++) {
            //判断边界
            if (binaryMatrix.get(i,0)==1)
            {
                return 0;
            }
            if (binaryMatrix.get(i,columns-1)==0)
            {
                continue;
            }
            //开始二分查找
            int left=0;
            int right=columns-1;
            while (left<right)
            {
                int mid=left+(right-left)/2;
                if (binaryMatrix.get(i,mid)<=0)
                {
                    left=mid+1;
                }
                else
                {
                    right=mid;
                }
            }
            if (minIndex==-1)
            {
                minIndex=left;
            }
            else {
                minIndex=Math.min(minIndex,left);
            }
        }
        return minIndex;
    }
}
