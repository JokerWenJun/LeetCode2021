package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution101 {

    private Integer NOTEXIST=101;
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        List<Integer>currentRow=new ArrayList<>();
        currentRow.add(root.val);
        while (!queue.isEmpty())
        {
            currentRow=new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null)
                {
                    queue.add(poll.left);
                    currentRow.add(poll.left.val);
                }
                else
                {
                    currentRow.add(NOTEXIST);
                }
                if (poll.right!=null)
                {
                    queue.add(poll.right);
                    currentRow.add(poll.right.val);
                }
                else
                {
                    currentRow.add(NOTEXIST);
                }
            }
            //判断currentRow是否对称
            if (!isSymmetry(currentRow))
            {
                return false;
            }
        }
        return true;
    }

    private boolean isSymmetry(List<Integer> currentRow) {
        int size = currentRow.size();
        if (size%2!=0)
        {
            return false;
        }
        for (int i = 0; i < size/2; i++) {
            if (currentRow.get(i)!=currentRow.get(size-1-i))
            {
                return false;
            }
        }
        return true;
    }
}
