package com.huawei.leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 329 👎 0

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(solution.movingCount(11, 8, 16));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] map;
        int m;
        int n;
        int count;

        public int movingCount(int m, int n, int k) {
            map = new int[m][n];
            this.m = m;
            this.n = n;
            dfs(0, 0, k);
            return count;
        }

        private boolean dfs(int i, int j, int k) {
            if (i >= m || i < 0 || j < 0 || j >= n || get(i) + get(j) > k || map[i][j] == -1) {
                return false;
            }
            map[i][j] = -1;
            count++;
            boolean result = dfs(i + 1, j, k) || dfs(i - 1, j, k) || dfs(i, j + 1, k) || dfs(i, j - 1, k);
            return result;
        }

        private int get(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}