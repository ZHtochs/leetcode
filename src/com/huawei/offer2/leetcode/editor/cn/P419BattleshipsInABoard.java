package com.huawei.offer2.leetcode.editor.cn;

//给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的
// 战舰 的数量。 
//
// 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以
//是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：board = [["."]]
//输出：0
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
// board[i][j] 是 '.' 或 'X' 
// 
//
// 
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？ 
// 👍 176 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

//Java：甲板上的战舰
public class P419BattleshipsInABoard {
    public static void main(String[] args) {
        Solution solution = new P419BattleshipsInABoard().new Solution();
        char[][] chars = ListNode.getCharArrays("XXX");
        System.out.println(solution.countBattleships(chars));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBattleships(char[][] board) {
            int sum = 0;
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                char[] chars = board[i];
                boolean hasX = false;
                for (int j = 0; j < n; j++) {
                    if (chars[j] == 'X') {
                        if (isSingle(board, i, j)) {
                            sum++;
                        } else {
                            if (j == n - 1) {
                                if (hasX) {
                                    hasX = false;
                                    sum++;
                                }
                            } else {
                                hasX = true;
                            }
                        }
                    } else {
                        if (hasX) {
                            sum++;
                            hasX = false;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                boolean hasX = false;
                for (int j = 0; j < m; j++) {
                    char c = board[j][i];
                    if (c == 'X') {
                        if (!isSingle(board, j, i)) {
                            hasX = true;
                        }
                        if (hasX && j == m - 1) {
                            sum++;
                            hasX = false;
                        }
                    } else {
                        if (hasX) {
                            sum++;
                            hasX = false;
                        }
                    }
                }
            }
            return sum;
        }

        private boolean isSingle(char[][] board, int i, int j) {
            boolean isSingle = true;
            int m = board.length;
            int n = board[0].length;
            if (i - 1 >= 0) {
                isSingle = board[i - 1][j] == '.';
            }
            if (i + 1 <= m - 1) {
                isSingle = isSingle && board[i + 1][j] == '.';
            }
            if (j - 1 >= 0) {
                isSingle = isSingle && board[i][j - 1] == '.';
            }
            if (j + 1 <= n - 1) {
                isSingle = isSingle && board[i][j + 1] == '.';
            }
            return isSingle;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}