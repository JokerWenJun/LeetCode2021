package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionOffer26 {

    @Test
    public void test()
    {
        TreeNode A=new TreeNode(1);
        TreeNode cA=A;
        cA.left=new TreeNode(2);
        cA=cA.left;
        cA.left=new TreeNode(3);
        cA=cA.left;
        cA.left=new TreeNode(4);
        cA=cA.left;
        TreeNode B=new TreeNode(3);
        TreeNode cB=B;
        boolean subStructure = isSubStructure(A, B);
        System.out.println(subStructure);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //first we need to bfs the TreeA, select each point which have same value of the root TreeB

        if(B==null)
        {
            return false;
        }
        Deque<TreeNode>deque=new ArrayDeque<>();
        deque.add(A);


        while (!deque.isEmpty())
        {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (B.val==poll.val)
                {
                    if (dfsJudge(poll,B))
                    {
                        return true;
                    }
                }
                if (poll.left!=null)
                {
                    deque.add(poll.left);
                }
                if (poll.right!=null)
                {
                    deque.add(poll.right);
                }
            }
        }
        return false;
    }

    private boolean dfsJudge(TreeNode a, TreeNode b) {
        if (a==null||a.val!=b.val)
        {
            return false;
        }
        if (a.val==b.val)
        {
            boolean left=true;
            boolean right=true;
            left=b.left==null?true:dfsJudge(a.left,b.left);
            right=b.right==null?true:dfsJudge(a.right,b.right);
            if (left&&right)
            {
                return true;
            }
        }
        return false;
    }
}
