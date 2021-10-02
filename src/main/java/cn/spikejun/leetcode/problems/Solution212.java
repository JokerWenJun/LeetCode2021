package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution212 {

    @Test
    public void test()
    {
        char[][]board=new char[][]{{'a'}};
        String[]strings=new String[]{"a"};
        List<String> words = findWords(board, strings);
        System.out.println(words.toString());
    }

    class TreeDict
    {
        public TreeDict[]treeDicts=new TreeDict[26];
        public String word=null;
        public boolean isEnd=false;
    }

    public TreeDict dict=new TreeDict();
    public boolean[][]visited;
    public int[][]directions=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void insert(String word)
    {
        char[] chars = word.toCharArray();
        TreeDict current=dict;
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (current.treeDicts[currentChar-'a']==null)
            {
                current.treeDicts[currentChar-'a']=new TreeDict();
            }
            current=current.treeDicts[currentChar-'a'];
        }
        current.isEnd=true;
        current.word=word;
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String>answ=new ArrayList<>();

        //fist we  need to add each word into the tree dictionary
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        int rows = board.length;
        int columns = board[0].length;

        //then we need to create a two dimensionl array which is to record the dfs
        visited= new boolean[rows][columns];


        Set<String>set=new HashSet<>();

        //after that we need to dfs each cube of the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char currentChar = board[i][j];
                if (dict.treeDicts[currentChar-'a']!=null)
                {
                    visited[i][j]=true;
                    TreeDict currentNode=dict.treeDicts[currentChar-'a'];
                    dfs(i,j,set,words,board,currentNode);
                    visited[i][j]=false;
                }
            }
        }

        for (String s : set) {
            answ.add(s);
        }

        return answ;

    }

    private void dfs(int i, int j, Set<String>set, String[] words, char[][] board, TreeDict currentNode) {
        if (currentNode!=null&&currentNode.isEnd)
        {
            set.add(currentNode.word);
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int k = 0; k < directions.length; k++) {
            int newRow=i+directions[k][0];
            int newCol=j+directions[k][1];
            if (newRow<0||newCol<0||newRow>rows-1||newCol>cols-1)
            {
                continue;
            }
            if (visited[newRow][newCol]==true)
            {
                continue;
            }
            char newChar=board[newRow][newCol];
            TreeDict newNode = currentNode.treeDicts[board[newRow][newCol] - 'a'];
            if (newNode==null)
            {
                continue;
            }
            visited[newRow][newCol]=true;
            dfs(newRow,newCol,set,words,board,newNode);
            visited[newRow][newCol]=false;
        }


    }


}
