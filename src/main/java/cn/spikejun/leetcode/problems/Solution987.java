package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;

import java.util.*;

public class Solution987 {

    class NewTreeNode
    {
        public TreeNode currentTreeNode;
        public int position;
        public NewTreeNode() {
        }

        public NewTreeNode(TreeNode currentTreeNode, int position) {
            this.currentTreeNode = currentTreeNode;
            this.position = position;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>answ=new ArrayList<>();
        if (root==null)
        {
            return answ;
        }
        //初始化
        Map<Integer,List<Integer>>totalMap=new HashMap<>();
        Queue<NewTreeNode>queue=new ArrayDeque<>();
        int depth=0;
        NewTreeNode newTreeNode=new NewTreeNode(root,depth);
        queue.add(newTreeNode);
        //开始bfs
        while (!queue.isEmpty())
        {
            int size = queue.size();
            Map<Integer,List<Integer>>currentRowMap=new HashMap<>();
            for (int i = 0; i < size; i++) {
                NewTreeNode poll = queue.poll();
                TreeNode currentTreeNode = poll.currentTreeNode;
                int currentPosition = poll.position;
                if (!currentRowMap.containsKey(currentPosition))
                {
                    List<Integer>currentRowEachPositionList=new ArrayList<>();
                    currentRowEachPositionList.add(currentTreeNode.val);
                    currentRowMap.put(currentPosition,currentRowEachPositionList);
                }
                else
                {
                    List<Integer> currentRowEachPositionList = currentRowMap.get(currentPosition);
                    currentRowEachPositionList.add(currentTreeNode.val);
                    currentRowMap.put(currentPosition,currentRowEachPositionList);
                }
                //处理当前节点下面的节点
                if (currentTreeNode.left!=null)
                {
                    NewTreeNode left=new NewTreeNode(currentTreeNode.left,currentPosition-1);
                    queue.add(left);
                }
                if (currentTreeNode.right!=null)
                {
                    NewTreeNode right=new NewTreeNode(currentTreeNode.right,currentPosition+1);
                    queue.add(right);
                }
            }
            //将当前行的map与之前的map合并，注意先要让当前的map排序
            Set<Integer> set = currentRowMap.keySet();
            for (Integer integer : set) {
                List<Integer> list = currentRowMap.get(integer);
                Collections.sort(list);
                if (totalMap.containsKey(integer))
                {
                    List<Integer> integerList = totalMap.get(integer);
                    integerList.addAll(list);
                    totalMap.put(integer,integerList);
                }
                else
                {
                    totalMap.put(integer,list);
                }
            }
        }
        Set<Integer> set = totalMap.keySet();
        List<Integer>index=new ArrayList<>();
        for (Integer integer : set) {
            index.add(integer);
        }
        Collections.sort(index);
        for (int i = 0; i < index.size(); i++) {
            Integer currentIndex = index.get(i);
            answ.add(totalMap.get(currentIndex));
        }
        return answ;
    }
}
