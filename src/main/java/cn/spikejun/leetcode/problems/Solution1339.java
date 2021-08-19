package cn.spikejun.leetcode.problems;

import cn.spikejun.leetcode.problems.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1339 {

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(1);
        TreeNode current=root;
        current.left=new TreeNode(2);
        current.right=new TreeNode(3);
        current=current.right;
        current.left=new TreeNode(6);
        current=root;
        current=current.left;
        current.left=new TreeNode(4);
        current.right=new TreeNode(5);
        int i = maxProduct(root);
        System.out.println(i);
    }


    private int mod= (int) (Math.pow(10,9)+7);
    public int maxProduct(TreeNode root) {
        List<Long>list=new ArrayList<>();
        //do suffix order
        suffOrder(root,list);
        Collections.sort(list);
        Long sum=list.get(list.size()-1);
        double target=sum/(2.0);
        if (list.get(0)>=target)
        {
            return (int) ((list.get(0)*(sum-list.get(0)))%mod);
        }
        int left=0;
        int right=list.size()-1;
        while (left<right)
        {
            int mid=left+(right-left)/2;
            if (list.get(mid)>=target)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        int index1=left;
        int index2=left-1;
        if ((sum-list.get(index1))*list.get(index1)>(sum-list.get(index2))*list.get(index2))
        {
            return (int) ((sum-list.get(index1))*list.get(index1)%mod);
        }
        return (int) ((sum-list.get(index2))*list.get(index2)%mod);
    }

    private Long suffOrder(TreeNode root, List<Long> list) {
        Long leftCount=0l;
        Long rightCount=0l;
        if (root.left!=null)
        {
            leftCount=suffOrder(root.left,list);
//            leftCount%=mod;
        }
        if (root.right!=null)
        {
            rightCount=suffOrder(root.right,list);
//            rightCount%=mod;
        }
        Long sum=(root.val+leftCount+rightCount);
        list.add(sum);
        return sum;
    }
}
