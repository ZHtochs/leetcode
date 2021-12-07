package com.huawei.offer2.leetcode.editor.cn;

//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 两个网格块属于同一 连通分量 需满足下述全部条件： 
//
// 
// 两个网格块颜色相同 
// 在上、下、左、右任意一个方向上相邻 
// 
//
// 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块： 
//
// 
// 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻 
// 在网格的边界上（第一行/列或最后一行/列） 
// 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// 👍 125 👎 0

import java.util.HashSet;
import java.util.Set;

//Java：边界着色
public class P1034ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new P1034ColoringABorder().new Solution();
//        int[][] ints = solution.colorBorder(new int[][]{{1, 1}, {1, 2}}, 0, 0, 3);
        int[][] ints = solution.colorBorder(new int[][]{{1, 2, 2}, {2, 3, 2}}, 0, 1, 3);
//        ints = solution.colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2);
        System.out.println("!23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean[][] visited;

        private Set<String> set = new HashSet<>();

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int target = grid[row][col];
            visited = new boolean[grid.length][grid[0].length];
            dfs(grid, row, col, target);
            for (String s : set) {
                String[] strings = s.split(" ");
                int i = Integer.parseInt(strings[0]);
                int j = Integer.parseInt(strings[1]);
                grid[i][j] = color;
            }
            return grid;
        }

        void dfs(int[][] grids, int row, int col, final int target) {
            if (row < 0 || row == grids.length || col < 0 || col == grids[0].length) {
                return;
            }
            if (visited[row][col] || grids[row][col] != target) {
                return;
            }
            visited[row][col] = true;
            if (grids[row][col] == target) {
                if (row == 0 || row == grids.length - 1 || col == 0 || col == grids[0].length - 1) {
                    set.add(row + " " + col);
                } else if (grids[row - 1][col] != target || grids[row + 1][col] != target || grids[row][col - 1] != target || grids[row][col + 1] != target)
                    set.add(row + " " + col);
            }

            dfs(grids, row - 1, col, target);
            dfs(grids, row + 1, col, target);
            dfs(grids, row, col + 1, target);
            dfs(grids, row, col - 1, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}