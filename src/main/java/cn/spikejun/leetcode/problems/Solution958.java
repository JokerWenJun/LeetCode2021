package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution958 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        boolean completeTree = isCompleteTree(root);
        System.out.println(completeTree);
    }


    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        boolean flag=false;
        int count=1;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            flag=false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left==null)
                {
                    flag=true;
                }
                else
                {
                    if (flag==true)
                    {
                        return false;
                    }
                    else
                    {
                        queue.add(poll.left);
                    }
                }
                if (poll.right==null)
                {
                    flag=true;
                }
                else
                {
                    if (flag==true)
                    {
                        return false;
                    }
                    else
                    {
                        queue.add(poll.right);
                    }
                }
            }
            //如果当前队列不为空，就代表其不是最后一层
            if (!queue.isEmpty())
            {
                if (size!=count)
                {
                    return false;
                }
            }
            count=count*2;
        }
        return true;
    }
}
