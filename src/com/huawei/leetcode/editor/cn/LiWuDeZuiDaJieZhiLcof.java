package com.huawei.leetcode.editor.cn;

//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 164 👎 0

public class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
        int[][] ints = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.maxValue(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid;
        int[][] visit;

        public int maxValue(int[][] grid) {
            this.grid = grid;
            visit = new int[grid.length][grid[0].length];
            return recur(grid.length - 1, grid[0].length - 1);
        }

        private int recur(int length, int i) {
            if (length == 0 && i == 0) {
                return grid[0][0];
            }
            if (visit[length][i] != 0) {
                return visit[length][i];
            }
            if (length == 0) {
                return recur(length, i - 1) + grid[0][i];
            }
            if (i == 0) {
                return recur(length - 1, i) + grid[length][0];
            }
            int value = Math.max(recur(length - 1, i), recur(length, i - 1)) + grid[length][i];
            visit[length][i] = value;
            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}