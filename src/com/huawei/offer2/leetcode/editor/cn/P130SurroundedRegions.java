package com.huawei.offer2.leetcode.editor.cn;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// 👍 734 👎 0

//Java：被围绕的区域
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            int length = board.length;
            int height = board[0].length;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (i == 0 || j == 0 || i == length - 1 || j == height - 1) {
                        if (board[i][j] == 'O') {
                            dfs(i, j, board);
                        }
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void dfs(int i, int j, char[][] board) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'A') {
                return;
            }
            board[i][j] = 'A';
            dfs(i + 1, j, board);
            dfs(i - 1, j, board);
            dfs(i, j + 1, board);
            dfs(i, j - 1, board);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}