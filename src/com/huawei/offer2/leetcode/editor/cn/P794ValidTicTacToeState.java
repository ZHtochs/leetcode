package com.huawei.offer2.leetcode.editor.cn;

//给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，
// 棋盘有可能达到 board 所显示的状态时，才返回 true 。
//
// 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（' '）中。 
// 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。 
// 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = ["O  ","   ","   "]
//输出：false
//解释：玩家 1 总是放字符 "X" 。
// 
//
// 示例 2： 
//
// 
//输入：board = ["XOX"," X ","   "]
//输出：false
//解释：玩家应该轮流放字符。 
//
// 示例 3： 
//
// 
//输入：board = ["XXX","   ","OOO"]
//输出：false
// 
//
// Example 4: 
//
// 
//输入：board = ["XOX","O O","XOX"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// board.length == 3 
// board[i].length == 3 
// board[i][j] 为 'X'、'O' 或 ' ' 
// 
// 👍 98 👎 0

//Java：有效的井字游戏
public class P794ValidTicTacToeState {
    public static void main(String[] args) {
        Solution solution = new P794ValidTicTacToeState().new Solution();
        boolean a = solution.validTicTacToe(new String[]{"XXX", "   ", "OOO"});
        System.out.println(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean validTicTacToe(String[] board) {
            char[][] chars = new char[][]{board[0].toCharArray(), board[1].toCharArray(), board[2].toCharArray()};
            int xCount = 0;
            int oCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (chars[i][j] == 'X') {
                        xCount++;
                    }
                    if (chars[i][j] == 'O') {
                        oCount++;
                    }
                }
            }
            if (xCount < oCount || xCount - oCount >= 2) {
                return false;
            }
            int xThree = 0;
            int oThree = 0;

            // 遍历每一行
            for (int i = 0; i < 3; i++) {
                char[] temp = chars[i];
                if (temp[0] == temp[1] && temp[0] == temp[2]) {
                    if (temp[0] == 'X') {
                        xThree++;
                    }
                    if (temp[0] == 'O') {
                        oThree++;
                    }
                }
            }

            // 遍历每一列
            for (int i = 0; i < 3; i++) {
                if (chars[0][i] == chars[1][i] && chars[0][i] == chars[2][i]) {
                    if (chars[0][i] == 'X') {
                        xThree++;
                    }
                    if (chars[0][i] == 'O') {
                        oThree++;
                    }
                }
            }

            //对角线
            if (chars[0][0] == chars[1][1] && chars[0][0] == chars[2][2]) {
                if (chars[0][0] == 'X') {
                    xThree++;
                }
                if (chars[0][0] == 'O') {
                    oThree++;
                }
            }

            //对角线
            if (chars[0][2] == chars[1][1] && chars[0][2] == chars[2][0]) {
                if (chars[0][2] == 'X') {
                    xThree++;
                }
                if (chars[0][2] == 'O') {
                    oThree++;
                }
            }
            if (xThree >= 1 && oThree >= 1) {
                return false;
            }
            if (xThree >= 1 && xCount <= oCount) {
                return false;
            }
            if (oThree >= 1 && xCount != oCount) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}