package cn.spikejun.leetcode.problems;

public class Solution189 {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            k = k % length;
            int[]newArr=nums.clone();
            int index=0;
            for (int i = length-k; i < length; i++) {
                nums[index]=newArr[i];
                index++;
            }
            int originalBegin=0;
            for (int i = k; i < length; i++) {
                nums[i]=newArr[originalBegin];
                originalBegin++;
            }
            return;
        }

}
