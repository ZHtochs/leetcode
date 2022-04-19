package com.huawei.offer2.leetcode.editor.cn;

//给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 
//false。 
//
// 从点 (x, y) 可以转换到 (x, x+y) 或者 (x+y, y)。 
//
// 
//
// 示例 1: 
//
// 
//输入: sx = 1, sy = 1, tx = 3, ty = 5
//输出: true
//解释:
//可以通过以下一系列转换从起点转换到终点：
//(1, 1) -> (1, 2)
//(1, 2) -> (3, 2)
//(3, 2) -> (3, 5)
// 
//
// 示例 2: 
//
// 
//输入: sx = 1, sy = 1, tx = 2, ty = 2 
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: sx = 1, sy = 1, tx = 1, ty = 1 
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 1 <= sx, sy, tx, ty <= 10⁹ 
// 
// 👍 211 👎 0

//Java：到达终点
public class P780ReachingPoints {
    public static void main(String[] args) {
        Solution solution = new P780ReachingPoints().new Solution();

        System.out.println(solution.reachingPoints(1, 8, 4, 15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (tx > 0 && ty > 0) {
                if (tx == sx && ty == sy) {
                    return true;
                }
                if (tx < sx || ty < sy) {
                    return false;
                }
                if (tx > ty) {
                    tx = min(tx, ty, sx);
                } else if (ty > tx) {
                    ty = min(ty, tx, sy);
                } else {
                    return false;
                }
            }
            return false;
        }

        private int min(int larger, int smaller, int target) {
            if (smaller == 1) {
                return target;
            }
            if (larger % smaller == 0) {
                if (smaller > target) {
                    return smaller;
                }
            }
            if (larger / smaller < 1) {
                return larger - smaller;
            } else {
                int i = larger % smaller;
                if (i < target) {
                    return larger - smaller;
                } else {
                    return larger % smaller;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}