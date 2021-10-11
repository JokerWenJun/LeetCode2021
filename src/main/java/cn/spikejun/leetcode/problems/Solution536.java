package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class Solution536 {

    @Test
    public void test()
    {
        String s="4(2(3)(1))(6(5))";
        TreeNode treeNode = str2tree(s);
        System.out.println("!!");
    }

    public TreeNode str2tree(String s) {
        if (s.equals(""))
        {
            return null;
        }

        Stack<TreeNode>stack=new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!='('&&chars[i]!=')')
            {
                String value="";
                if (chars[i]=='-')
                {
                    value+="-";
                    i++;
                }
                while (i<chars.length&&chars[i]>='0'&&chars[i]<='9')
                {
                    value+=chars[i];
                    i++;
                }
                i--;
                TreeNode treeNode=new TreeNode(Integer.parseInt(value));
                stack.add(treeNode);
            }
            else if (chars[i]==')')
            {
                TreeNode pop = stack.pop();
                TreeNode popParent = stack.pop();
                if (popParent.left==null)
                {
                    popParent.left=pop;
                }
                else if (popParent.right==null)
                {
                    popParent.right=pop;
                }
                stack.add(popParent);
            }
        }
        return stack.pop();
    }
}
