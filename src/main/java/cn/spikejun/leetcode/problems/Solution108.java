package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

public class Solution108 {

    @Test
    public void test()
    {
        int[]nums=new int[]{-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=new TreeNode();
        int begin=0;
        int end=nums.length-1;
        createTree(begin,end,nums,root);
        return root;
    }

    private void createTree(int begin, int end, int[] nums, TreeNode root) {
        if (begin==end)
        {
            root.val=nums[begin];
        }
        else {
            //首先判断长度是奇数还是偶数
            int length=end-begin+1;
            //代表是奇数
            if (length%2!=0)
            {
                int mid=(end-begin)/2+begin;
                root.val=nums[mid];
                if (begin<=mid-1)
                {
                    root.left=new TreeNode();
                    createTree(begin,mid-1,nums,root.left);
                }
                if (mid+1<=end)
                {
                    root.right=new TreeNode();
                    createTree(mid+1,end,nums,root.right);
                }
            }
            //是偶数
            else{
                int mid=(end-begin+1)/2+begin-1;
                root.val=nums[mid];
                if (begin<=mid-1)
                {
                    root.left=new TreeNode();
                    createTree(begin,mid-1,nums,root.left);
                }
                if (mid+1<=end)
                {
                    root.right=new TreeNode();
                    createTree(mid+1,end,nums,root.right);
                }
            }
        }
    }
}
