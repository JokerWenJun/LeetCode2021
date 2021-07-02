package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SolutionOffer37 {

    @Test
    public void test()
    {
        Codec c=new Codec();
//        TreeNode root=new TreeNode(1);
//        TreeNode current=root;
//        current.left=new TreeNode(2);
//        current.right=new TreeNode(3);
//        current=current.right;
//        current.left=new TreeNode(4);
//        current.right=new TreeNode(5);
//        String serialize = c.serialize(root);
//        System.out.println(serialize);
        System.out.println("123".substring(0));
        Integer integer=new Integer("123");
        String s="[1,2,3,null,null,4,5,null,null,null,null,6,7,null,null]";
        c.deserialize(s);
        System.out.println(integer);
    }



    public class Codec {

        private Integer NOTEXIST=10000;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null)
            {
                return "[]";
            }
            TreeNode current=root;
            int depth=0;
            Queue<TreeNode>treeNodeQueue=new ArrayDeque<>();
            treeNodeQueue.add(current);
            while (!treeNodeQueue.isEmpty())
            {
                depth++;
                int size = treeNodeQueue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = treeNodeQueue.poll();
                    if (poll.left!=null)
                    {
                        treeNodeQueue.add(poll.left);
                    }
                    if (poll.right!=null)
                    {
                        treeNodeQueue.add(poll.right);
                    }
                }
            }
            int length= (int) (Math.pow(2,depth)-1);
            List<String> serializeArray=new ArrayList<>();
            treeNodeQueue=new ArrayDeque<>();
            treeNodeQueue.add(root);
            int level=0;
            while (!treeNodeQueue.isEmpty())
            {
                level++;
                int currentLevelSize = (int) Math.pow(2,level-1);
                for (int i = 0; i < currentLevelSize; i++) {
                    //当前不是最后一层
                    if (level!=depth)
                    {
                        TreeNode currentNode=treeNodeQueue.poll();
                        if (currentNode.val==NOTEXIST)
                        {
                            serializeArray.add("null");
                            treeNodeQueue.add(new TreeNode(NOTEXIST));
                            treeNodeQueue.add(new TreeNode(NOTEXIST));
                        }
                        else
                        {
                            serializeArray.add(currentNode.val+"");
                            if (currentNode.left==null)
                            {
                                treeNodeQueue.add(new TreeNode(NOTEXIST));
                            }
                            else
                            {
                                treeNodeQueue.add(currentNode.left);
                            }
                            if (currentNode.right==null)
                            {
                                treeNodeQueue.add(new TreeNode(NOTEXIST));
                            }
                            else
                            {
                                treeNodeQueue.add(currentNode.right);
                            }
                        }
                    }
                    //当前是最后一层
                    else
                    {
                        TreeNode currentNode=treeNodeQueue.poll();
                        if (currentNode.val==NOTEXIST)
                        {
                            serializeArray.add("null");
                        }
                        else
                        {
                            serializeArray.add(currentNode.val+"");
                        }
                    }
                }
            }
            StringBuffer answ=new StringBuffer();
            answ.append('[');
            for (int i = 0; i < serializeArray.size(); i++) {
                    if (i==serializeArray.size()-1)
                    {
                        answ.append(serializeArray.get(i));
                    }
                    else
                    {
                        answ.append(serializeArray.get(i)).append(',');
                    }
            }
            answ.append(']');
            return answ.toString();
        }



        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]"))
            {
                return null;
            }
            data = data.substring(1);
            data=data.substring(0,data.length()-1);
            String[] split = data.split(",");
            int depth= (int) (Math.log(split.length+1)/Math.log(2));
            if (split[0].equals("null"))
            {
                return null;
            }
            Queue<TreeNode>queue=new ArrayDeque<>();
            TreeNode root=new TreeNode(new Integer(split[0]));
            queue.add(root);
            int leve=1;
            int begin=1;

            while (!queue.isEmpty())
            {
                leve++;
                if (leve>depth)
                {
                    break;
                }
                int count= (int) Math.pow(2,leve-1);
                for (int i = 0; i < count; i=i+2,begin=begin+2) {
                    String lchild=split[begin];
                    String rchild=split[begin+1];
                    TreeNode poll = queue.poll();
                    if (!lchild.equals("null"))
                    {
                        poll.left=new TreeNode(new Integer(lchild));
                        queue.add(poll.left);
                    }
                    else
                    {
                        queue.add(new TreeNode(NOTEXIST));
                    }
                    if (!rchild.equals("null"))
                    {
                        poll.right=new TreeNode(new Integer(rchild));
                        queue.add(poll.right);
                    }
                    else
                    {
                        queue.add(new TreeNode(NOTEXIST));
                    }
                }


            }
            return root;
        }
    }




}
