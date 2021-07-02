package cn.spikejun.leetcode.problems;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

public class Solution421 {

    class TreeNode
    {
        TreeNode left;
        TreeNode right;
    }
    private TreeNode root=new TreeNode();
    private int maxBit=30;
    public int findMaximumXOR(int[] nums) {
        int answ=0;
        buildTree(nums);
        for (int i = 0; i < nums.length; i++) {
            int temp = check(nums[i]);
            answ=Math.max(answ,temp);
        }
        return answ;
    }
    private int check(int num)
    {
        TreeNode cur=root;
        int sum=0;
        for (int i = maxBit; i >= 0; i--) {
            int bit=(num>>i)&1;
            if (bit==0)
            {
                if (cur.right!=null)
                {
                    sum=sum*2+1;
                    cur=cur.right;
                }
                else
                {
                    sum=sum*2;
                    cur=cur.left;
                }
            }
            //当bit为1的时候
            else
            {
                if (cur.left!=null)
                {
                    sum=sum*2+1;
                    cur=cur.left;
                }
                else
                {
                    sum=sum*2;
                    cur=cur.right;
                }
            }

        }
        return sum;
    }
    private void buildTree(int[]nums)
    {
        TreeNode cur=root;
        int length=nums.length;
        for (int i = 0; i < length; i++) {
            cur=root;
            for (int j = maxBit; j >=0; j--) {
                int bit=(nums[i]>>j)&1;
                //bit只可能为1/0
                //1为右边/0为左边
                if (bit==1)
                {
                    if (cur.right==null)
                    {
                        cur.right=new TreeNode();
                        cur=cur.right;
                    }
                    else
                    {
                        cur=cur.right;
                    }
                }
                else
                {
                    if (cur.left==null)
                    {
                        cur.left=new TreeNode();
                        cur=cur.left;
                    }
                    else
                    {
                        cur=cur.left;
                    }
                }
            }
        }
    }

    @Test
    public void test()
    {
//        int answ=0;
        int []nums=new int[]{14,70,53,83,49,91,36,80,92,51,66,70};
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                int temp=nums[i]^nums[j];
//                System.out.println(temp);
//                answ=Math.max(answ,temp);
//            }
//        }
//        System.out.println(answ);
        int maximumXOR = findMaximumXOR(nums);
        System.out.println(maximumXOR);
        System.out.println("pause");
    }

}
