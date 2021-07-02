package cn.spikejun.leetcode.problems;

import org.junit.Test;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1239 {

    @Test
    public void test()
    {
        List<String> arr=new ArrayList<>();
        arr.add("ab");
        arr.add("cd");
        arr.add("cde");
        arr.add("cdef");
        arr.add("efg");
        arr.add("fgh");
        arr.add("abxyz");
        System.out.println(maxLength(arr));

//        System.out.println("".contains("ab"+""));

    }

    int max=0;
    public int maxLength(List<String> arr) {
        int location=0;
        String prefix="";
        dfs(arr,location,prefix);
        return max;
    }

    private void dfs(List<String> arr, int location, String prefix) {
        if (location>=arr.size())
        {
            return;
        }
        for (int i = location; i < arr.size(); i++) {
            String suffix = arr.get(i);
            boolean conflict=isConflict(prefix,suffix);
            if (!conflict)
            {
                continue;
            }
            String newString=new String(prefix+suffix);
//            System.out.println(newString);
            this.max=Math.max(this.max,newString.length());
            dfs(arr,i+1,newString);
        }
    }

    private boolean isConflict(String prefix, String suffix) {
        StringBuffer current=new StringBuffer(prefix);
        for (int i = 0; i < suffix.length(); i++) {
            if (current.toString().contains(suffix.charAt(i)+"")) {
                return false;
            }
            else
            {
                current.append(suffix.charAt(i));
            }
        }
        return true;
    }


    public int maxLength1(List<String> arr) {
        List<Map<Integer,Integer>>countABC=new ArrayList<>();
        int[]dp=new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            String currentString=arr.get(i);
            Map<Integer,Integer>single=new HashMap<>();
            boolean isFalse=false;
            for (int j = 0; j < currentString.length(); j++) {
                single.put(currentString.charAt(j)-'a'+1,single.getOrDefault(currentString.charAt(j)-'a'+1,0)+1);
                if (single.get(currentString.charAt(j)-'a'+1)>1)
                {
                    countABC.add(null);
                    isFalse=true;
                    break;
                }
            }
            if (!isFalse)
            {
                dp[i]=currentString.length();
                single.put(27,currentString.length());
                countABC.add(single);
            }
            else
            {
                dp[i]=Integer.MAX_VALUE-10000;
            }
        }
        int answ=-1;
        for (int i = 0; i < countABC.size(); i++) {
            if (countABC.get(i)!=null)
            {
                int currentSize=countABC.get(i).get(27);
                Map<Integer, Integer> updateMap=null;
                for (int j = 0; j < i; j++) {
                    Map<Integer, Integer> currentInside = countABC.get(j);
                    if (currentInside!=null)
                    {
                        //如果里面的最长大于现在的最长
                       if (dp[j]+currentSize>dp[i])
                       {
                           //判断currentInside和当前的有无冲突
                           Map<Integer,Integer>newMap=judgeConflict(currentInside,countABC.get(i));
                           if (newMap!=null)
                           {
                               updateMap=newMap;
                               dp[i]=updateMap.size();
                           }
                       }
                    }
                }
                if (updateMap!=null)
                {
                    countABC.set(i,updateMap);
                    updateMap.put(27,updateMap.size());
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            answ=Math.max(answ,dp[i]);
        }
        return answ==Integer.MAX_VALUE-10000?0:answ;
    }

    private Map<Integer, Integer> judgeConflict(Map<Integer, Integer> currentInside, Map<Integer, Integer> integerIntegerMap) {
        Map<Integer, Integer>answ=new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            Integer integer1 = currentInside.get(i);
            Integer integer2 = integerIntegerMap.get(i);
            if (integer1!=null&&integer2!=null)
            {
                return null;
            }
            else
            {
                if (integer1==null&&integer2==null)
                {
                    continue;
                }
                else
                {
                    if (integer1==null)
                    {
                        integer1=0;
                    }
                    if (integer2==null)
                    {
                        integer2=0;
                    }
                    answ.put(i,integer1+integer2);
                }
            }
        }
        return answ;
    }


}
