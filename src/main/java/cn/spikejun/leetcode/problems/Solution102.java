package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution102 {


    public void test()
    {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {



        Queue<TreeNode>queue=new ArrayDeque<>();
        List<List<Integer>>answ=new ArrayList<>();
        if (root==null)
        {
            return answ;
        }
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer>eachFloor=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                eachFloor.add(poll.val);
                if (poll.left!=null)
                {
                    queue.add(poll.left);
                }
                if (poll.right!=null)
                {
                    queue.add(poll.right);
                }
            }
            answ.add(eachFloor);
        }
        return answ;
    }
}
