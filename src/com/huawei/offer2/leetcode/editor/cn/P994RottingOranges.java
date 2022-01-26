package com.huawei.offer2.leetcode.editor.cn;

//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// 👍 477 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.LinkedList;
import java.util.List;

//Java：腐烂的橘子
public class P994RottingOranges {
    public static void main(String[] args) {
        Solution solution = new P994RottingOranges().new Solution();
        System.out.println(solution.orangesRotting(ListNode.getIntArrays("[[2,1,1],[1,1,0],[0,1,1]]")));
        System.out.println(solution.orangesRotting(ListNode.getIntArrays("[[2,1,1],[0,1,1],[1,0,1]]")));
        System.out.println(solution.orangesRotting(ListNode.getIntArrays("[[0,2]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] mat;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public int orangesRotting(int[][] mat) {
            int length = mat.length;
            int height = mat[0].length;
            boolean[][] visited = new boolean[length][height];

            int count = 0;
            LinkedList<int[]> linkedList = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (mat[i][j] == 2) {
                        visited[i][j] = true;
                        linkedList.offer(new int[]{i, j});
                    }
                    if (mat[i][j] == 1) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                return 0;
            }
            if (linkedList.isEmpty()) {
                return -1;
            }
            int day = 0;
            while (!linkedList.isEmpty()) {
                int size = linkedList.size();
                day++;
                while (size > 0) {
                    int[] poll = linkedList.poll();
                    for (int i = 0; i < 4; i++) {
                        int newX = poll[0] + dx[i];
                        int newY = poll[1] + dy[i];
                        if (newX >= 0 && newX < length && newY >= 0 && newY < height && !visited[newX][newY]) {
                            if (mat[newX][newY] == 1) {
                                linkedList.offer(new int[]{newX, newY});
                                count--;
                            }
                            visited[newX][newY] = true;
                        }
                    }
                    size--;
                }
            }
            if (count > 0) {
                return -1;
            }
            return day - 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}