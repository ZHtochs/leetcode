package com.huawei.offer2.leetcode.editor.cn;

//在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。 
//
// 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。 
//
// 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。 
//
// 返回 所有三个投影的总面积 。 
//
// 
//
// 
// 
//
// 
// 
//
// 
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[[1,2],[3,4]]
//输出：17
//解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
// 
//
// 示例 2: 
//
// 
//输入：grid = [[2]]
//输出：5
// 
//
// 示例 3： 
//
// 
//输入：[[1,0],[0,2]]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 50 
// 0 <= grid[i][j] <= 50 
// 
// 👍 137 👎 0


//Java：三维形体投影面积
public class P883ProjectionAreaOf3dShapes{
    public static void main(String[] args) {
        Solution solution = new P883ProjectionAreaOf3dShapes().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public  int projectionArea(int[][] grid) {
            int flat = 0;
            int[] lines = new int[grid.length];
            int[] rows = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    final int temp = grid[i][j];
                    lines[i] = Math.max(lines[i], temp);
                    rows[j] = Math.max(rows[j], temp);
                    if (temp != 0) {
                        flat++;
                    }
                }
            }
            int lineSum = 0;
            for (int a : lines) {
                lineSum += a;
            }
            int rowsSum = 0;
            for (int a : rows) {
                rowsSum += a;
            }
            return flat + lineSum + rowsSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}