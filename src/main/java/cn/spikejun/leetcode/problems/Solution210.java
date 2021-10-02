package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class Solution210 {
    @Test
    public void test()
    {
        int n=2;
        int[][]course=new int[][]{{1,0}};
        int[] order = findOrder(2, course);
        System.out.println(Arrays.toString(order));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int[]eachCourseInDegree=new int[numCourses];
        List<Integer>route=new ArrayList<>();
        Map<Integer,List<Integer>>eachCourseOutDegree=new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int courseIndex = prerequisite[0];
            int currentCoursePre=prerequisite[1];
            if (eachCourseOutDegree.containsKey(currentCoursePre))
            {
                eachCourseOutDegree.get(currentCoursePre).add(courseIndex);
            }
            else
            {
                List<Integer>list=new ArrayList<>();
                list.add(courseIndex);
                eachCourseOutDegree.put(currentCoursePre,list);
            }
            eachCourseInDegree[courseIndex]++;
        }
        Deque<Integer>deque=new ArrayDeque<>();
        //sum the courses which are zero Indegree
        for (int i = 0; i < eachCourseInDegree.length; i++) {
            if (eachCourseInDegree[i]==0)
            {
                deque.add(i);
                route.add(i);
            }
        }
        //bfs the dequeue
        while (!deque.isEmpty())
        {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer poll = deque.poll();
                List<Integer> list = eachCourseOutDegree.get(poll);
                if (list!=null)
                {
                    for (int j = 0; j < list.size(); j++) {
                        eachCourseInDegree[list.get(j)]--;
                        if (eachCourseInDegree[list.get(j)]==0)
                        {
                            deque.add(list.get(j));
                            route.add(list.get(j));
                        }
                    }
                }
            }
        }
        if (route.size()!=numCourses)
        {
            return new int[]{};
        }
        int[]answ=new int[numCourses];
        for (int i = 0; i < answ.length; i++) {
            answ[i]=route.get(i);
        }
        return answ;
    }


}
