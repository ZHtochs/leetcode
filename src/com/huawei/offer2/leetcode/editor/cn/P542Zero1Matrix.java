package com.huawei.offer2.leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// 👍 578 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.LinkedList;

//Java：01 矩阵
public class P542Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new P542Zero1Matrix().new Solution();
        int[][] ints = solution.updateMatrix(ListNode.getIntArrays("[0,0,0],[0,1,0],[1,1,1]"));
        System.out.println("!23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] mat;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public int[][] updateMatrix(int[][] mat) {
            int length = mat.length;
            int height = mat[0].length;
            boolean[][] visited = new boolean[length][height];
            int[][] res = new int[length][height];
            LinkedList<int[]> linkedList = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (mat[i][j] == 0) {
                        res[i][j] = 0;
                        visited[i][j] = true;
                        linkedList.offer(new int[]{i, j});
                    }
                }
            }
            while (!linkedList.isEmpty()) {
                int[] poll = linkedList.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = poll[0] + dx[i];
                    int newY = poll[1] + dy[i];
                    if (newX >= 0 && newX < length && newY >= 0 && newY < height && !visited[newX][newY]) {
                        res[newX][newY] = res[poll[0]][poll[1]] + 1;
                        linkedList.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}