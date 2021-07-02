package cn.spikejun.leetcode.problems;

import java.util.*;

public class Solution1600 {

    class ThroneInheritance {
        private String kingName;
        private Set<String>deadName;
        Map<String,List<String>>order;
        public ThroneInheritance(String kingName) {
            this.kingName=kingName;
            order=new HashMap<>();
            deadName=new HashSet<>();
            this.order.put(kingName,new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            if (order.get(parentName)!=null)
            {
                List<String> childNames = order.get(parentName);;
                childNames.add(childName);
            }
            else
            {
                List<String>currentChildrens=new ArrayList<>();
                currentChildrens.add(childName);
                this.order.put(parentName,currentChildrens);
            }
        }

        public void death(String name) {
            deadName.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String>order=new ArrayList<>();
            dfs(order,this.kingName);
            return order;
        }
        private void dfs(List<String>orderList,String current)
        {
            if (!this.deadName.contains(current))
            {
                orderList.add(current);
            }
            List<String> currentChildrens = this.order.get(current);
            if (currentChildrens==null)
            {
                return;
            }
            else
            {
                for (int i = 0; i < currentChildrens.size(); i++) {
                    dfs(orderList,currentChildrens.get(i));
                }
            }
        }
    }

}
