package com.huawei.leetcode.editor.cn;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 284 👎 0

import java.util.ArrayList;

public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] ints = {{1, 1}, {4, 4}, {6, 6}};
        ListNode.printInt(solution.spiralOrder(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }
            ArrayList<Integer> arrayList = new ArrayList<>(matrix.length * matrix[0].length);
            int left = 0, top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
            int i = 0, j = 0;
            int[] directions = {0, 1, 2, 3};
            int direction = 0;
            arrayList.add(matrix[0][0]);
            while (left <= right && top <= bottom) {
                switch (direction) {
                    case 0:
                        if (j < right) {
                            j++;
                            arrayList.add(matrix[i][j]);
                        } else {
                            direction = directions[(direction + 1) % 4];
                            top++;
                        }
                        break;
                    case 1:
                        if (i < bottom) {
                            i++;
                            arrayList.add(matrix[i][j]);
                        } else {
                            direction = directions[(direction + 1) % 4];
                            right--;
                        }
                        break;
                    case 2:
                        if (j > left) {
                            j--;
                            arrayList.add(matrix[i][j]);
                        } else {
                            direction = directions[(direction + 1) % 4];
                            bottom--;
                        }
                        break;
                    case 3:
                        if (i > top) {
                            i--;
                            arrayList.add(matrix[i][j]);
                        } else {
                            direction = directions[(direction + 1) % 4];
                            left++;
                        }
                }
            }
            return arrayList.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}