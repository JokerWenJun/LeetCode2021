package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution207 {

    @Test
    public void test()
    {
        int[][]arr=new int[][]{{1,0},{1,2},{0,1}};
        boolean b = canFinish(3, arr);
        System.out.println(b);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //是否有先行课
        boolean[]havePreCourse=new boolean[numCourses];
        Map<Integer, List<Integer>>map=new HashMap<>();
        Map<Integer,List<Integer>>eachCondition=new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int suffixCourse=prerequisite[0];
            int preCourse = prerequisite[1];
            havePreCourse[suffixCourse]=true;
            if (map.containsKey(preCourse))
            {
                map.get(preCourse).add(suffixCourse);
            }
            else
            {
                List<Integer>list=new ArrayList<>();
                list.add(suffixCourse);
                map.put(preCourse,list);
            }
            if (eachCondition.containsKey(suffixCourse))
            {
                eachCondition.get(suffixCourse).add(preCourse);
            }
            else
            {
                List<Integer>list=new ArrayList<>();
                list.add(preCourse);
                eachCondition.put(suffixCourse,list);
            }
        }
        Queue<Integer>queue=new ArrayDeque<>();
        Set<Integer>visited=new HashSet<>();
        //找出哪些没有先行课的，加入到队列里面
        for (int i = 0; i < havePreCourse.length; i++) {
            if (havePreCourse[i]==false)
            {
                visited.add(i);
                queue.add(i);
            }
        }
        //开始BFS
        while (!queue.isEmpty())
        {
            Integer poll = queue.poll();
            if (map.containsKey(poll))
            {
                List<Integer> list = map.get(poll);
                for (int i = 0; i < list.size(); i++) {
                    if (!visited.contains(list.get(i))&&alReadyHaveCourse(eachCondition,visited,list.get(i)))
                    {
                        visited.add(list.get(i));
                        queue.add(list.get(i));
                    }
                }
            }
        }
        if (visited.size()==numCourses)
        {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean alReadyHaveCourse(Map<Integer, List<Integer>> eachCondition, Set<Integer> visited, Integer course) {
        List<Integer> list = eachCondition.get(course);
        for (Integer integer : list) {
            if (!visited.contains(integer))
            {
                return false;
            }
        }
        return true;
    }
}
