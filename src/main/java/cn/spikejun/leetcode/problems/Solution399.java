package cn.spikejun.leetcode.problems;

import org.junit.Test;
import org.w3c.dom.ls.LSException;

import java.lang.reflect.Array;
import java.util.*;

public class Solution399 {

    @Test
    public void test()
    {
        List<List<String>> equations=new ArrayList<>();
        List<String>list=new ArrayList<>();
        list.add("a");
        list.add("b");
        equations.add(list);
        list=new ArrayList<>();
        list.add("b");
        list.add("c");
        equations.add(list);
        double[]value=new double[]{2.0,3.0};
        List<List<String>> queries=new ArrayList<>();
        list=new ArrayList<>();
        list.add("a");
        list.add("c");
        queries.add(list);
        list=new ArrayList<>();
        list.add("b");
        list.add("a");
        queries.add(list);
        double[] doubles = calcEquation(equations, value, queries);
        System.out.println(Arrays.toString(doubles));
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer>map=new HashMap<>();
        int size = equations.size();
        int point=0;
        for (int i = 0; i < size; i++) {
            List<String> list = equations.get(i);
            if (!map.containsKey(list.get(0)))
            {
                map.put(list.get(0),point);
                point++;
            }
            if (!map.containsKey(list.get(1)))
            {
                map.put(list.get(1),point);
                point++;
            }
        }
        double[][]graph=new double[point][point];
        for (int i = 0; i < point; i++) {
            Arrays.fill(graph[i],-1.000);
        }
        for (int i = 0; i < values.length; i++) {
            double value = values[i];
            int a=map.get(equations.get(i).get(0));
            int b=map.get(equations.get(i).get(1));
            graph[a][b]=value;
            graph[b][a]=1.000/value;
        }
        for (int i = 0; i < point; i++) {
            for (int j = 0; j < point; j++) {
                for (int k = 0; k < point; k++) {
                    if (graph[j][i]>0&&graph[i][k]>0)
                    {
                        graph[j][k]=graph[j][i]*graph[i][k];
                    }
                }
            }
        }
        double []answ=new double[queries.size()];
        Arrays.fill(answ,-1.0);
        for (int i = 0; i < answ.length; i++) {
            List<String> list = queries.get(i);
            if (!map.containsKey(list.get(0))||!map.containsKey(list.get(1)))
            {
                continue;
            }
            int a=map.get(list.get(0));
            int b=map.get(list.get(1));
            if (graph[a][b]>=0)
            {
                answ[i]=graph[a][b];
            }
        }
        return answ;
    }
}
