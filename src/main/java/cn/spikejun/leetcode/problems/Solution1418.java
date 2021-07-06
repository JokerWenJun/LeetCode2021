package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution1418 {

    @Test
    public void test()
    {
        List<List<String>> orders=new ArrayList<>();
        List<String>list1=new ArrayList<>();
        list1.add("David");
        list1.add("3");
        list1.add("Ceviche");
        List<String>list2=new ArrayList<>();
        list2.add("Corina");
        list2.add("10");
        list2.add("Beef Burrito");
        List<String>list3=new ArrayList<>();
        list3.add("David");
        list3.add("3");
        list3.add("Fried Chicken");
        List<String>list4=new ArrayList<>();
        list4.add("Carla");
        list4.add("5");
        list4.add("Water");
        List<String>list6=new ArrayList<>();
        list6.add("Carla");
        list6.add("5");
        list6.add("Ceviche");
        List<String>list5=new ArrayList<>();
        list5.add("Rous");
        list5.add("3");
        list5.add("Ceviche");
        orders.add(list1);
        orders.add(list2);
        orders.add(list3);
        orders.add(list4);
        orders.add(list5);
        orders.add(list6);
        List<List<String>> lists = displayTable(orders);
        System.out.println("!!!!");

    }


    class Order
    {
        public String name;
        public String orderNumber;
        public Map<String,Integer>meals;

        public Order(String name, String orderNumber) {
            this.name = name;
            this.orderNumber = orderNumber;
            meals=new HashMap<>();
        }

        public Order() {
            meals=new HashMap<>();
        }

        public Order(String name, String orderNumber, Map<String, Integer> meals) {
            this.name = name;
            this.orderNumber = orderNumber;
            this.meals = meals;
        }
    }
    public List<List<String>> displayTable(List<List<String>> orders) {
        int orderSize = orders.size();
        //统计所有的菜名
        Set<String> allMealsName=new HashSet<>();
        //创建优先队列
        PriorityQueue<Order>orderPriorityQueue=new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return new Integer(o1.orderNumber)-new Integer(o2.orderNumber);
            }
        });
        Map<String,Map<String,Integer>>map=new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            List<String> list = orders.get(i);
            for (int j = 1; j < list.size(); j++) {
                if (j==1)
                {
                    Map<String, Integer> stringStringMap = map.get(list.get(j));
                    if (stringStringMap==null)
                    {
                        map.put(list.get(j),new HashMap<String,Integer>());
                    }
                }
                else
                {
                    allMealsName.add(list.get(j));
                    Map<String, Integer> orderNum = map.get(list.get(1));
                    orderNum.put(list.get(j),(orderNum.getOrDefault(list.get(j),0)+1));
                }
            }
        }
        //
        Set<String> strings = map.keySet();
        for (String string : strings) {
            Order o=new Order();
            o.orderNumber=string;
            o.meals=map.get(string);
            orderPriorityQueue.add(o);
        }
        //对菜名进行排序
        PriorityQueue<String>mealsName=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String s : allMealsName) {
            mealsName.add(s);
        }
        //初始化完成
        /**
         * 1:allMealsName=所有菜的名字
         * 2:orderPriorityQueue:所有订单的队列
         * 3:mealsName=所有菜的名字的排序
         */
        List<List<String>>answ=new ArrayList<>();
        List<String>fistRow=new ArrayList<>();
        fistRow.add("Table");
        while (!mealsName.isEmpty())
        {
            fistRow.add(mealsName.poll());
        }
        answ.add(fistRow);
        int allMealsLength=allMealsName.size();
        while (!orderPriorityQueue.isEmpty())
        {
            List<String>eachRow=new ArrayList<>();
            Order peak = orderPriorityQueue.poll();
            eachRow.add(peak.orderNumber);
            Map<String, Integer> eachMeals = peak.meals;
            for (int i = 0; i < allMealsLength; i++) {
                String eachMealName=fistRow.get(1+i);
                Integer mealNumber = eachMeals.getOrDefault(eachMealName, 0);
                eachRow.add(mealNumber+"");
            }
            answ.add(eachRow);
        }
        return answ;
    }

}
