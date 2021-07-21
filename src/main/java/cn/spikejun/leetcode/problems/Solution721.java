package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.*;

public class Solution721 {
//    [["David","David0@m.co","David4@m.co","David3@m.co"],
//    ["David","David5@m.co","David5@m.co","David0@m.co"],
//    ["David","David1@m.co","David4@m.co","David0@m.co"],
//    ["David","David0@m.co","David1@m.co","David3@m.co"],
//    ["David","David4@m.co","David1@m.co","David3@m.co"]]
    @Test
    public void test()
    {
        List<List<String>> accounts=new ArrayList<>();
        String[]strings=new String[]{"David","David0@m.co","David4@m.co","David3@m.co"};
        List<String> stringList = Arrays.asList(strings);
        accounts.add(stringList);
        strings=new String[]{"David","David5@m.co","David5@m.co","David0@m.co"};
        stringList = Arrays.asList(strings);
        accounts.add(stringList);
        strings=new String[]{"David","David1@m.co","David4@m.co","David0@m.co"};
        stringList = Arrays.asList(strings);
        accounts.add(stringList);
        strings=new String[]{"David","David0@m.co","David1@m.co","David3@m.co"};
        stringList = Arrays.asList(strings);
        accounts.add(stringList);
        strings=new String[]{"David","David4@m.co","David1@m.co","David3@m.co"};
        stringList = Arrays.asList(strings);
        accounts.add(stringList);
        List<List<String>> lists = accountsMerge(accounts);
        System.out.println("!!!!!");
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //邮箱--序号表
        Map<String,Integer>emailToIndex=new HashMap<>();
        //序号-邮箱
        Map<Integer,String>indexToMail=new HashMap<>();
        //邮箱--名字
        Map<String,String>emailToName=new HashMap<>();
        //将每一个邮箱存储到两个map里面
        int index=0;
        for (int i = 0; i < accounts.size(); i++) {
            List<String> eachAccount = accounts.get(i);
            String name = eachAccount.get(0);
            for (int j = 1; j < eachAccount.size(); j++) {
                if (!emailToIndex.containsKey(eachAccount.get(j)))
                {
                    emailToIndex.put(eachAccount.get(j),index);
                    emailToName.put(eachAccount.get(j),name);
                    indexToMail.put(index,eachAccount.get(j));
                    index++;
                }
            }
        }
        //此时index+1的数量就是此时邮箱的数量
        //创建并合集
        UnionFind uf=new UnionFind(indexToMail.size());
        //利用合并集将所有的邮箱进行合并
        for (int i = 0; i < accounts.size(); i++) {
            List<String> eachAccount = accounts.get(i);
            String firstEmail = eachAccount.get(1);
            Integer firstEmailIndex = emailToIndex.get(firstEmail);
            for (int j = 2; j < eachAccount.size(); j++) {
                String otherEamil = eachAccount.get(j);
                Integer otherEmailIndex = emailToIndex.get(otherEamil);
                //将每一个账号的第n个email和第一个账号进行合并
                uf.merge(firstEmailIndex,otherEmailIndex);
            }
        }
        //创建map将所有是一个人的邮箱集合到一起
        Map<Integer,List<String>>indexToAllEmails=new HashMap<>();
        Set<Integer> set = indexToMail.keySet();
        for (Integer eamilIndex : set) {
            //找到的是它爹的index
            int parentIndex = uf.find(eamilIndex);
            //找到他爹下面的从属邮箱，如果没有就创建一个
            List<String> list = indexToAllEmails.getOrDefault(parentIndex, new ArrayList<>());
            //将每一个邮箱加到从属邮箱集合里面
            list.add(indexToMail.get(eamilIndex));
            indexToAllEmails.put(parentIndex,list);
        }
        //创建答案集合
        List<List<String>>answ=new ArrayList<>();
        //遍历indexToAllEmails
        Set<Integer> keySet = indexToAllEmails.keySet();
        for (Integer integer : keySet) {
            List<String>eachRows=new ArrayList<>();
            String name = emailToName.get(indexToMail.get(integer));
            eachRows.add(name);
            List<String> allEmails = indexToAllEmails.get(integer);
            Collections.sort(allEmails);
            eachRows.addAll(allEmails);
            answ.add(eachRows);
        }
        return answ;
    }
    class UnionFind
    {
        private int[]parents;
        public UnionFind(int n) {
            parents=new int[n];
            for (int i = 0; i < n; i++) {
                parents[i]=i;
            }
        }
        public int find(int x)
        {
            if (parents[x]!=x)
            {
                parents[x]=find(parents[x]);
            }
            return parents[x];
        }
        public void merge(int x,int y)
        {
            int rootX=find(x);
            int rootY=find(y);
            if (rootX==rootY)
            {
                return;
            }
            parents[rootY]=rootX;
        }
    }
}
