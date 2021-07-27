package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution671 {


    public int findSecondMinimumValue(TreeNode root) {
        int answ=-1;
        int min=root.val;
        //BFS遍历
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.val>min)
                {
                    if (answ==-1)
                    {
                        answ=poll.val;
                    }
                    else
                    {
                        answ=Math.min(answ,poll.val);
                    }
                }
                if (poll.left!=null)
                {
                    queue.add(poll.left);
                }
                if (poll.right!=null)
                {
                    queue.add(poll.right);
                }
            }
        }
        return answ;
    }
}
