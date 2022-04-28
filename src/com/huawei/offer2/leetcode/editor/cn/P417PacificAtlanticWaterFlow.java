package com.huawei.offer2.leetcode.editor.cn;

//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// 👍 463 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：太平洋大西洋水流问题
public class P417PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        Solution solution = new P417PacificAtlanticWaterFlow().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] heights;

        private int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;
            boolean[][] visited1 = new boolean[heights.length][heights[0].length];
            boolean[][] visited2 = new boolean[heights.length][heights[0].length];
            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < heights[0].length; j++) {
                    if (i == 0 || j == 0) {
                        dfs(i, j, visited1);

                    }
                    if (i == heights.length - 1 || j == heights[0].length - 1) {
                        dfs(i, j, visited2);

                    }
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < heights[0].length; j++) {
                    if (visited1[i][j] && visited2[i][j]) {
                        List<Integer> arrayList = Arrays.asList(i, j);
                        res.add(arrayList);
                    }
                }
            }
            return res;
        }

        private void dfs(int i, int j, boolean[][] visited) {
            if (visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            for (int[] ints : direction) {
                int newX = i + ints[0];
                int newY = j + ints[1];
                if (newX < 0 || newX >= heights.length || newY < 0 || newY >= heights[0].length) {
                    continue;
                }
                int val = heights[i][j];
                int newVal = heights[newX][newY];
                if (newVal >= val) {
                    dfs(newX, newY, visited);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}