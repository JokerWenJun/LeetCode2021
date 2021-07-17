package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution927 {

    @Test
    public void test()
    {

        int[]nums=new int[]{1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1};
        int[] ints1 = Arrays.copyOfRange(nums, 3, 4);
//        int[] ints = threeEqualParts(nums);
        System.out.println(Arrays.toString(ints1));


    }

    public int[] threeEqualParts(int[] arr) {
         int totalNumber1Count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1)
            {
                totalNumber1Count++;
            }
        }
        //判断其能不能被三除干净
        if(totalNumber1Count%3!=0)
        {
            return new int[]{-1,-1};
        }
        //如果1的个数为0
        if (totalNumber1Count/3==0)
        {
            return new int[]{0,arr.length-1};
        }
        //每一个区域应该分得1的个数
        int eachAreaNumberCount=totalNumber1Count/3;
        //第一个出现1的位置
        int i=-1;
        //第eachAreaNumberCount出现1的位置
        int j=-1;
        //第eachAreaNumberCount+1出现1的位置
        int i1=-1;
        //第2eachAreaNumberCount出现1的位置
        int j1=-1;
        int i2=-1;
        int j2=-1;
        int countNumber1=0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k]==1)
            {
                countNumber1++;
            }
            if (countNumber1==1&&i==-1)
            {
                i=k;
            }
            if (countNumber1==eachAreaNumberCount&&j==-1)
            {
                j=k;
            }
            if (countNumber1==eachAreaNumberCount+1&&i1==-1)
            {
                i1=k;
            }
            if (countNumber1==eachAreaNumberCount*2&&j1==-1)
            {
                j1=k;
            }
            if (countNumber1==2*eachAreaNumberCount+1&&i2==-1)
            {
                i2=k;
            }
           if (countNumber1==3*eachAreaNumberCount&&j2==-1)
            {
                j2=k;
            }
        }
        //
        int[]firstArr=Arrays.copyOfRange(arr,i,j+1);
        int[]secondArr=Arrays.copyOfRange(arr,i1,j1+1);
        int[]thirdArr=Arrays.copyOfRange(arr,i2,j2+1);
        if (!Arrays.equals(firstArr,secondArr))
        {
            return new int[]{-1,-1};
        }
        if (!Arrays.equals(firstArr,thirdArr))
        {
            return new int[]{-1,-1};
        }
        if (!Arrays.equals(thirdArr,secondArr))
        {
            return new int[]{-1,-1};
        }
        //判断后缀0的个数
        int length=arr.length;
        //
        int numberZeroCount=length-1-j2;
        int firstPosition=j+numberZeroCount;
        int secondPosition=j1+numberZeroCount;
        if (firstPosition>=i1||secondPosition>=i2)
        {
            return new int[]{-1,-1};
        }
        return new int[]{firstPosition,secondPosition+1};
    }

}
