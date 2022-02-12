package com.huawei.offer2.leetcode.editor.cn;

//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// 👍 143 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

//Java：飞地的数量
public class P1020NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new P1020NumberOfEnclaves().new Solution();
        System.out.println(solution.numEnclaves(ListNode.getIntArrays("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]")));
        System.out.println(solution.numEnclaves(ListNode.getIntArrays("[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
                        if (grid[i][j] == 1) {
                            dfs(grid, i, j);
                        }
                    }
                }
            }
            int res = 0;
            for (int[] ints : grid) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (ints[j] == 1) {
                        res++;
                    }
                }
            }
            return res;
        }
        private void dfs(int[][] grids, int i, int j) {
            if (i < 0 || i == grids.length || j < 0 || j == grids[0].length || grids[i][j] == 0) {
                return;
            }
            grids[i][j] = 0;
            dfs(grids, i - 1, j);
            dfs(grids, i + 1, j);
            dfs(grids, i, j - 1);
            dfs(grids, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}