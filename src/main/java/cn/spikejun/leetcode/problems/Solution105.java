package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

public class Solution105 {

    @Test
    public void test()
    {
        int[]preorder=new int[]{3,9,1,11,7,5,4,20,15,12,31,9,6};
        int[]inorder=new int[]{11,1,9,5,7,4,3,31,12,15,9,20,6};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println("!!!");
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int midLocation=0;
        int preLocation=0;
        int left=0;
        int right=preorder.length-1;
        int rootVale=preorder[0];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i]==rootVale)
            {
                midLocation=i;
            }
        }
        TreeNode root=new TreeNode(rootVale);
        buildSmallTree(root,left,right,midLocation,preLocation,preorder,inorder);
        return root;
    }

    private void buildSmallTree(TreeNode root, int left, int right, int midLocation, int preLocation,int[]preorder,int[]inorder) {
        if (right==left)
        {
            return;
        }
        int LchildLength=midLocation-left;
        int RchildLength=right-midLocation;
        if (LchildLength>0)
        {
            int leftChildValue=preorder[preLocation+1];
            int leftChildMidOrderLocation=midLocation;
            for (int i=left;i<midLocation;i++)
            {
                if (inorder[i]==leftChildValue)
                {
                    leftChildMidOrderLocation=i;
                }
            }
            TreeNode leftChildNode=new TreeNode(leftChildValue);
            root.left=leftChildNode;
            buildSmallTree(leftChildNode,left,midLocation-1,leftChildMidOrderLocation,preLocation+1,preorder,inorder);
        }
        if (RchildLength>0)
        {
            int rightChildValue=preorder[preLocation+LchildLength+1];
            int rightChildOrderLocation=midLocation;
            for (int i=midLocation+1;i<=right;i++)
            {
                if (inorder[i]==rightChildValue)
                {
                    rightChildOrderLocation=i;
                }
            }
            TreeNode rightChildNode=new TreeNode(rightChildValue);
            root.right=rightChildNode;
            buildSmallTree(rightChildNode,midLocation+1,right,rightChildOrderLocation,preLocation+LchildLength+1,preorder,inorder);
        }
    }


}
