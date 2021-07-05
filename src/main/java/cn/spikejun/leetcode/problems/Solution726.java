package cn.spikejun.leetcode.problems;

import com.sun.org.apache.xpath.internal.objects.XNumber;
import org.junit.Test;

import java.util.*;

public class Solution726 {

    @Test
    public void test()
    {

        String formula="Mg((H2O)2Na)4(F)(H2SO4)N";
        String s = countOfAtoms(formula);
        System.out.println(s);

//        System.out.println("Mg".compareTo("O"));
//        PriorityQueue<Element>priorityQueue=new PriorityQueue<>(new Comparator<Element>() {
//            @Override
//            public int compare(Element o1, Element o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        });
//        priorityQueue.add(new Element("Mg",1));
//        priorityQueue.add(new Element("H",1));
//        priorityQueue.add(new Element("O",1));
//        System.out.println(priorityQueue.poll().name);

    }


    class Element
    {
        String name;
        int count;

        public Element(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public Element() {
        }
    }

    public String countOfAtoms(String formula) {

//        if (formula.charAt(formula.length()-1)==')')
//        {
//            formula=formula+"1";
//        }

        char[] charArray = formula.toCharArray();
        Deque<String> queue=new ArrayDeque<>();
        int i=0;
        /**
         * 每次charArray[i]只有三种情况
         * 1：数字
         * 2：元素的第一个大写
         * 3：括号
         */
        while (i<charArray.length)
        {
            if (charArray[i]>='A'&&charArray[i]<='Z')
            {
                i++;
                while (i<charArray.length&&charArray[i]>='a'&&charArray[i]<='z')
                {
                    i++;
                }
                if (i<charArray.length)
                {
                    //判断一下下个字符是什么，如果不是数字的话queue里面要加入一个1
                    if (!(charArray[i]>='1'&&charArray[i]<='9'))
                    {
                        queue.addLast("1");
                    }
                }
                else
                {
                    queue.addLast("1");
                }
                continue;
            }
            if (charArray[i]=='(')
            {
                queue.addLast("(");
                i++;
                continue;
            }
            if (charArray[i]==')')
            {
                queue.addLast(")");
                i++;
                if (i>=charArray.length||!(charArray[i]>='1'&&charArray[i]<='9'))
                {
                    queue.pollLast();
                    //创建一个临时存储的容器
                    List<String>temp=new LinkedList<>();
                    while (!(queue.getLast().equals("(")))
                    {
                        String top=queue.pollLast();
                        temp.add(top);
                    }
                    //排出(
                    queue.pollLast();
                    //将temp的元素再次入栈
                    for (int j = temp.size()-1; j >= 0; j--) {
                        queue.addLast(temp.get(j));
                    }
                }
                continue;
            }
            if (charArray[i]>='1'&&charArray[i]<='9')
            {
                StringBuffer number=new StringBuffer();
                number.append(charArray[i]);
                i++;
                while (i<charArray.length&&charArray[i]>='0'&&charArray[i]<='9')
                {
                    number.append(charArray[i]);
                    i++;
                }
                //如果是第一个数字就直接加入
                if (queue.isEmpty())
                {
                    queue.addLast(number.toString());
                    continue;
                }
                //判断前面一个符号是不是)
                String last = queue.getLast();
                //如果是:
                if (last.equals(")"))
                {
                    //转化倍数
                    Integer count=new Integer(number.toString());
                    //首先排出)
                    queue.pollLast();
                    //创建一个临时存储的容器
                    List<Integer>temp=new LinkedList<>();
                    while (!(queue.getLast().equals("(")))
                    {
                        String top=queue.pollLast();
                        Integer newNum=count*new Integer(top);
                        temp.add(newNum);
                    }
                    //排出(
                    queue.pollLast();
                    //将temp的元素再次入栈
                    for (int j = temp.size()-1; j >= 0; j--) {
                        queue.addLast(""+temp.get(j));
                    }
                }
                //如果不是
                else
                {
                  queue.addLast(number.toString());
                }
                continue;
            }
        }
//        System.out.println("第一个测试");
        //创建元素计数表
        Map<String,Integer>elementCountMap=new HashMap<>();
        i=0;
        while (i<charArray.length)
        {
            if (charArray[i]>='A'&&charArray[i]<='Z')
            {
                StringBuffer elementName=new StringBuffer();
                elementName.append(charArray[i]);
                i++;
                while (i<charArray.length&&charArray[i]>='a'&&charArray[i]<='z')
                {
                    elementName.append(charArray[i]);
                    i++;
                }
                //当前的元素已经形成
                String name=elementName.toString();
                Integer count=new Integer(queue.pollFirst());
                elementCountMap.put(name,elementCountMap.getOrDefault(name,0)+count);
                continue;
            }
            else
            {
                i++;
            }
        }
//        System.out.println("第二个测试");
        //创建优先队列
        PriorityQueue<Element>priorityQueue=new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        //元素计数表加入到优先队列中
        Set<String> keys = elementCountMap.keySet();
        for (String key : keys) {
            String name=key;
            Integer count=elementCountMap.get(key);
            priorityQueue.add(new Element(key,count));
        }
        StringBuffer answBuffer=new StringBuffer();
        while (!priorityQueue.isEmpty())
        {
            Element poll = priorityQueue.poll();
            answBuffer.append(poll.name);
            if (poll.count>1)
            {
                answBuffer.append(poll.count);
            }
        }
        String answ=answBuffer.toString();
//        System.out.println("第三个测试");
        return answ;
    }


}
