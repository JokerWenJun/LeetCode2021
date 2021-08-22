package cn.spikejun.leetcode.problems;

public class Solution789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int step=Math.abs(target[0]-0)+Math.abs(target[1]-0);
        int length = ghosts.length;
        for (int i = 0; i < length; i++) {
            int eachGhostDistance=Math.abs(ghosts[i][0]-target[0])+Math.abs(ghosts[i][1]-target[1]);
            if (eachGhostDistance<=step)
            {
                return false;
            }
        }
        return true;
    }
}
