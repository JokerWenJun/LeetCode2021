package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution815 {

    @Test
    public void test()
    {
        int[][]route=new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}};
//        int[][]route=new int[][]{{1,2,7},{3,6,7}};
        int i = numBusesToDestination(route, 0, 1000);
        System.out.println(i);
    }


    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target)
        {
            return 0;
        }

        int step=0;
        Map<Integer, List<Integer>>map=new HashMap<>();
        boolean canArrived=false;

        //将route转化为站点---公交1,公交2，公交3的hashmap
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> set = map.getOrDefault(routes[i][j], new ArrayList<>());
                set.add(i);
                map.put(routes[i][j],set);
                if (routes[i][j]==target)
                {
                    canArrived=true;
                }
            }
        }
        if (!canArrived)
        {
            return -1;
        }


        //创建queue
        //queue中每个数组代表的是:
        //0:当前的站点
        //1:乘坐哪个车到这个站点的
        Queue<int[]>queue=new ArrayDeque<>();
        queue.add(new int[]{source,-1});
        //创建访问集合
        Set<Integer>visited=new HashSet<>();
        visited.add(source);
        //开始BFS
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] peek = queue.poll();
                Integer currentStation=peek[0];
                Integer preTrain=peek[1];
                List<Integer> trainList = map.get(currentStation);
                //遍历trainList
                for (int j = 0; j < trainList.size(); j++) {
                    Integer nextTrain=trainList.get(j);
                    //如果下一步要坐的车与到这里的车一样则不选
                    if (nextTrain==preTrain)
                    {
                        continue;
                    }
                    //下一次要坐的车的路线
                    int[] nextTrainRoutes = routes[nextTrain];
                    for (int k = 0; k < nextTrainRoutes.length; k++) {
                        if (nextTrainRoutes[k]==target)
                        {
                            return step+1;
                        }
                        if (!visited.contains(nextTrainRoutes[k]))
                        {
                            Integer nextStation=nextTrainRoutes[k];
                            visited.add(nextStation);
                            queue.add(new int[]{nextStation,j});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
