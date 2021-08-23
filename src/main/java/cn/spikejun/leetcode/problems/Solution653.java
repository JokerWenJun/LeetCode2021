package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer>arr=new ArrayList<>();
        midOrder(root,arr);
        int left=0;
        int right=arr.size()-1;
        while (left<right)
        {
            int sum=arr.get(left)+arr.get(right);
            if (sum==k)
            {
                return true;
            }
            if (sum<k)
            {
                left++;
            }
            if (sum>k)
            {
                right--;
            }
        }
        return false;
    }

    private void midOrder(TreeNode root, List<Integer> arr) {
        if (root==null)
        {
            return;
        }
        midOrder(root.left,arr);
        arr.add(root.val);
        midOrder(root.right,arr);
    }
}
