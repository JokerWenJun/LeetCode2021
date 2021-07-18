package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.Stack;

public class Solution173 {

    class BSTIterator {

        private Stack<TreeNode>stack;
        public BSTIterator(TreeNode root) {
            stack=new Stack<>();
            TreeNode current=root;
            while (current!=null)
            {
                stack.add(current);
                current=current.left;
            }
        }

        public int next() {
            TreeNode pop = stack.pop();
            if (pop.right!=null)
            {
                TreeNode current=pop.right;
                while (current!=null)
                {
                    stack.add(current);
                    current=current.left;
                }
            }
            return pop.val;
        }

        public boolean hasNext() {
            if (stack.isEmpty())
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }


}
