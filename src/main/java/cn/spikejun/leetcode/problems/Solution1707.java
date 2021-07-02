package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Solution1707 {



    @Test
    public void test()
    {
//        double a=Math.pow(10,9);
//        System.out.println(a);
//        String s="111011100110101100101000000000";
//        System.out.println(s.length());
        int [][]queries=new int[][]{{12,4},{8,1},{6,3}};
        int []nums=new int[]{5,2,4,6,6,3};
        int[] ints = maximizeXor(nums, queries);
        System.out.println(Arrays.toString(ints));

    }
    class TreeNode1707
    {
        public TreeNode1707 left;
        public TreeNode1707 right;
    }
    private int maxPositon=30;
    public int[] maximizeXor(int[] nums, int[][] queries) {
       int size=queries.length;
       TreeNode1707 root=new TreeNode1707();
       int []answ=new int[size];
       Arrays.sort(nums);
       int[][]newQueries=new int[queries.length][3];
        for (int i = 0; i < size; i++) {
            newQueries[i][0]=queries[i][0];
            newQueries[i][1]=queries[i][1];
            newQueries[i][2]=i;
        }
        queries=newQueries;

        //将queries数组进行排序，将限制要求从低到高进行排序
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int index=0;
        for (int i = 0; i < size; i++) {
            int limit=queries[i][1];
            while (index<=nums.length-1&&nums[index]<=limit)
            {
                int temp=nums[index];
                TreeNode1707 cur=root;
                for (int j = maxPositon; j >= 0; j--) {
                    int singleBit=temp>>j&1;
                    if (singleBit==0)
                    {
                        if (cur.left==null)
                        {
                            cur.left=new TreeNode1707();
                        }
                        cur=cur.left;
                    }
                    else if (singleBit==1)
                    {
                        if (cur.right==null)
                        {
                            cur.right=new TreeNode1707();
                        }
                        cur=cur.right;
                    }
                }
                index++;
            }
            int val=queries[i][0];
            //将 数字与刚刚组成的字典树进行最大亦或操作
            int singleSum=0;
            TreeNode1707 cur=root;
            if (cur.left==null&&cur.right==null)
            {
                answ[queries[i][2]]=-1;
                continue;
            }
            for (int j=maxPositon;j>=0;j--)
            {
                int singleBit=val>>j&1;
                if (singleBit==0)
                {
                    if (cur.right!=null)
                    {
                        singleSum=singleSum*2+1;
                        cur=cur.right;
                    }
                    else
                    {
                        singleSum=singleSum*2;
                        cur=cur.left;
                    }
                }
                else if (singleBit==1)
                {
                    if (cur.left!=null)
                    {
                        singleSum=singleSum*2+1;
                        cur=cur.left;
                    }
                    else
                    {
                        singleSum=singleSum*2;
                        cur=cur.right;
                    }
                }
            }
            answ[queries[i][2]]=singleSum;
        }
        return answ;
    }


}
