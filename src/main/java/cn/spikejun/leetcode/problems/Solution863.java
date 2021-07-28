package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

public class Solution863 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        TreeNode curr=root.left;
        curr.left=new TreeNode(6);
        curr.right=new TreeNode(2);
        curr=curr.right;
        curr.left=new TreeNode(7);
        curr.right=new TreeNode(4);
        curr=root;
        curr.right=new TreeNode(1);
        curr=curr.right;
        curr.left=new TreeNode(0);
        curr.right=new TreeNode(8);
        List<Integer> list = distanceK(root, root.left, 2);
        System.out.println(list);
    }



    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,List<TreeNode>>map=new HashMap<>();
        TreeNode current=root;
        List<TreeNode>list=new ArrayList<>();
        list.add(root);
        map.put(root,list);
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(current);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                List<TreeNode> pollList = map.get(poll);
                if (poll.left!=null)
                {
                    queue.add(poll.left);
                    List<TreeNode>leftList=new ArrayList<>(pollList);
                    leftList.add(poll.left);
                    map.put(poll.left,leftList);
                }
                if (poll.right!=null)
                {
                    queue.add(poll.right);
                    List<TreeNode>rightList=new ArrayList<>(pollList);
                    rightList.add(poll.right);
                    map.put(poll.right,rightList);
                }
            }
        }
        List<TreeNode> targetList = map.get(target);
        Set<TreeNode> treeNodes = map.keySet();
        List<Integer>answ=new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            List<TreeNode> currentTreeNodeList = map.get(treeNode);
            //判断是否符合
            int i=0;
            while (i<targetList.size()&&i<currentTreeNodeList.size()&&currentTreeNodeList.get(i)==targetList.get(i))
            {
                i++;
            }
            //总共共同的点
            int length=targetList.size()-i+currentTreeNodeList.size()-i;
            if (length==k)
            {
                answ.add(treeNode.val);
            }
        }
        return  answ;
    }
}
