package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>list=getTheRoot(1,n);
        return list;
    }

    private List<TreeNode> getTheRoot(int left, int right) {
        List<TreeNode>currentList=new ArrayList<>();
        if (left>right)
        {
            currentList.add(null);
            return currentList;
        }
        for (int i = left; i <=right; i++) {
            List<TreeNode> leftList = getTheRoot(left, i - 1);
            List<TreeNode> rightList = getTheRoot(i + 1, right);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode currentRoot=new TreeNode(i);
                    currentRoot.left=leftList.get(j);
                    currentRoot.right=rightList.get(k);
                    currentList.add(currentRoot);
                }
            }
        }
        return currentList;
    }

}
