package cn.spikejun.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;

public class Solution887 {

    @Test
    public void test()
    {
        int i = superEggDrop(3, 15);
        System.out.println(i);
    }


    //k=鸡蛋;n=楼房
    public int superEggDrop(int k, int n) {
        //创建dp数组
        int[][]dp=new int[n+1][k+1];
        //当楼层为0时，无论鸡蛋多少次数都为0
        for (int i = 0; i <= k; i++) {
            dp[0][i]=0;
        }
        //当鸡蛋为0时，无论楼层多高，次数也都为0
        for (int i = 0; i <= n; i++) {
            dp[i][0]=0;
        }
        //当楼层为1时，除了鸡蛋为0的情况下为0，其他都为1
        for (int i = 1; i <= k; i++) {
            dp[1][i]=1;
        }
        //当鸡蛋为1时，层数多少次数为多少
        for (int i = 1; i <= n; i++) {
            dp[i][1]=i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                int left=1;
                int right=i;
                while (left<right)
                {
                    int mid=left+(right-left)/2;
                    int notBreakTheEgg=dp[i-mid][j];
                    int breakTheEgg=dp[mid-1][j-1];

                    if (notBreakTheEgg<=breakTheEgg)
                    {
                        right=mid;
                    }
                    else
                    {
                        left=mid+1;
                    }
                }
//                System.out.println(left);
//                System.out.println(right);;
                left=left-1;
                int leftAnsw=Math.max(dp[left-1][j-1],dp[i-left][j]);
                int rihgtAnsw=Math.max(dp[right-1][j-1],dp[i-right][j]);
                dp[i][j]=Math.min(leftAnsw,rihgtAnsw)+1;
            }
        }


        int answ=dp[n][k];

        return answ;
    }

    public int superEggDrop1(int K, int N) {
        // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
        int[][] dp = new int[N + 1][K + 1];

        // 初始化
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }

        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 开始递推
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[N][K];
    }



}
