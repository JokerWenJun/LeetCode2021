package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.*;

public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>answ=new ArrayList<>();
        if (root==null)
        {
            return answ;
        }
        int currentRow=1;
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            List<Integer>current=new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                current.add(poll.val);
                if (poll.left!=null)
                {
                    queue.add(poll.left);
                }
                if (poll.right!=null)
                {
                    queue.add(poll.right);
                }
            }
            if (currentRow%2==0)
            {
                Collections.reverse(current);
            }
            answ.add(current);
            currentRow++;
        }
        return answ;
    }
}

/**
 * s = "ADOBECODEBANC", t = "ABC"
 * map= t
 *
 * currentMap=
 *
 *
 *
 *
 * t->map original map
 * current Map
 *
 *
 * ADOBEC ODEBANC
 * A DOBEC ODEBANC map->value=0;
 * A DOBECODEBA NC map =t;
 *
 *
 *
 *
 *
 */