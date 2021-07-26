package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1947 {

    @Test
    public void test()
    {
        int[][]stu=new int[][]
                {
                        {0,0},
                        {0,0},
                        {0,0}
                };
        int[][]teachers=new int[][]
                {
                        {1,1},
                        {1,1},
                        {1,1}
                };
        int i = maxCompatibilitySum(stu, teachers);
        System.out.println(i);
    }


    private int maxPoint=0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        //先统计每一个学生对老师的分数是多少
        int length = students.length;
        int questionsLength=students[0].length;
        int[][]points=new int[length][length];
        for (int i = 0; i < students.length; i++) {
            int[] currentStudent = students[i];
            for (int j = 0; j < mentors.length; j++) {
                int []currentMentor=mentors[j];
                int eachPoints=0;
                for (int k = 0; k < questionsLength; k++) {
                    if (currentMentor[k]==currentStudent[k])
                    {
                        eachPoints++;
                    }
                }
                points[i][j]=eachPoints;
            }
        }
        //进行全排列
        boolean[]visited=new boolean[length];
        List<Integer>teachers=new ArrayList<>();
        dfs(0,length,visited,points,teachers);
        return maxPoint;
    }

    private void dfs(int count, int target, boolean[] visited, int[][] points, List<Integer> teachers) {
        if (count==target)
        {
            int eachPoint=0;
            for (int i = 0; i < teachers.size(); i++) {
                int teacherIndex=teachers.get(i);
                eachPoint+=points[i][teacherIndex];
            }
            maxPoint=Math.max(eachPoint,maxPoint);
            return;
        }
        for (int i = 0; i < target; i++) {
            if (!visited[i])
            {
                teachers.add(i);
                visited[i]=true;
                dfs(count+1,target,visited,points,teachers);
                visited[i]=false;
                teachers.remove(teachers.size()-1);
            }
        }
    }

}
